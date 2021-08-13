package dev.patika.hw01.core.helpers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {

    private final EntityManagerFactory entityManagerFactory;

    public EntityManagerHelper(String persistenceUnitName) {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void close(EntityManager entityManager) {
        entityManager.clear();
        entityManager.close();
        entityManagerFactory.close();
    }

}
