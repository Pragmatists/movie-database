package tdd.database.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import tdd.database.config.ApplicationConfig;
import tdd.database.model.Movie;

public class MovieRepositoryTest extends H2Test {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void finds_persisted_movie() {
        Movie movie = persist(new Movie());

        Collection<Movie> movies = movieRepository.findAll();

        assertThat(movies).contains(movie);
    }

}
