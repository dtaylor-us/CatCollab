package com.categories.collab.domain;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String title;
    private String description;
    private int likes;
    private String text;
    private String author;
    private String imageURL;
    private String imageURLFull;
    private String refURL;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public Item() {
    }

    public Item(String title) {
        this.title = title;
    }

    public Item(String title, Category category) {
        this.title = title;
        this.category = category;
    }

    public Item(String title, String description, String author, Category category) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.category = category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRefURL() {
        return refURL;
    }

    public void setRefURL(String refURL) {
        this.refURL = refURL;
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
}
