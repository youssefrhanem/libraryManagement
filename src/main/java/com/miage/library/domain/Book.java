package com.miage.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miage.library.domain.enumeration.Language;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



/**
 * A Book.
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "i_sbn")
    private String iSBN;

    @Column(name = "title")
    private String title;

    @Column(name = "subject")
    private String subject;

    @Column(name = "publisher")
    private String publisher;


    @Column(name = "language")
    private String language;

    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    @Lob
    @Column(name = "cover")
    private byte[] cover;
    private String fileName;
    private String fileType;

    @Column(name = "cover_content_type")
    private String coverContentType;

    @ManyToOne
    @JsonIgnoreProperties("books")
    private Author author;

    @ManyToOne
    @JsonIgnoreProperties("books")
    private Category category;

    @OneToMany(mappedBy = "book")
    private Set<BookItem> bookItems = new HashSet<>();

    public Book(){}

    public Book(Long id, String iSBN, String title, String subject, String publisher, String language, Integer numberOfPages, byte[] cover, String coverContentType, Author author, Category category, Set<BookItem> bookItems) {
        this.id = id;
        this.iSBN = iSBN;
        this.title = title;
        this.subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.numberOfPages = numberOfPages;
        this.cover = cover;
        this.coverContentType = coverContentType;
        this.author = author;
        this.category = category;
        this.bookItems = bookItems;
    }

    public Book(String iSBN, String title, String subject, String publisher, String language, Integer numberOfPages, byte[] cover,String fileName, String fileType, Author author, Category category) {
        this.iSBN = iSBN;
        this.title = title;
        this.subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.numberOfPages = numberOfPages;
        this.fileName = fileName;
        this.fileType = fileType;
        this.cover = cover;
        this.author = author;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getiSBN() {
        return iSBN;
    }

    public Book iSBN(String iSBN) {
        this.iSBN = iSBN;
        return this;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }

    public String getTitle() {
        return title;
    }

    public Book title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public Book subject(String subject) {
        this.subject = subject;
        return this;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPublisher() {
        return publisher;
    }

    public Book publisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public Book language(String language) {
        this.language = language;
        return this;
    }

    public void setLanguage(Language String) {
        this.language = language;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public Book numberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
        return this;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public byte[] getCover() {
        return cover;
    }

    public Book cover(byte[] cover) {
        this.cover = cover;
        return this;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public String getCoverContentType() {
        return coverContentType;
    }

    public Book coverContentType(String coverContentType) {
        this.coverContentType = coverContentType;
        return this;
    }

    public void setCoverContentType(String coverContentType) {
        this.coverContentType = coverContentType;
    }

    public Author getAuthor() {
        return author;
    }

    public Book author(Author author) {
        this.author = author;
        return this;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public Book category(Category category) {
        this.category = category;
        return this;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<BookItem> getBookItems() {
        return bookItems;
    }

    public Book bookItems(Set<BookItem> bookItems) {
        this.bookItems = bookItems;
        return this;
    }

    public Book addBookItem(BookItem bookItem) {
        this.bookItems.add(bookItem);
        bookItem.setBook(this);
        return this;
    }

    public Book removeBookItem(BookItem bookItem) {
        this.bookItems.remove(bookItem);
        bookItem.setBook(null);
        return this;
    }

    public void setBookItems(Set<BookItem> bookItems) {
        this.bookItems = bookItems;
    }

    public String generateBase64Image()
    {
        return Base64.encodeBase64String(this.getCover());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        return id != null && id.equals(((Book) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Book{" +
            "id=" + getId() +
            ", iSBN='" + getiSBN() + "'" +
            ", title='" + getTitle() + "'" +
            ", subject='" + getSubject() + "'" +
            ", publisher='" + getPublisher() + "'" +
            ", language='" + getLanguage() + "'" +
            ", numberOfPages=" + getNumberOfPages() +
            ", cover='" + getCover() + "'" +
            ", coverContentType='" + getCoverContentType() + "'" +
            "}";
    }
}
