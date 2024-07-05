import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertCurrency {
    public Rate calcAmount (int baseCode, int targetCode) {
        URI urlAddress = URI.create("https://v6.exchangerate-api.com/v6/88e44fed554450c00c22e991/pair/"+baseCode+"/"+targetCode);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(urlAddress).build();
        try {
            HttpResponse<String> response;
            response=client.send(request, HttpResponse.BodyHandlers.ofString());
            return  new Gson().fromJson(response.body(),Rate.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
