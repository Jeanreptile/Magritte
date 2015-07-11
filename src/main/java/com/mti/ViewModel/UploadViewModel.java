package com.mti.ViewModel;

import com.mti.Entities.Image;
import com.mti.Services.ImageService;
import org.apache.commons.io.FileUtils;
import org.primefaces.model.UploadedFile;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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

    public void upload() throws IOException {
        Image image = null;
        if ((image = imageService.saveImage(getImageLink(), getImageTitle())) != null) {
            FacesMessage message = new FacesMessage("Image successfully uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
