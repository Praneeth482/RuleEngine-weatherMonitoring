import org.json.JSONObject;

public class weatherApp {
	    public static void main(String[] args) {
	        weatherDataCollector collector = new weatherDataCollector();
	        weatherDataProcessor processor = new weatherDataProcessor();
	        weatherAlertSystem alertSystem = new weatherAlertSystem();
	        DataBaseConnection dbConnection = new DataBaseConnection();
	        String city = "Mumbai";
	        JSONObject weatherData = collector.getWeatherData(city);

	        if (weatherData != null) {
	            processor.processWeatherData(weatherData);
	            double avgTemp = processor.getAverageTemp(weatherData);  
	            double maxTemp = processor.getMaxTemp(weatherData);      
	            double minTemp = processor.getMinTemp(weatherData);    
	            
	          
	            dbConnection.saveWeatherSummary(city, avgTemp, maxTemp, minTemp);

	            
	            alertSystem.checkTemperatureAlert(avgTemp, 35.0); 
	        }
	    }
	}


