package com.mti.Entities;
import com.mti.Services.LoginService;
import com.mti.dao.Dao;
import com.mti.dao.LoginDao;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;


/**
 * Created by Jean Royer on 7/11/15.
 */

@Named("signup")
@SessionScoped
public class Signup implements Serializable {
    @Inject
    private LoginDao loginDao;

    @Inject
    private Dao dao;

    private String email;
    private String username;
    private String password;
    private String password2;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    // signup method
    public String signUp() {
        if (loginDao.findByUser(email) == null && password.equals(password2))
        {
            User u = new User();
            u.setEmail(email);
            u.setPassword(password);
            u.setUsername(username);
            dao.create(u);
            return "success";
        }
        else if (!password.equals(password2)){
            FacesContext.getCurrentInstance().addMessage(
                    "signupform:password",
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "",
                            "Passwords do not match! Please enter the same password twice."));
            return "failure";
        }
        else {
            FacesContext.getCurrentInstance().addMessage(
                    "signupform:email",
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "",
                            "Email already exists! Please enter another email"));
            return "failure";
        }
    }
}
