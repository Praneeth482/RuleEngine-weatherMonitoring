import java.net.URI;
	import java.net.http.HttpClient;
	import java.net.http.HttpRequest;
	import java.net.http.HttpResponse;
	import org.json.JSONObject;

public class weatherDataCollector {
	
	    private static final String API_KEY = "c4b74a35c88d3c91be9a7a83d9b64fa0";
	    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=c4b74a35c88d3c91be9a7a83d9b64fa0&units=metric";

	    
	    public JSONObject getWeatherData(String city) {
	        try {
	            String url = BASE_URL + city + "&appid=" + API_KEY+ "&units=metric";
	            HttpClient client = HttpClient.newHttpClient();
	            HttpRequest request = HttpRequest.newBuilder()
	                    .uri(URI.create(url))
	                    .build();

	            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

	            if (response.statusCode() == 200) {
	                return new JSONObject(response.body());
	            } else {
	                System.out.println("Error: " + response.statusCode());
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	}


