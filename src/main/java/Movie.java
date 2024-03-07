import org.json.JSONArray;
import org.json.JSONObject;

import java.net.SocketTimeoutException;
import java.util.List;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.util.ArrayList;
public class Movie {
    public static final String API_KEY = "6be1cbc8";   // TODO --> add your api key about Movie here
    int ImdbVotes;
    String year;
    String release;
    String director;
    String genre;
    ArrayList<String> actorsList;
    String rating;

    public Movie(){

    }
    public Movie(ArrayList<String> actorsList, String rating, int ImdbVotes){
        //TODO --> (Write a proper constructor using the get_from_api functions)
        this.actorsList = actorsList;
        this.ImdbVotes = ImdbVotes;
        this.rating = rating;
    }

    @SuppressWarnings("deprecation")
    /**
     * Retrieves data for the specified movie.
     *
     * @param title the name of the title for which MovieData should be retrieved
     * @return a string representation of the MovieData, or null if an error occurred
     */

    public String getMovieData(String title) throws IOException {
        URL url = new URL("https://www.omdbapi.com/?t="+title+"&apikey="+API_KEY);
        URLConnection Url = url.openConnection();
        Url.setRequestProperty("Authorization", "Key" + API_KEY);
        BufferedReader reader = new BufferedReader(new InputStreamReader(Url.getInputStream()));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine())!=null) {
            stringBuilder.append(line);
        }
        reader.close();
        //handle an error if the chosen movie is not found
        return stringBuilder.toString();
    }
    public int getImdbVotesViaApi(String moviesInfoJson){
        //TODO --> (This function must change and return the "ImdbVotes" as an Integer)

        JSONObject Imdb = new JSONObject(moviesInfoJson);
        ImdbVotes = Integer.parseInt(Imdb.getString("imdbVotes").replace(",",""));
        return ImdbVotes;

        // NOTICE :: you are not permitted to convert this function to return a String instead of an int !!!
    }

    public String getRatingViaApi(String moviesInfoJson){
        //TODO --> (This function must return the rating in the "Ratings" part
        // where the source is "Internet Movie Database")  -->
        JSONObject jsonArray = new JSONObject(moviesInfoJson);
        JSONArray Rating = jsonArray.getJSONArray("Ratings");
        rating = null;
        for (int i = 0; i < Rating.length(); i++){
            JSONObject rate = Rating.getJSONObject(i);
            if (rate.getString("Source").equals("Internet Movie Database")){
                rating = rate.getString("Value");
            }
        }

        return rating;
    }

    public ArrayList<String> getActorListViaApi(String moviesInfoJson){
        //TODO --> (This function must return the "Actors" in actorsList)
        JSONObject jsonObject = new JSONObject(moviesInfoJson);
        String actors = jsonObject.getString("Actors");
        String[] arrayList = actors.split(", ");
        for (String i : arrayList){
            actorsList.add(i);
        }

        return actorsList;
    }

    public String getYearViaApi(String moviesInfoJson){
        JSONObject jsonObject = new JSONObject(moviesInfoJson);
        year = jsonObject.getString("Year");
        return year;
    }

    public String getReleaseViaApi(String moviesInfoJson){
        JSONObject jsonObject = new JSONObject(moviesInfoJson);
        release = jsonObject.getString("Release");
        return release;
    }

    public String getGenreViaApi(String moviesInfoJson){
        JSONObject jsonObject = new JSONObject(moviesInfoJson);
        genre = jsonObject.getString("Genre");
        return genre;
    }

    public String getDirectorViaApi(String moviesInfoJson){
        JSONObject jsonObject = new JSONObject(moviesInfoJson);
        director = jsonObject.getString("Director");
        return director;
    }

}