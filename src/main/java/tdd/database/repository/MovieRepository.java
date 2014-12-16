package tdd.database.repository;

import java.util.Collection;

import org.springframework.data.repository.Repository;

import tdd.database.model.Movie;

public interface MovieRepository extends Repository<Movie, Long>, MovieRepositoryCustom {
    Collection<Movie> findAll();
}
