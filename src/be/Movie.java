// Movie.java
package be;

public class Movie {
    private String title;
    private int year;
    private int position;

    public Movie(int position, int year, String title) {
        this.position = position;
        this.year = year;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getPosition() {
        return position;
    }

    public int getYear() {
        return year;
    }
}

