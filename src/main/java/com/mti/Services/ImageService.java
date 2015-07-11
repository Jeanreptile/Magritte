package com.mti.Services;

import com.mti.Entities.Image;
import com.mti.dao.Dao;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Francois on 11/07/15.
 */
public class ImageService {
    @Inject
    Dao dao;

    public ImageService()
    {
    }

    public ArrayList<Image> GetImages()
    {
        Collection<Image> images = dao.findAll(Image.class);
        return new ArrayList(images);
    }
}
