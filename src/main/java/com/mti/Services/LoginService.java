package com.mti.Services;

import com.mti.Entities.User;
import com.mti.dao.LoginDao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++)
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            String hashedPassword = sb.toString();
            return(hashedPassword.equals(u.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
}
