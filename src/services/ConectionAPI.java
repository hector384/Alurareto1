package services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class ConectionAPI {
    private String Api_key = "14996a3989157d111e32c74f";
    public String getConversion (String query) throws IOException, InterruptedException {
        String fetch_query = "https://v6.exchangerate-api.com/v6/" + Api_key + "/pair" + query;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fetch_query))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
                String jsonString = response.body();
                JSONObject jsonObject = new JSONObject(jsonString);
                double conversionResult = jsonObject.getDouble("conversion_result");
                String resultString = String.valueOf(conversionResult);
        return resultString;
    }
}
