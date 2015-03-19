package tdd.database.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import tdd.database.config.ApplicationConfig;

@ContextConfiguration(classes = ApplicationConfig.class)
@TransactionConfiguration
public abstract class H2Test extends AbstractTransactionalJUnit4SpringContextTests {

    @PersistenceContext
    private EntityManager em;

    protected <T> T persist(T entity) {
        em.persist(entity);
        return em.merge(entity);
    }
}
