package com.mti.Services;

import com.mti.Entities.Image;
import com.mti.Entities.User;
import com.mti.dao.Dao;

import javax.inject.Inject;
import java.nio.file.Path;
import java.util.Date;

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
}
