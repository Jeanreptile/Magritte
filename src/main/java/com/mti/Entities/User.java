package com.mti.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Jean Royer on 4/25/15.
 */
@Getter
@Setter
@Entity
@Table(name="user")
public class User implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid", nullable = false)
    private Integer id;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {this.id = id;}


    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;

}
