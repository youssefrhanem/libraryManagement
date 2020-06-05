package com.miage.library.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A Member.
 */
@Entity
@Table(name = "member")
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_of_membership")
    private Instant dateOfMembership;

    @Column(name = "total_books_checkedout")
    private Integer totalBooksCheckedout;

    @OneToOne
    @JoinColumn(unique = true)
    private User login;

    @OneToMany(mappedBy = "member")
    private Set<BookReservation> bookReservations = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDateOfMembership() {
        return dateOfMembership;
    }

    public Member dateOfMembership(Instant dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
        return this;
    }

    public void setDateOfMembership(Instant dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public Integer getTotalBooksCheckedout() {
        return totalBooksCheckedout;
    }

    public Member totalBooksCheckedout(Integer totalBooksCheckedout) {
        this.totalBooksCheckedout = totalBooksCheckedout;
        return this;
    }

    public void setTotalBooksCheckedout(Integer totalBooksCheckedout) {
        this.totalBooksCheckedout = totalBooksCheckedout;
    }

    public User getLogin() {
        return login;
    }

    public Member login(User user) {
        this.login = user;
        return this;
    }

    public void setLogin(User user) {
        this.login = user;
    }

    public Set<BookReservation> getBookReservations() {
        return bookReservations;
    }

    public Member bookReservations(Set<BookReservation> bookReservations) {
        this.bookReservations = bookReservations;
        return this;
    }

    public Member addBookReservation(BookReservation bookReservation) {
        this.bookReservations.add(bookReservation);
        bookReservation.setMember(this);
        return this;
    }

    public Member removeBookReservation(BookReservation bookReservation) {
        this.bookReservations.remove(bookReservation);
        bookReservation.setMember(null);
        return this;
    }

    public void setBookReservations(Set<BookReservation> bookReservations) {
        this.bookReservations = bookReservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Member)) {
            return false;
        }
        return id != null && id.equals(((Member) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Member{" +
            "id=" + getId() +
            ", dateOfMembership='" + getDateOfMembership() + "'" +
            ", totalBooksCheckedout=" + getTotalBooksCheckedout() +
            "}";
    }
}
