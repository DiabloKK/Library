package com.example.library.model.entity;

import java.sql.Date;

public class Borrower {

    private Integer id;
    private String name;
    private String mssv;
    private Integer book_id;
    private String book_name;
    private Date borrower_date;
    private Date deadline_date;
    private Date return_date;
    private boolean status;

    public Borrower() {
    }

    public Borrower(Integer id, String name, String mssv, Integer book_id, Date borrower_date, Date deadline_date, Date return_date, boolean status) {
        this.id = id;
        this.name = name;
        this.mssv = mssv;
        this.book_id = book_id;
        this.borrower_date = borrower_date;
        this.deadline_date = deadline_date;
        this.return_date = return_date;
        this.status = status;
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

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Date getBorrower_date() {
        return borrower_date;
    }

    public void setBorrower_date(Date borrower_date) {
        this.borrower_date = borrower_date;
    }

    public Date getDeadline_date() {
        return deadline_date;
    }

    public void setDeadline_date(Date deadline_date) {
        this.deadline_date = deadline_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mssv='" + mssv + '\'' +
                ", book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", borrower_date=" + borrower_date +
                ", deadline_date=" + deadline_date +
                ", return_date=" + return_date +
                ", status=" + status +
                '}';
    }
}
