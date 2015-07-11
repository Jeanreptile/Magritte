package com.mti.Entities;
import com.mti.Services.LoginService;

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

@Named("login")
@SessionScoped
public class Login implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    @Inject @Dependent
    private LoginService ls;

    private String password;
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //validate login
    public String validateUsernamePassword() {
        boolean valid = ls.validate(email, password);
        if (valid) {
            HttpSession session = SessionEntity.getSession();
            session.setAttribute("email", email);
            return "success";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    "myForm:password",
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Password",
                            ""));
            return "failure";
        }
    }
    //logout event, invalidate session
    public String logout() {
        System.out.println("LOOG OUTT");
        HttpSession session = SessionEntity.getSession();
        session.invalidate();
        System.out.println(session);
        return "logout";
    }
}
