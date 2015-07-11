package com.mti.ViewModel;

import com.mti.Entities.Image;
import com.mti.Services.ImageService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * Created by Francois on 11/07/15.
 */
@ManagedBean
@ViewScoped
public class IndexViewModel {
    @Inject
    ImageService service;

    private List<Image> images;

    private Image selectedImage;

    @PostConstruct
    public void init() {
        images = service.GetImages();
    }

    public List<Image> getImages() {
        return images;
    }

    public Image getSelectedImage() {
            return selectedImage;
    }

    public void setSelectedImage(Image selectedImage) {
        this.selectedImage = selectedImage;
    }
}
