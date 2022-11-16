package com.redi.shortener.persistence;

import javax.persistence.*;

@Entity
@Table (name = "Url_Shortened")
public class URLShortened {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "URL")
    private String url;
    private String key;

    public URLShortened(){}

    public URLShortened(Long id, String url, String key) {
        this.id = id;
        this.url = url;
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getKey() {
        return key;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public void setKey(String key) {
        this.key = key;
    }
}