package cn.edu.bjut.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "reading_duration")
public class ReadingDuration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "duration_id")
    private Integer durationId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "start_time", nullable = false)
    private Timestamp startTime;

    @Column(name = "end_time", nullable = false)
    private Timestamp endTime;

    @Column(name = "duration_hours", insertable = false, updatable = false)
    private Double durationHours;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    public void setDurationId(Integer durationId) {
        this.durationId = durationId;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public void setDurationHours(Double durationHours) {
        this.durationHours = durationHours;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getDurationId() {
        return durationId;
    }

    public Users getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public Double getDurationHours() {
        return durationHours;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}