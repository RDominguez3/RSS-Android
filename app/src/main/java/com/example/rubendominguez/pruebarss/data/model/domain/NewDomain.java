package com.example.rubendominguez.pruebarss.data.model.domain;

import java.io.Serializable;

/**
 * Created by rubendominguez on 3/7/17.
 */

public class NewDomain implements Serializable {

    private String title;
    private String description;
    private String urlImage;
    private String author;
    private String date;
    private String urlNew;
    private String descriptionUnformatted;

    public NewDomain() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrlNew() {
        return urlNew;
    }

    public void setUrlNew(String urlNew) {
        this.urlNew = urlNew;
    }

    public String getDescriptionUnformatted() {
        return descriptionUnformatted;
    }

    public void setDescriptionUnformatted(String descriptionUnformatted) {
        this.descriptionUnformatted = descriptionUnformatted;
    }
}
