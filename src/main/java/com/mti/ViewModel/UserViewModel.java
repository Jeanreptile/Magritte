package com.mti.ViewModel;

import com.mti.Entities.Image;
import com.mti.Entities.User;
import com.mti.Services.ImageService;
import com.mti.Services.UserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Camille on 11/07/2015.
 */

@ManagedBean
@ViewScoped
public class UserViewModel {

    @Inject
    ImageService imageService;

    @Inject
    UserService userService;

    private List<Image> images;

    private Image selectedImage;

    private User user;

    private String search;

    @PostConstruct
    public void init() {
        search = "";
        HttpServletRequest hsr = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Integer userId = Integer.parseInt(hsr.getParameter("id"));
        images = imageService.GetImagesByUserId(userId);
        user = userService.getUserById(userId);
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
