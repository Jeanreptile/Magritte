package com.mti.ViewModel;

import com.mti.Entities.Image;
import com.mti.Entities.SessionEntity;
import com.mti.Services.ImageService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

    private String search;

    @PostConstruct
    public void init() {

        images = service.GetImages();
        search = "";
    }

    public List<Image> getImages() {
        ArrayList<Image> filterImages = new ArrayList();
        if (!search.equals("")) {
            for (Image img : images)
                if (img.getName().toLowerCase().contains(search.toLowerCase()))
                    filterImages.add(img);
            return filterImages;
        }
        return images;
    }
    public Image getSelectedImage() {
        return selectedImage;
    }

    public void setSelectedImage(Image selectedImage) {
        this.selectedImage = selectedImage;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
