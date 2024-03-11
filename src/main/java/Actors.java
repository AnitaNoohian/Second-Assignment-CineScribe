import org.json.JSONObject;
import org.json.JSONString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.ArrayList;

public class Actors {
    public static final String API_KEY = "efdbDcPXH0/BEAckf5Nc1Q==9aypcnbi5XIVKWk9";   // TODO --> add your api key about Actors here
    int netWorth;
    boolean isAlive;
    String gender;
    double height;
    String birthday;
    int age;
    String nationality;

    public Actors(int netWorth, boolean isAlive){
        //TODO --> (Write a proper constructor using the get_from_api functions)
        this.isAlive = isAlive;
        this.netWorth = netWorth;
    }
    @SuppressWarnings({"deprecation"})
    /**
     * Retrieves data for the specified actor.
     * @param name for which Actor should be retrieved
     * @return a string representation of the Actors info or null if an error occurred
     */
    public String getActorData(String name) {
        try {
            URL url = new URL("https://api.api-ninjas.com/v1/celebrity?name="+
                    name.replace(" ", "+")+"&apikey="+API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("X-Api-Key", API_KEY);
            //System.out.println(connection);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                //System.out.println(response.toString());
                return response.toString();
            } else {
                return "Error: " + connection.getResponseCode() + " " + connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean actorErrorHandling(String actorsInfoJson){
        String actorsInfo = actorsInfoJson.substring(1,actorsInfoJson.length()-1);
        if (actorsInfo == ""){
            return false;
        }
        return true;
    }
    public int getNetWorthViaApi(String actorsInfoJson){
        //TODO --> (This function must return the "NetWorth")
        String actorsInfo = actorsInfoJson.substring(1,actorsInfoJson.length()-1);
        JSONObject actorNetWorth = new JSONObject(actorsInfo);
        netWorth = actorNetWorth.getInt("net_worth");
        return netWorth;
    }

    public boolean isAlive(String actorsInfoJson){
        //TODO --> (If your chosen actor is alive it must return true otherwise it must return false)
        String actorsInfo = actorsInfoJson.substring(1,actorsInfoJson.length()-1);
        JSONObject Alive = new JSONObject(actorsInfo);
        isAlive = Alive.getBoolean("is_alive");
        return isAlive;
    }

    public String getDateOfDeathViaApi(String actorsInfoJson){
        //TODO --> (If your chosen actor is deceased it must return the date of death)  -->
        if (!isAlive(actorsInfoJson)) {
            String actorsInfo = actorsInfoJson.substring(1,actorsInfoJson.length()-1);
            JSONObject death = new JSONObject(actorsInfo);
            String dateofDeath = death.getString("death");
            return dateofDeath;
        }
        else{
            return "-";
        }
    }

    public String getNationalityViaApi(String actorsInfoJson){
        String actorsInfo = actorsInfoJson.substring(1,actorsInfoJson.length()-1);
        JSONObject jsonObject = new JSONObject(actorsInfo);
        nationality = jsonObject.getString("nationality");
        return nationality;
    }

    public String getBirthdayViaApi(String actorsInfoJson){
        String actorsInfo = actorsInfoJson.substring(1,actorsInfoJson.length()-1);
        JSONObject jsonObject = new JSONObject(actorsInfo);
        birthday = jsonObject.getString("birthday");
        return birthday;
    }

    public String getGenderViaAPi(String actorsInfoJson){
        String actorsInfo = actorsInfoJson.substring(1,actorsInfoJson.length());
        JSONObject jsonObject = new JSONObject(actorsInfo);
        gender = jsonObject.getString("gender");
        return gender;
    }

    public double getHeightViaAPi(String actorsInfoJson){
        String actorsInfo = actorsInfoJson.substring(1,actorsInfoJson.length());
        JSONObject jsonObject = new JSONObject(actorsInfo);
        height = jsonObject.getDouble("height");
        return height;
    }

    public int getAgeViaAPi(String actorsInfoJson){
        String actorsInfo = actorsInfoJson.substring(1,actorsInfoJson.length());
        JSONObject jsonObject = new JSONObject(actorsInfo);
        age = jsonObject.getInt("age");
        return age;
    }
}