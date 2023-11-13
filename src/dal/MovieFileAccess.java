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
        try(FileReader fr = new FileReader(filePath); // when filereader & bufferedreader are inside try() it means automatic close of both
            BufferedReader br = new BufferedReader(fr);) {
            String line;
            while ((line = br.readLine())!= null){
                System.out.println(line + System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();

        try(FileReader fr = new FileReader(filePath);) {
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }

    public static void addTextAtLine(String text, int lineNumber) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             FileWriter fw = new FileWriter(filePath, true)) {

            StringBuilder fileInput = new StringBuilder();
            int countLines = 0;

            while (br.ready()) {
                String line = br.readLine();
                fileInput.append(line).append("\r\n");
                if (countLines == lineNumber) {
                    fileInput.append(text).append("\r\n");
                }
                countLines++;
            }

            fw.write(fileInput.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void addToFile(String text) {
        try(FileWriter fw = new FileWriter(filePath, true);//needs to append or it will overwrite file each time
            BufferedWriter bw = new BufferedWriter(fw);) {

            bw.append(text).append("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

