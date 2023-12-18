package dev.axorean.entity;

import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@MappedEntity
public class LinkShorten {
    @Id
    @GeneratedValue
    private String idLink;

    @NotNull
    private String originalLink;

    @NotNull
    private String shortenedLink;

    @DateCreated
    private Date createdTime;

    public String getIdLink() {
        return idLink;
    }

    public void setIdLink(String idLink) {
        this.idLink = idLink;
    }

    public String getOriginalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    public String getShortenedLink() {
        return shortenedLink;
    }

    public void setShortenedLink(String shortenedLink) {
        this.shortenedLink = shortenedLink;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
