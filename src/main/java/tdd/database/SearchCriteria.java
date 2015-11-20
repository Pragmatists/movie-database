package tdd.database;

import java.util.List;

public class SearchCriteria {

    private String name;

    private Integer yearFrom;

    private Integer yearTo;

    private String studio;

    private List<String> actors;

    private Boolean onlyWithOscars;

    private String genre;

    public String getName() {
        return name;
    }

    public SearchCriteria name(String name) {
        this.name = name;
        return this;
    }

    public SearchCriteria yearFrom(Integer yearFrom) {
        this.yearFrom = yearFrom;
        return this;
    }

    public Integer getYearFrom() {
        return yearFrom;
    }

    public SearchCriteria yearTo(Integer yearTo) {
        this.yearTo = yearTo;
        return this;
    }

    public Integer getYearTo() {
        return yearTo;
    }

    public SearchCriteria studio(String studio) {
        this.studio = studio;
        return this;
    }

    public String getStudio() {
        return studio;
    }
}
