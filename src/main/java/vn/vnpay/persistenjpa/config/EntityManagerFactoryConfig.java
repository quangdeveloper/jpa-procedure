package vn.vnpay.persistenjpa.config;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Slf4j
public class EntityManagerFactoryConfig {

    private static final String PERSISTEN_NAME = "films";
    private static volatile EntityManagerFactory entityManagerFactory;

    private EntityManagerFactoryConfig() {
    }

    public static EntityManagerFactory getInstance() {
        if (entityManagerFactory == null) {
            synchronized (EntityManagerFactoryConfig.class) {
                entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTEN_NAME);
            }
        }
        return entityManagerFactory;
    }
}
