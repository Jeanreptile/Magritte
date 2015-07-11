package com.mti.Services;

import com.mti.Entities.User;
import com.mti.dao.Dao;

import javax.inject.Inject;

/**
 * Created by Camille on 11/07/2015.
 */
public class UserService {
    @Inject
    Dao dao;

    public User getUserById(int id)
    {
        User user = dao.find(User.class, id);
        return user;
    }
}
