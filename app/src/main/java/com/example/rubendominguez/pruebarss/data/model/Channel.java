package com.example.rubendominguez.pruebarss.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rubendominguez on 2/7/17.
 */
@Root(name = "channel",strict = false)
public class Channel implements Serializable {

    @Element(name = "title",required = false)
    private String title;

    @Path("link")
    @Text(required=false)
    public String link;
    @Element(name = "description",required = false)
    private String description;
    @Element(name = "pubDate",required = false)
    private String pubDate;
    @Element(name = "generator",required = false)
    private String generator;

    @ElementList(entry = "item", inline = true)
    private List<New> items;

    public Channel() {
    }

    public List<New> getItems() {
        return items;
    }

    public void setItems(List<New> items) {
        this.items = items;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }
}
