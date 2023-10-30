import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RiotGamesApi {
    public static void match(String api_key, String matchId) {
        //api_key << apikey 넘겨받기
        //matchId << matchId 넘겨받기
        // HTTP 클라이언트 생성
        HttpClient httpClient = HttpClients.createDefault();

        // 요청 헤더 설정
        HttpGet request = new HttpGet("https://asia.api.riotgames.com/lol/match/v5/matches/" + matchId);
        request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 Safari/537.36");
        request.addHeader("Accept-Language", "ko,en-US;q=0.9,en;q=0.8,es;q=0.7");
        request.addHeader("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8");
        request.addHeader("Origin", "https://developer.riotgames.com");
        request.addHeader("X-Riot-Token", api_key);

        try {
            // 요청 보내기
            HttpResponse response = httpClient.execute(request);

            // 응답 데이터 읽기
            String responseBody = EntityUtils.toString(response.getEntity());

            // JSON 응답 데이터
            System.out.println(responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}










{
  "key1": {"value1", "value2"}
  "key2": 42
}

String keyValue1 = myJsonObject.getKey1();

keyValue1 >> ["value1", "value2"]
keyValue1[1] >> value1
keyValue1[2] >> value2