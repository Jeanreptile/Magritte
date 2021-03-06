package com.mti.ViewModel;

import com.mti.Entities.Image;
import com.mti.Services.ImageService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by Camille on 11/07/2015.
 */
@ManagedBean
public class UploadViewModel {

    @Inject
    ImageService imageService;

    private String imageLink;

    private String imageTitle;

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String upload() throws IOException {
        Image image = null;
        if ((image = imageService.saveImage(getImageLink(), getImageTitle())) != null) {
            FacesMessage message = new FacesMessage("Image successfully uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "success";
        }
        else
            return "failure";
    }
}
