import com.jsonscraper.instagram.Instagram;
import java.util.Map;
import java.nio.charset.StandardCharsets;

public class Example {
 public static void main(String[] args) throws Exception {
  var client = new Instagram(System.getenv("JSONSCRAPER_INSTAGRAM_LICENSE_KEY"));
  var response = client.v1_user_by_username(Map.of("username", "apple", "cache_timeout", 60));
  System.out.println(new String(response.body(), StandardCharsets.UTF_8));
 }
}
