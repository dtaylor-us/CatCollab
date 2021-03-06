package com.categories.collab.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryID")
    private Integer id;

    @Version
    private Integer version;

    @NotBlank(message = "title is required!")
    @Column(unique = true)
    private String title;

    @NotBlank(message = "description is required!")
    private String description;
    private String author;
    private String imageURL;
    private String imageURLFull;

    @Transient
    private String message;

    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public Category() {
    }

    public Category(String title) {
        this.title = title;
    }

    public Category(String title, String description, String author) {
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageURLFull() {
        return imageURLFull;
    }

    public void setImageURLFull(String imageURLFull) {
        this.imageURLFull = imageURLFull;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
