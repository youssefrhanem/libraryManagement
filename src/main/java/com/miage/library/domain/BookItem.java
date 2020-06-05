package com.miage.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



/**
 * A BookItem.
 */
@Entity
@Table(name = "book_item")
public class BookItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_reference_only")
    private Boolean isReferenceOnly;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "borrowed")
    private Date borrowed;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "due_date")
    private Date dueDate;


    @Column(name = "format")
    private String format;

    @Column(name = "status")
    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_purchase")
    private Date dateOfPurchase;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "publication_date")
    private Date publicationDate;

    @ManyToOne
    @JsonIgnoreProperties("bookItems")
    private Rack rack;

    @ManyToOne
    @JsonIgnoreProperties("bookItems")
    private Book book;

    @OneToMany(mappedBy = "bookItem")
    private Set<BookReservation> bookReservations = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }





    public Boolean isIsReferenceOnly() {
        return isReferenceOnly;
    }

    public BookItem isReferenceOnly(Boolean isReferenceOnly) {
        this.isReferenceOnly = isReferenceOnly;
        return this;
    }

    public void setIsReferenceOnly(Boolean isReferenceOnly) {
        this.isReferenceOnly = isReferenceOnly;
    }

    public Date getBorrowed() {
        return borrowed;
    }

    public BookItem borrowed(Date borrowed) {
        this.borrowed = borrowed;
        return this;
    }

    public void setBorrowed(Date borrowed) {
        this.borrowed = borrowed;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public BookItem dueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }


    public String getFormat() {
        return format;
    }

    public BookItem format(String format) {
        this.format = format;
        return this;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getStatus() {
        return status;
    }

    public BookItem status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public BookItem dateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
        return this;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public BookItem publicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Rack getRack() {
        return rack;
    }

    public BookItem rack(Rack rack) {
        this.rack = rack;
        return this;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public Book getBook() {
        return book;
    }

    public BookItem book(Book book) {
        this.book = book;
        return this;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Set<BookReservation> getBookReservations() {
        return bookReservations;
    }

    public BookItem bookReservations(Set<BookReservation> bookReservations) {
        this.bookReservations = bookReservations;
        return this;
    }

    public BookItem addBookReservation(BookReservation bookReservation) {
        this.bookReservations.add(bookReservation);
        bookReservation.setBookItem(this);
        return this;
    }

    public BookItem removeBookReservation(BookReservation bookReservation) {
        this.bookReservations.remove(bookReservation);
        bookReservation.setBookItem(null);
        return this;
    }

    public void setBookReservations(Set<BookReservation> bookReservations) {
        this.bookReservations = bookReservations;
    }

    public Date parseDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = format.parse(date);
        return d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BookItem)) {
            return false;
        }
        return id != null && id.equals(((BookItem) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public java.lang.String toString() {
        return "BookItem{" +
            "id=" + getId() +
            ", isReferenceOnly='" + isIsReferenceOnly() + "'" +
            ", borrowed='" + getBorrowed() + "'" +
            ", dueDate='" + getDueDate() + "'" +
            ", format='" + getFormat() + "'" +
            ", status='" + getStatus() + "'" +
            ", dateOfPurchase='" + getDateOfPurchase() + "'" +
            ", publicationDate='" + getPublicationDate() + "'" +
            "}";
    }
}
