package cn.edu.bjut.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.net.Inet4Address;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "seat_reservations")
public class SeatReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Integer reservationId;

    @JoinColumn(name = "user_id", nullable = false)
    private Integer userId;

    @JoinColumn(name = "seat_id", nullable = false)
    private Integer seatId;

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public void setCheckinTime(Timestamp checkinTime) {
        this.checkinTime = checkinTime;
    }

    public void setCheckoutTime(Timestamp checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public Timestamp getCheckinTime() {
        return checkinTime;
    }

    public Timestamp getCheckoutTime() {
        return checkoutTime;
    }

    @Column(name = "start_time", nullable = false)
    private Timestamp startTime;

    @Column(name = "end_time", nullable = false)
    private Timestamp endTime;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('待签到','已签到','已取消','已完成','爽约') DEFAULT '待签到'")
    private ReservationStatus status;

    @Column(name = "checkin_time")
    private Timestamp checkinTime;

    @Column(name = "checkout_time")
    private Timestamp checkoutTime;

    public enum ReservationStatus {
        待签到, 已签到, 已取消, 已完成, 爽约
    }
}