import org.json.JSONObject;

public class weatherDataProcessor {

    
    public void processWeatherData(JSONObject weatherData) {
       
        double temp = weatherData.getJSONObject("main").getDouble("temp");
        System.out.println("Raw temperature in Kelvin: " + temp);
    }

    
    public double convertKelvinToCelsius(double tempInKelvin) {
        return tempInKelvin - 273.15;
    }


    public double getAverageTemp(JSONObject weatherData) {
      
        double tempInKelvin = weatherData.getJSONObject("main").getDouble("temp");
        return convertKelvinToCelsius(tempInKelvin);
    }

    
    public double getMaxTemp(JSONObject weatherData) {
        
        double maxTempInKelvin = weatherData.getJSONObject("main").getDouble("temp_max");
        return convertKelvinToCelsius(maxTempInKelvin);
    }

    
    public double getMinTemp(JSONObject weatherData) {
     
        double minTempInKelvin = weatherData.getJSONObject("main").getDouble("temp_min");
        return convertKelvinToCelsius(minTempInKelvin);
    }
}
