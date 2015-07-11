package com.mti.Services;

import com.mti.Entities.Image;
import com.mti.Entities.User;
import com.mti.dao.Dao;

import java.util.Date;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Francois on 11/07/15.
 */
public class ImageService {

    @Inject
    Dao dao;

    public Image saveImage(String path, String imageTitle) {
        Image image = new Image();
        image.setPath(path);
        image.setCreatedate(new Date());
        image.setName(imageTitle);
        User user = dao.find(User.class, 1);
        image.setImageUser(user);
        image = dao.update(image);
        return image;
    }

    public ArrayList<Image> GetImages()
    {
        Collection<Image> images = dao.findAll(Image.class);
        return new ArrayList(images);
    }

    public ArrayList<Image> GetImagesByUserId(Integer userId)
    {
        Collection<Image> images = dao.findAllBydUserId(Image.class, userId);
        return new ArrayList(images);
    }
}
