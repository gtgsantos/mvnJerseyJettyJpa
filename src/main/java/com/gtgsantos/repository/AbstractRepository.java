package com.gtgsantos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.gtgsantos.repository.util.JpaUtil;

public abstract class AbstractRepository<T> {
    
    private EntityManager manager = JpaUtil.getEntityManager(); // in future versions, it will be injected  
    private Class<T> persistedClass;
    
    protected AbstractRepository(Class<T> persistedClass) {
        this.persistedClass = persistedClass;
    }

    public void save(T entity) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(entity);
        transaction.commit();
        //manager.close();
        //JpaUtil.close(); // review this
    }
    
    public T find(Long id) {
        //EntityTransaction transaction = manager.getTransaction();
        //transaction.begin();
        return (T) manager.find(persistedClass, id);
        
        //transaction.commit();
        //manager.close();
        //JpaUtil.close(); // review this
    }
    
    
    public List<T> list() {
        Query query = manager.createQuery("from " + persistedClass.getName());
        return (List<T>) query.getResultList();
    }
}
