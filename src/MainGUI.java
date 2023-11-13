
import bll.MovieService;
import dal.MovieFileAccess;

import java.util.Scanner;

public class MainGUI {

    public static void main(String[] args) {

        //MovieFileAccess.addToFile("Some line");
        //MovieFileAccess.addTextAtLine("Wierd new one", 2);
        MovieFileAccess.printFileContents();


        Scanner consoleScanner = new Scanner(System.in);
        //MovieService.insertNewMovie(consoleScanner);
        MovieService.findAndRepeatMovieTitleSearch(consoleScanner);
        consoleScanner.close();
    }
}
