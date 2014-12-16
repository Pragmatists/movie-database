package tdd.database.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MovieRepositoryImpl implements MovieRepositoryCustom {

    @PersistenceContext
    private EntityManager em;
}
