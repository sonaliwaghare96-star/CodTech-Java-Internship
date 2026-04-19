import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        try {
            // STEP 1: API URL (Nagpur weather)
            String urlString = "123456789";

            // STEP 2: Create URL object
            URL url = new URL(urlString);
            // STEP 3: Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // STEP 4: Get response code
            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {

                // STEP 5: Read API response
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));

                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                String json = response.toString();

                // STEP 6: Correct parsing
                String temp = json.split("\"temp\":")[1].split(",")[0];
                String windspeed = json.split("\"speed\":")[1].split(",")[0];

                // STEP 7: Output
                System.out.println("WEATHER REPORT");
                System.out.println("---------------------");
                System.out.println("Temperature: " + temp + " °C");
                System.out.println("Wind Speed: " + windspeed + " m/s");
            } else {
                System.out.println("Error: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
