package cn.edu.bjut.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "book_review")
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @JoinColumn(name = "book_id", nullable = false)
    private Integer bookId;

    @Column(nullable = false)
    private Byte rating;

    @Column(name = "review_title", nullable = false, length = 100)
    private String reviewTitle;

    @Lob
    @Column(name = "review_content", nullable = false)
    private String reviewContent;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "image_attachments")
    private String imageAttachments;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('Public','Hidden','Blocked') DEFAULT 'Public'")
    private ReviewStatus status;

    @Column(name = "created_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public void setImageAttachments(String imageAttachments) {
        this.imageAttachments = imageAttachments;
    }

    public void setStatus(ReviewStatus status) {
        this.status = status;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public Byte getRating() {
        return rating;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public String getImageAttachments() {
        return imageAttachments;
    }

    public ReviewStatus getStatus() {
        return status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public enum ReviewStatus {
        Public, Hidden, Blocked
    }
}