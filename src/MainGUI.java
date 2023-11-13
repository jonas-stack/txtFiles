
import bll.MovieService;
import dal.MovieFileAccess;

import java.util.Scanner;

public class MainGUI {

    public static void main(String[] args) {

       //txtFile lineje 7240 springer til 7242

      //MovieFileAccess.addToFile("Some line");
      //MovieFileAccess.addTextAtLine("", 7240);// method does not work currently
      MovieFileAccess.printFileContents();


      Scanner consoleScanner = new Scanner(System.in);
      MovieService.insertNewMovie(consoleScanner);
      MovieService.findAndRepeatMovieTitleSearch(consoleScanner);
      consoleScanner.close();
    }
}
