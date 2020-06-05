package com.miage.library.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A Rack.
 */
@Entity
@Table(name = "rack")
public class Rack implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rack_number")
    private Integer rackNumber;

    @Column(name = "location_identifier")
    private String locationIdentifier;

    @OneToMany(mappedBy = "rack")
    private Set<BookItem> bookItems = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRackNumber() {
        return rackNumber;
    }

    public Rack rackNumber(Integer rackNumber) {
        this.rackNumber = rackNumber;
        return this;
    }

    public void setRackNumber(Integer rackNumber) {
        this.rackNumber = rackNumber;
    }

    public String getLocationIdentifier() {
        return locationIdentifier;
    }

    public Rack locationIdentifier(String locationIdentifier) {
        this.locationIdentifier = locationIdentifier;
        return this;
    }

    public void setLocationIdentifier(String locationIdentifier) {
        this.locationIdentifier = locationIdentifier;
    }

    public Set<BookItem> getBookItems() {
        return bookItems;
    }

    public Rack bookItems(Set<BookItem> bookItems) {
        this.bookItems = bookItems;
        return this;
    }

    public Rack addBookItem(BookItem bookItem) {
        this.bookItems.add(bookItem);
        bookItem.setRack(this);
        return this;
    }

    public Rack removeBookItem(BookItem bookItem) {
        this.bookItems.remove(bookItem);
        bookItem.setRack(null);
        return this;
    }

    public void setBookItems(Set<BookItem> bookItems) {
        this.bookItems = bookItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rack)) {
            return false;
        }
        return id != null && id.equals(((Rack) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Rack{" +
            "id=" + getId() +
            ", rackNumber=" + getRackNumber() +
            ", locationIdentifier='" + getLocationIdentifier() + "'" +
            "}";
    }
}
