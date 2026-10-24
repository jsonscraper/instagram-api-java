import com.jsonscraper.instagram.Instagram;
import java.util.Map;
import java.nio.charset.StandardCharsets;
public class Media {public static void main(String[] args)throws Exception{var c=new Instagram(System.getenv("JSONSCRAPER_INSTAGRAM_LICENSE_KEY"));var r=c.request("/v1/media/by/code",Map.of("code", "DT23hQ-EgkI", "cache_timeout", 60));System.out.println(new String(r.body(),StandardCharsets.UTF_8));}}
