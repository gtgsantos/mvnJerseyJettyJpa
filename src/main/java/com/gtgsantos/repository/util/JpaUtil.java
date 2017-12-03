package com.gtgsantos.repository.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gtgsantos.util.Constants;


public class JpaUtil {
    
    private static EntityManagerFactory factory;
   
    static {
        factory = Persistence.createEntityManagerFactory(Constants.EM_IDENTIFICATION);
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void close() {
        factory.close();
    }
}