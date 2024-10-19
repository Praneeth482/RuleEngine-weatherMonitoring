import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DataBaseConnection {		
	    private Connection connect() throws SQLException {
	        String url = "jdbc:oracle:thin:@localhost:1521:orcl\r\n"; 
	        String user = "scott"; 
	        String password = "tiger";

	        return DriverManager.getConnection(url, user, password);
	    }
	    public void saveWeatherSummary(String city, double avgTemp, double maxTemp, double minTemp) {
	        String insertSQL = "INSERT INTO weather_summary (city, avg_temp, max_temp, min_temp) VALUES (?, ?, ?, ?)";

	        try (Connection conn = connect();
	             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

	            pstmt.setString(1, city);
	            pstmt.setDouble(2, avgTemp);
	            pstmt.setDouble(3, maxTemp);
	            pstmt.setDouble(4, minTemp);

	            pstmt.executeUpdate();
	            System.out.println("Weather summary saved to the database.");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


