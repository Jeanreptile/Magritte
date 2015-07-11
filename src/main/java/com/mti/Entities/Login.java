package com.mti.Entities;
import com.mti.Entities.SessionEntity;
import com.mti.Service.LoginService;

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


    @Inject @Dependent
    private LoginService ls;

    private String pwd;
    private String msg;
    private String user;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        System.out.println("YES ! " + user);
        this.user = user;
    }

    //validate login
    public String validateUsernamePassword() {
        boolean valid = ls.validate(user, pwd);
        if (valid) {
            HttpSession session = SessionEntity.getSession();
            session.setAttribute("username", user);
            System.out.println("OK OK");
            return "admin";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }
    }

    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionEntity.getSession();
        session.invalidate();
        return "login";
    }
}