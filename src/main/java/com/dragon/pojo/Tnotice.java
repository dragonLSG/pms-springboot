package com.dragon.pojo;

import java.util.Date;

public class Tnotice {
    private Integer noticid;

    private String title;

    private String content;

    private Date publishdate;

    private String publisher;

    public Integer getNoticid() {
        return noticid;
    }

    public void setNoticid(Integer noticid) {
        this.noticid = noticid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }
}