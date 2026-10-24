import com.jsonscraper.instagram.Instagram;
import java.util.Map;
import java.nio.charset.StandardCharsets;
public class Feed {public static void main(String[] args)throws Exception{var c=new Instagram(System.getenv("JSONSCRAPER_INSTAGRAM_LICENSE_KEY"));var r=c.request("/v1/user/medias/chunk",Map.of("user_id", "5821462185", "end_cursor", "", "cache_timeout", 60));System.out.println(new String(r.body(),StandardCharsets.UTF_8));}}
