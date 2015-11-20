package tdd.database.model;

public class MovieBuilder {
    private String name = "sth";

    private Integer year = 1994;

    private Studio studio;

    private MovieBuilder() {
    }

    public static MovieBuilder aMovie() {
        return new MovieBuilder();
    }

    public MovieBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MovieBuilder year(Integer year) {
        this.year = year;
        return this;
    }

    public MovieBuilder studio(Studio studio) {
        this.studio = studio;

        return this;
    }

    public Movie build() {
        return new Movie(name, year, studio);
    }
}
