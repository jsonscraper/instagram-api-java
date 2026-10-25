package com.jsonscraper.instagram;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;

/** Thread-safe HTTP transport. Responses retain raw JSON/binary bytes. */
public class Client {
    private final String key, baseUrl;
    private final Duration timeout;
    private final int retries;
    private final Integer cacheTimeout;
    private final HttpClient http;
    public static final class APIException extends IOException {
        private static final long serialVersionUID=1L;
        public final int status;
        public final String retryAfter;
        public APIException(int status, String retryAfter) {super("jsonscraper API returned HTTP "+status);this.status=status;this.retryAfter=retryAfter;}
    }
    public Client(String key) {this(key,null,Duration.ofSeconds(30),0,null);}
    public Client(String key, String baseUrl, Duration timeout, int retries, Integer cacheTimeout) {
        if(key==null || key.isBlank()) throw new IllegalArgumentException("A product and license key are required");
        if(baseUrl==null)baseUrl="https://ig.jsonscraper.com";
        URI u;try{u=URI.create(baseUrl);}catch(Exception e){throw new IllegalArgumentException("Invalid base URL");}
        if(u.getHost()==null || u.getUserInfo()!=null || u.getQuery()!=null || u.getFragment()!=null || !("https".equals(u.getScheme()) || ("http".equals(u.getScheme()) && Set.of("localhost","127.0.0.1","[::1]").contains(u.getHost())))) throw new IllegalArgumentException("Use an HTTPS base URL");
        if(timeout==null || timeout.isNegative() || timeout.isZero() || retries<0 || retries>5)throw new IllegalArgumentException("Invalid timeout or retries");
        this.key=key;this.baseUrl=baseUrl.replaceAll("/+$","");this.timeout=timeout;this.retries=retries;this.cacheTimeout=cacheTimeout;
        this.http=HttpClient.newBuilder().connectTimeout(timeout).followRedirects(HttpClient.Redirect.NEVER).build();
    }
    private static String encode(String value){return URLEncoder.encode(value,StandardCharsets.UTF_8);}
    public HttpResponse<byte[]> request(String path, Map<String,?> params) throws IOException,InterruptedException {
        if(path==null || !path.matches("/[A-Za-z0-9_/-]+") || path.contains("//") || path.contains(".."))throw new IllegalArgumentException("Use an API path, not a URL");
        Map<String,Object> q=new LinkedHashMap<>();if(params!=null)params.forEach((k,v)->{if(v!=null)q.put(k,v);});
        if(cacheTimeout!=null)q.putIfAbsent("cache_timeout",cacheTimeout);q.put("license_key",key);
        StringJoiner query=new StringJoiner("&");q.forEach((k,v)->query.add(encode(k)+"="+encode(v.toString())));
        var req=HttpRequest.newBuilder(URI.create(baseUrl+path+"?"+query)).timeout(timeout).header("Accept","application/json").header("User-Agent","jsonscraper-java/0.1.1").GET().build();
        for(int attempt=0;attempt<=retries;attempt++){
            HttpResponse<byte[]> response;
            try{response=http.send(req,HttpResponse.BodyHandlers.ofByteArray());}catch(IOException e){throw new IOException("Unable to reach jsonscraper API");}
            int status=response.statusCode();if(status>=200 && status<300)return response;
            String retry=response.headers().firstValue("Retry-After").orElse("");
            if(attempt==retries || !Set.of(429,502,503,504).contains(status))throw new APIException(status,retry);
            long delay=1L<<attempt;try{if(retry.matches("\\d+"))delay=Math.min(60,Long.parseLong(retry));}catch(NumberFormatException ignored){}
            Thread.sleep(delay*1000);
        }
        throw new IOException("Request failed");
    }
}
