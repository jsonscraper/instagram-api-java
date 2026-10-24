import com.jsonscraper.instagram.Instagram;
import java.util.Map;
import java.nio.charset.StandardCharsets;
public class Search {public static void main(String[] args)throws Exception{var c=new Instagram(System.getenv("JSONSCRAPER_INSTAGRAM_LICENSE_KEY"));var r=c.request("/v1/search/users",Map.of("query", "apple", "cache_timeout", 60));System.out.println(new String(r.body(),StandardCharsets.UTF_8));}}
