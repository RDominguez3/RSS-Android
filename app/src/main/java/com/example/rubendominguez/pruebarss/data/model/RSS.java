package com.example.rubendominguez.pruebarss.data.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by rubendominguez on 2/7/17.
 */
@Root(name = "rss",strict = false)
public class RSS implements Serializable {

    @Attribute(name = "version")
    private String version;

    @Element(name = "channel")
    private Channel channel;


    public RSS() {
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
