package tdd.database.repository;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tdd.database.SearchCriteria;
import tdd.database.model.Movie;

public class MovieRepositoryImpl implements MovieRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    public Collection<Movie> find(SearchCriteria criteria) {
        TypedQuery<Movie> query = em.createQuery(
            generateQuery(criteria),
            Movie.class);
        setParameters(criteria, query);
        return query.getResultList();
    }

    private void setParameters(SearchCriteria criteria, TypedQuery<Movie> query) {
        if (criteria.getName() != null) {
            query.setParameter("name", "%"+criteria.getName().toLowerCase()+"%");
        }
        if (criteria.getYearFrom() != null) {
            query.setParameter("yearFrom", criteria.getYearFrom());
        }
        if (criteria.getYearTo() != null) {
            query.setParameter("yearTo", criteria.getYearTo());
        }
        if (criteria.getStudio() != null) {
            query.setParameter("studio", criteria.getStudio());
        }
    }

    private String generateQuery(SearchCriteria criteria) {
        StringBuilder query = new StringBuilder("select movie " +
            "from Movie movie where 1=1");
        if (criteria.getName() != null) {
            query.append(" and lower(movie.name) like :name");
        }
        if (criteria.getYearFrom() != null) {
            query.append(" and movie.year>=:yearFrom");
        }
        if (criteria.getYearTo() != null) {
            query.append(" and movie.year<=:yearTo");
        }
        if (criteria.getStudio() != null) {
            query.append(" and movie.studio.name=:studio");
        }
        return query.toString();
    }
}
