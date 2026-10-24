import com.jsonscraper.instagram.Client;
import java.time.Duration;
import java.util.Map;
public class Runner {
 public static void main(String[] args) throws Exception {
  try {
   double timeout=Double.parseDouble(System.getenv().getOrDefault("TIMEOUT","3"));
   var c=new Client("contract-secret",System.getenv("BASE_URL"),Duration.ofMillis((long)(timeout*1000)),Integer.parseInt(System.getenv().getOrDefault("RETRIES","0")),null);
   var r=c.request(System.getenv("API_PATH"),Map.of("video_id","a&b?x=1+/Ю","license_key","override","count",0,"flag",false));System.out.write(r.body());
  }catch(Client.APIException e){System.out.print("{\"error\":"+e.status+"}");}catch(Exception e){System.out.print("{\"error\":\"transport\"}");}
 }
}
