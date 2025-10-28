package cn.edu.bjut.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private Integer borrowId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "barcode", nullable = false)
    private BookLocation bookLocation;

    @Column(name = "borrow_time", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Timestamp borrowTime;

    @Column(name = "due_time", nullable = false)
    private Timestamp dueTime;

    @Column(name = "return_time")
    private Timestamp returnTime;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('借出中','已归还','逾期中','挂失中','异常') DEFAULT '借出中'")
    private BorrowStatus status;

    @Column(name = "renew_count", columnDefinition = "INT DEFAULT 0")
    private Integer renewCount;

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setBookLocation(BookLocation bookLocation) {
        this.bookLocation = bookLocation;
    }

    public void setBorrowTime(Timestamp borrowTime) {
        this.borrowTime = borrowTime;
    }

    public void setDueTime(Timestamp dueTime) {
        this.dueTime = dueTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public void setStatus(BorrowStatus status) {
        this.status = status;
    }

    public void setRenewCount(Integer renewCount) {
        this.renewCount = renewCount;
    }

    public void setLastRenewTime(Timestamp lastRenewTime) {
        this.lastRenewTime = lastRenewTime;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public Users getUser() {
        return user;
    }

    public BookLocation getBookLocation() {
        return bookLocation;
    }

    public Timestamp getBorrowTime() {
        return borrowTime;
    }

    public Timestamp getDueTime() {
        return dueTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public BorrowStatus getStatus() {
        return status;
    }

    public Integer getRenewCount() {
        return renewCount;
    }

    public Timestamp getLastRenewTime() {
        return lastRenewTime;
    }

    @Column(name = "last_renew_time")
    private Timestamp lastRenewTime;

    public enum BorrowStatus {
        借出中, 已归还, 逾期中, 挂失中, 异常
    }
}