package com.miage.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miage.library.domain.enumeration.ReservationStatus;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.Instant;



/**
 * A BookReservation.
 */
@Entity
@Table(name = "book_reservation")
public class BookReservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_date")
    private Instant creationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ReservationStatus status;

    @Column(name = "book_item_barcode")
    private String bookItemBarcode;

    @ManyToOne
    @JsonIgnoreProperties("bookReservations")
    private BookItem bookItem;

    @ManyToOne
    @JsonIgnoreProperties("bookReservations")
    private Member member;

    @OneToOne(mappedBy = "bookReservation")
    @JsonIgnore
    private BookLending bookLending;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public BookReservation creationDate(Instant creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public BookReservation status(ReservationStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public String getBookItemBarcode() {
        return bookItemBarcode;
    }

    public BookReservation bookItemBarcode(String bookItemBarcode) {
        this.bookItemBarcode = bookItemBarcode;
        return this;
    }

    public void setBookItemBarcode(String bookItemBarcode) {
        this.bookItemBarcode = bookItemBarcode;
    }

    public BookItem getBookItem() {
        return bookItem;
    }

    public BookReservation bookItem(BookItem bookItem) {
        this.bookItem = bookItem;
        return this;
    }

    public void setBookItem(BookItem bookItem) {
        this.bookItem = bookItem;
    }

    public Member getMember() {
        return member;
    }

    public BookReservation member(Member member) {
        this.member = member;
        return this;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public BookLending getBookLending() {
        return bookLending;
    }

    public BookReservation bookLending(BookLending bookLending) {
        this.bookLending = bookLending;
        return this;
    }

    public void setBookLending(BookLending bookLending) {
        this.bookLending = bookLending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BookReservation)) {
            return false;
        }
        return id != null && id.equals(((BookReservation) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "BookReservation{" +
            "id=" + getId() +
            ", creationDate='" + getCreationDate() + "'" +
            ", status='" + getStatus() + "'" +
            ", bookItemBarcode='" + getBookItemBarcode() + "'" +
            "}";
    }
}
