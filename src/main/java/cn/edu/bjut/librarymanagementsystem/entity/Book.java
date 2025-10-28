package cn.edu.bjut.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;
import java.time.Year;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @Column(nullable = false)
    private String title;

    private String subtitle;

    @Column(nullable = false, unique = true)
    private String isbn;

    private String authors;

    private String publisher;

    @Column(name = "pub_year")
    private Year pubYear;

    private String language;

    private String keywords;

    @Lob
    private String summary;

    private Integer pages;

    private String edition;

    @Column(name = "total_copies", columnDefinition = "INT DEFAULT 0")
    private Integer totalCopies;

    @Column(name = "available_copies", columnDefinition = "INT DEFAULT 0")
    private Integer availableCopies;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('上架','下架') DEFAULT '上架'")
    private BookStatus status;

    @Column(name = "storage_time", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Timestamp storageTime;

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPubYear(Year pubYear) {
        this.pubYear = pubYear;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setTotalCopies(Integer totalCopies) {
        this.totalCopies = totalCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public void setStorageTime(Timestamp storageTime) {
        this.storageTime = storageTime;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    public Integer getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public Year getPubYear() {
        return pubYear;
    }

    public String getLanguage() {
        return language;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getSummary() {
        return summary;
    }

    public Integer getPages() {
        return pages;
    }

    public String getEdition() {
        return edition;
    }

    public Integer getTotalCopies() {
        return totalCopies;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public BookStatus getStatus() {
        return status;
    }

    public Timestamp getStorageTime() {
        return storageTime;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public enum BookStatus {
        上架, 下架
    }
}