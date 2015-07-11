package com.mti.dao;

import com.mti.Entities.Model;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Collection;

@ApplicationScoped
public class Dao implements Serializable {

    @PersistenceContext(unitName = "magrittedbPu")
    protected EntityManager em;


    public <BEAN extends Model> BEAN find(final Class<BEAN> clazz, final Integer id) {
        return em.find(clazz, id);
    }

    public <BEAN extends Model> Collection<BEAN> findAll(final Class<BEAN> clazz) {
        return em.createQuery(String.format("from %s",
                clazz.getName())).getResultList();
    }

    @Transactional
    public <BEAN extends Model> BEAN update(final BEAN bean) {
        em.merge(bean);
        return bean;
    }

    @Transactional
    public <BEAN extends Model> BEAN create(final BEAN bean) {
        em.persist(bean);
        return bean;
    }

    @Transactional
    public <BEAN extends Model> void delete(final Class<BEAN> clazz, final Integer id) {
        em.remove(find(clazz, id));
    }
}
