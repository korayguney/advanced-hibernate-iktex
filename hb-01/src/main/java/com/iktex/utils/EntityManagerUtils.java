package com.iktex.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtils {

    static EntityManagerFactory emf = null;

    public static EntityManager getEntityManager(String persistenceUnitName){
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        }
        return emf.createEntityManager();
    }

    public static void closeEntityManager(EntityManager em){
        em.clear();
        em.close();
    }
}
