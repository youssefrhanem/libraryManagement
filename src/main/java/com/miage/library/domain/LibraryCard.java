package com.miage.library.domain;


import com.miage.library.domain.enumeration.CardStatus;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.Instant;


/**
 * A LibraryCard.
 */
@Entity
@Table(name = "library_card")
public class LibraryCard implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "issued_at")
    private Instant issuedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_status")
    private CardStatus cardStatus;

    @OneToOne
    @JoinColumn(unique = true)
    private User login;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LibraryCard cardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getBarcode() {
        return barcode;
    }

    public LibraryCard barcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Instant getIssuedAt() {
        return issuedAt;
    }

    public LibraryCard issuedAt(Instant issuedAt) {
        this.issuedAt = issuedAt;
        return this;
    }

    public void setIssuedAt(Instant issuedAt) {
        this.issuedAt = issuedAt;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public LibraryCard cardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
        return this;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public User getLogin() {
        return login;
    }

    public LibraryCard login(User user) {
        this.login = user;
        return this;
    }

    public void setLogin(User user) {
        this.login = user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LibraryCard)) {
            return false;
        }
        return id != null && id.equals(((LibraryCard) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LibraryCard{" +
            "id=" + getId() +
            ", cardNumber='" + getCardNumber() + "'" +
            ", barcode='" + getBarcode() + "'" +
            ", issuedAt='" + getIssuedAt() + "'" +
            ", cardStatus='" + getCardStatus() + "'" +
            "}";
    }
}
