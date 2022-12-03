package com.example.library.model.entity;

import java.util.List;

public class TopBook {
    Book book;
    Integer times;

    public TopBook() {
    }

    public TopBook(Book book, Integer times) {
        this.book = book;
        this.times = times;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}
