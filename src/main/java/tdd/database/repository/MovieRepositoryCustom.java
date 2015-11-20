package tdd.database.repository;

import java.util.Collection;

import tdd.database.SearchCriteria;
import tdd.database.model.Movie;

public interface MovieRepositoryCustom {
    Collection<Movie> find(SearchCriteria criteria);
}
