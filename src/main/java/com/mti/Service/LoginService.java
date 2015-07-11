package com.mti.Service;

import com.mti.Entities.User;
import com.mti.dao.Dao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.Serializable;

/**
 * Created by Jean Royer on 7/11/15.
 */

@ApplicationScoped
public class LoginService implements Serializable{
    @Inject
    private Dao mydao;

    public boolean validate(String email, String password) {
            User u = mydao.findByString(User.class, email);
            if (u == null)
            {
                return false;
            }
            System.out.println("Yes, user is " + u.getEmail());
            return (email == u.getEmail());
    }
}
