package com.mti.ViewModel;

import com.mti.Entities.Image;
import com.mti.Services.ImageService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * Created by Francois on 11/07/15.
 */
@ManagedBean
public class IndexViewModel {
    @Inject
    ImageService service;

    private List<Image> images;

    @PostConstruct
    public void init() {
        images = service.GetImages();
    }

    public List<Image> getImages() {
        return images;
    }
}
