package tdd.database.repository;

import static org.assertj.core.api.Assertions.*;
import static tdd.database.model.MovieBuilder.*;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tdd.database.SearchCriteria;
import tdd.database.model.Movie;
import tdd.database.model.MovieBuilder;
import tdd.database.model.Studio;

public class MovieRepositoryTest extends H2Test {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void finds_by_exact_name() {
        Movie dieHard = persist(aMovie().name("Die Hard"));
        Movie darkNight = persist(aMovie().name("Dark Knight"));

        Collection<Movie> movies = movieRepository
            .find(new SearchCriteria().name("Dark Knight"));

        assertThat(movies)
            .containsOnly(darkNight);
    }

    @Test
    public void finds_by_part_of_the_name() {
        Movie dieHard = persist(aMovie().name("Die Hard"));
        Movie darkNight = persist(aMovie().name("Dark Knight"));

        Collection<Movie> movies = movieRepository
            .find(new SearchCriteria().name("night"));

        assertThat(movies)
            .containsOnly(darkNight);
    }

    @Test
    public void finds_by_name_ignoring_case() {
        Movie dieHard = persist(aMovie().name("Die Hard"));
        Movie darkNight = persist(aMovie().name("Dark Knight"));

        Collection<Movie> movies = movieRepository
            .find(new SearchCriteria().name("dark knight"));

        assertThat(movies)
            .containsOnly(darkNight);
    }

    @Test
    public void find_by_year_newer_than() {
        Movie older = persist(aMovie().year(2000));
        Movie newer = persist(aMovie().year(2001));

        Collection<Movie> movies = movieRepository
            .find(new SearchCriteria().yearFrom(2001));

        assertThat(movies)
            .containsOnly(newer);

    }

    @Test
    public void find_by_year_older_than() {
        Movie older = persist(aMovie().year(2000));
        Movie newer = persist(aMovie().year(2001));

        Collection<Movie> movies = movieRepository
            .find(new SearchCriteria().yearTo(2000));

        assertThat(movies)
            .containsOnly(older);

    }

    @Test
    public void find_by_year_range() {
        Movie older = persist(aMovie().year(2000));
        Movie matching = persist(aMovie().year(2003));
        Movie newer = persist(aMovie().year(2005));

        Collection<Movie> movies = movieRepository
            .find(new SearchCriteria()
                .yearFrom(2001)
                .yearTo(2004));

        assertThat(movies)
            .containsOnly(matching);
    }

    @Test
    public void find_by_studio() {
        Studio universal = persist(new Studio("Universal"));
        Studio paramount = persist(new Studio("Paramount"));
        Movie fromUniversal = persist(aMovie().studio(universal));
        Movie fromParamount = persist(aMovie().studio(paramount));

        Collection<Movie> movies = movieRepository
            .find(new SearchCriteria().studio("Universal"));

        assertThat(movies).containsOnly(fromUniversal);
    }

    private Movie persist(MovieBuilder builder) {
        return persist(builder.build());
    }

}
