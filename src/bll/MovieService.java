// MovieService.java
package bll;

import be.Movie;
import dal.MovieFileAccess;

import java.util.List;
import java.util.Scanner;

public class MovieService {

    public static void findAndRepeatMovieTitleSearch(Scanner consoleScanner) {
        while (true) {
            try {
                System.out.print("Enter the movie title to find, use uppercase in start (or type 'exit' to quit): ");
                String userInput = consoleScanner.nextLine();

                if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting the program. Goodbye!");
                    break;  // Exit the loop if the user types 'exit'
                }

                List<Movie> movies = MovieFileAccess.getAllMovies();
                boolean found = false;

                for (Movie movie : movies) {
                    // Check if the title contains the user input (case-insensitive)
                    if (movie.getTitle().toLowerCase().contains(userInput.toLowerCase())) {
                        // Print out position, year, and title
                        System.out.println("Movie found: " + movie.getPosition() + ", " +
                                movie.getYear() + ", " + movie.getTitle());
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Movie title not found.");
                }

                System.out.println();  // Add a line break between printouts

            } catch (Exception e) {
                System.out.println("An error occurred while finding the movie title.");
                e.printStackTrace();
            }
        }
    }

    public static void insertNewMovie(Scanner consoleScanner) {
        try {
            System.out.print("Enter the position of the new movie: ");
            int newPosition = Integer.parseInt(consoleScanner.nextLine());

            System.out.print("Enter the year of the new movie: ");
            int newMovieYear = Integer.parseInt(consoleScanner.nextLine());

            System.out.print("Enter the title of the new movie: ");
            String newMovieTitle = consoleScanner.nextLine();

            MovieFileAccess.addToFile(newPosition + "," + newMovieYear + "," + newMovieTitle);
            System.out.println("New movie added successfully!");

        } catch (Exception e) {
            System.out.println("An error occurred while inserting the new movie.");
            e.printStackTrace();
        }
    }
}


