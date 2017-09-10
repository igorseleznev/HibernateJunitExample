package ru.seleznev;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * I used windows 10 and postgresql 9.6.5 when I checked this test.
 * I created database with name "test"
 */
public class JunitTest {
    private EntityManagerFactory emf;
    private EntityManager em;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("example-persistence-unit");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        emf.close();
    }

    @Test
    public void createTestEntity() {
        TestEntity entityForCreatedInDb = new TestEntity("Zorro");
        em.getTransaction().begin();
        em.persist(entityForCreatedInDb);
        em.getTransaction().commit();

        TestEntity entityForCheckedExistingInDb =
                em.find(TestEntity.class, entityForCreatedInDb.getId());
        assertNotNull(entityForCheckedExistingInDb);
        assertEquals("Zorro", entityForCheckedExistingInDb.getName());
    }
}
