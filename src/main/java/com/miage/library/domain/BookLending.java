package com.miage.library.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.Instant;

/**
 * A BookLending.
 */
@Entity
@Table(name = "book_lending")
public class BookLending implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_date")
    private Instant creationDate;

    @Column(name = "due_date")
    private Instant dueDate;

    @Column(name = "return_date")
    private Instant returnDate;

    @Column(name = "book_item_barcode")
    private String bookItemBarcode;

    @OneToOne
    @JoinColumn(unique = true)
    private BookReservation bookReservation;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public BookLending creationDate(Instant creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Instant getDueDate() {
        return dueDate;
    }

    public BookLending dueDate(Instant dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    public Instant getReturnDate() {
        return returnDate;
    }

    public BookLending returnDate(Instant returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public void setReturnDate(Instant returnDate) {
        this.returnDate = returnDate;
    }

    public String getBookItemBarcode() {
        return bookItemBarcode;
    }

    public BookLending bookItemBarcode(String bookItemBarcode) {
        this.bookItemBarcode = bookItemBarcode;
        return this;
    }

    public void setBookItemBarcode(String bookItemBarcode) {
        this.bookItemBarcode = bookItemBarcode;
    }

    public BookReservation getBookReservation() {
        return bookReservation;
    }

    public BookLending bookReservation(BookReservation bookReservation) {
        this.bookReservation = bookReservation;
        return this;
    }

    public void setBookReservation(BookReservation bookReservation) {
        this.bookReservation = bookReservation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BookLending)) {
            return false;
        }
        return id != null && id.equals(((BookLending) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "BookLending{" +
            "id=" + getId() +
            ", creationDate='" + getCreationDate() + "'" +
            ", dueDate='" + getDueDate() + "'" +
            ", returnDate='" + getReturnDate() + "'" +
            ", bookItemBarcode='" + getBookItemBarcode() + "'" +
            "}";
    }
}
