import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO --> complete main function
        runMenu();

        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        if (input == 1){
            System.out.println("Please enter the movie/series name that you want the information of:");
            Scanner mv = new Scanner(System.in);
            String movieName = mv.nextLine();

            Movie movie = new Movie(new ArrayList<>(),"",0);
            String moviesInfoJson = movie.getMovieData(movieName);

            System.out.println("\nName: " + movieName);
            System.out.println("Year: " + movie.getYearViaApi(moviesInfoJson));
            System.out.println("Released: " + movie.getReleaseViaApi(moviesInfoJson));
            System.out.println("Genre: " + movie.getGenreViaApi(moviesInfoJson));
            System.out.println("Director: " + movie.getDirectorViaApi(moviesInfoJson));
            System.out.println("Actors: " + movie.getActorListViaApi(moviesInfoJson));
            System.out.println("Imdb Votes: " + movie.getImdbVotesViaApi(moviesInfoJson));
            System.out.println("Rating -> Internet Movie Database : " + movie.getRatingViaApi(moviesInfoJson));

        }
        if (input == 2){
            System.out.println("Please enter the actor name that you want the information of:");
            Scanner ac = new Scanner(System.in);
            String actorName = ac.nextLine();

            Actors actor = new Actors(0,false);
            String actorsInfoJson = actor.getActorData(actorName);

            System.out.println("\nName: " + actorName);
            System.out.println("Gender: " + actor.getGenderViaAPi(actorsInfoJson));
            System.out.println("Nationality: " + actor.getNationalityViaApi(actorsInfoJson));
            System.out.println("Birthday: " + actor.getBirthdayViaApi(actorsInfoJson));
            System.out.println("Age: " + actor.getAgeViaAPi(actorsInfoJson));
            System.out.println("is Alive: " + actor.isAlive(actorsInfoJson));
            System.out.println("Date of death: " + actor.getDateOfDeathViaApi(actorsInfoJson));
            System.out.println("Height: " + actor.getHeightViaAPi(actorsInfoJson));
            System.out.println("Net worth: " + actor.getNetWorthViaApi(actorsInfoJson));

        }

    }
    public static void runMenu() {
        // TODO
        System.out.println("Hello Dear!What do you want information about?\n1.Movie or Series\n2.Actors");
    }
}