package vn.vnpay.persistenjpa.config;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Slf4j
public class EntityManagerConfig {

    public static EntityManager getEntityManager() {
         try {
             EntityManagerFactory emf = Persistence.createEntityManagerFactory("films");
             EntityManager entityManager =  emf.createEntityManager();
             return entityManager;
         }catch (Exception ex){
             log.error("Exception: ", ex);
             return null;
         }
    }



}
