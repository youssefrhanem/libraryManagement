package com.miage.library.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A Category.
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "category")
    private Set<Book> books = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public Category category(String category) {
        this.category = category;
        return this;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Category books(Set<Book> books) {
        this.books = books;
        return this;
    }

    public Category addBook(Book book) {
        this.books.add(book);
        book.setCategory(this);
        return this;
    }

    public Category removeBook(Book book) {
        this.books.remove(book);
        book.setCategory(null);
        return this;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Category)) {
            return false;
        }
        return id != null && id.equals(((Category) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Category{" +
            "id=" + getId() +
            ", category='" + getCategory() + "'" +
            "}";
    }
}
