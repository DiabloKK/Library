package com.example.library.model.entity;

public class Book {

    private Integer id;
    private String name;
    private Integer amount;
    private String image;
    private String author;
    private Integer category_id;
    private String category_name;
    private Category category;

    public Book() {
    }

    public Book(Integer id, String name, Integer amount, String image, String author, Integer category_id) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.image = image;
        this.author = author;
        this.category_id = category_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", image='" + image + '\'' +
                ", author='" + author + '\'' +
                ", category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}

