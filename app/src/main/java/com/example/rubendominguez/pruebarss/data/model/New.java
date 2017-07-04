package com.example.rubendominguez.pruebarss.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.io.Serializable;

/**
 * Created by rubendominguez on 2/7/17.
 */
@Root(name = "item", strict = false)
public class New  implements Serializable{

    @Path("title")
    @Text(required=false)
    private String title;

    @Path("link")
    @Text(required=false)
    public String link;

    @Element(name = "pubDate", required = true)
    private String pubDate;

    @Element(name = "author", required = true)
    private String author;

    @Element(name = "description", required = true)
    private String description;

    @Element(name = "guid",required = true)
    private String guid;

    public New() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
