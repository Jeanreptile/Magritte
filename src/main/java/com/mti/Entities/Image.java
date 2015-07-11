package com.mti.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Jean Royer on 7/11/15.
 */
@Getter
@Setter
@Entity
@Table(name="image")
public class Image implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="imageid", nullable = false)
    private Integer id;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {this.id = id;}


    @Column(name="name")
    private String name;

    @Column(name="path")
    private String path;
    @Column(name="createdate")
    private String createdate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userid", referencedColumnName = "userid")
    private User imageUser;

}
