package com.mti.dao;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.mti.Entities.User;

@ApplicationScoped
public class LoginDao implements Serializable {

    @PersistenceContext(unitName = "magrittedbPu")
    protected EntityManager em;


    public User findByUser(String email) {
        List<Object> lo  = em.createQuery(String.format("from User u where u.email LIKE '%s'", email)).getResultList();
        if (lo.size() == 0)
        {
            return null;
        }
        else
        {
            Object o = lo.get(0);
            return (User) o;
        }
    }
}
