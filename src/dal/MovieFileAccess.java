// MovieFileAccess.java
package dal;

import be.Movie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieFileAccess {

    private static String filePath = "C:\\Codeing\\Coding School\\txtFiles\\DATA\\txtFile.txt";

    public static void printFileContents() {
        System.out.println("----------");
        try {
            FileReader fr = new FileReader(filePath);
            Scanner scanner = new Scanner(fr);

            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();

        try {
            FileReader fr = new FileReader(filePath);
            Scanner scanner = new Scanner(fr);

            while (scanner.hasNext()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length >= 3) {  // Ensure there are enough parts to create a Movie
                    int position = Integer.parseInt(parts[0].trim());
                    int year = Integer.parseInt(parts[1].trim());
                    String title = parts[2].trim();

                    movies.add(new Movie(position, year, title));
                }
            }

            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }

    public static void addTextAtLine(String text, int lineNumber) {
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            StringBuilder fileInput = new StringBuilder();
            int countLines = 0;

            while (br.ready()) {
                fileInput.append(br.readLine()).append("\r\n");
                if (countLines == lineNumber) {
                    fileInput.append(text).append("\r\n");
                }
                countLines++;
            }

            br.close();

            FileWriter fw = new FileWriter(filePath);
            fw.write(fileInput.toString());
            fw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addToFile(String text) {
        try {
            FileWriter fw = new FileWriter(filePath, true);
            fw.append(text).append("\r\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

