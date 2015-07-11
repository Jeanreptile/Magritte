package com.mti.Services;

import com.mti.Entities.User;
import com.mti.dao.LoginDao;

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
    private LoginDao ldao;

    public boolean validate(String email, String password) {
        User u = ldao.findByUser(email);
        if (u == null)
        {
            return false;
        }
        String hashedPassword = password;
        return(hashedPassword.equals(u.getPassword()));
    }
}
