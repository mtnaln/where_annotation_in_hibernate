package com.metin.where.annotation.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Metin on 6.10.2019.
 */

@Entity
@Where(clause = "deleted = false")
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private boolean deleted;

    @OneToMany(mappedBy = "writer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public Writer() {
    }

    public Writer(String name, String surname, boolean deleted) {
        this.name = name;
        this.surname = surname;
        this.deleted = deleted;
        this.books = books;
    }

    public Writer(String name, String surname, boolean deleted, List<Book> books) {
        this.name = name;
        this.surname = surname;
        this.deleted = deleted;
        this.books = books;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", deleted=" + deleted +
                ", books=" + books +
                '}';
    }
}