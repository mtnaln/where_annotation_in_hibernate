package com.metin.where.annotation.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * Created by Metin on 6.10.2019.
 */

@Entity
@Where(clause = "deleted = false")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String isbnNumber;
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name="writer_id")
    private Writer writer;

    public Book(){

    }

    public Book(String name, String isbnNumber, boolean deleted, Writer writer) {
        this.name = name;
        this.isbnNumber = isbnNumber;
        this.deleted = deleted;
        this.writer = writer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbnNumber='" + isbnNumber + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
