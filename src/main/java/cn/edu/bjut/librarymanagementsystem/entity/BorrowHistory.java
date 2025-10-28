package cn.edu.bjut.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "borrow_history")
public class BorrowHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Integer historyId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "borrow_id", nullable = false)
    private Borrow borrow;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false)
    private EventType eventType;

    @Column(name = "borrow_time")
    private Timestamp borrowTime;

    @Column(name = "return_time")
    private Timestamp returnTime;

    @Column(name = "renew_count", columnDefinition = "INT DEFAULT 0")
    private Integer renewCount;

    @Column(name = "fine_amount", columnDefinition = "DECIMAL(10,2) DEFAULT 0")
    private BigDecimal fineAmount;

    @Column(name = "event_time", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Timestamp eventTime;

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public void setRenewCount(Integer renewCount) {
        this.renewCount = renewCount;
    }

    public void setEventTime(Timestamp eventTime) {
        this.eventTime = eventTime;
    }

    public void setFineAmount(BigDecimal fineAmount) {
        this.fineAmount = fineAmount;
    }

    public void setBorrowTime(Timestamp borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Integer getHistoryId() {
        return historyId;
    }

    public Users getUser() {
        return user;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Timestamp getBorrowTime() {
        return borrowTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public BigDecimal getFineAmount() {
        return fineAmount;
    }

    public Timestamp getEventTime() {
        return eventTime;
    }

    public Integer getRenewCount() {
        return renewCount;
    }

    public enum EventType {
        借出, 续借, 归还, 逾期, 异常, 挂失
    }
}