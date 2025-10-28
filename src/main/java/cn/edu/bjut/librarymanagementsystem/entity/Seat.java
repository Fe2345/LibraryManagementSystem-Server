package cn.edu.bjut.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Integer seatId;

    @Column(name = "seat_no", nullable = false, unique = true)
    private String seatNo;

    private String floor;

    @Enumerated(EnumType.STRING)
    private SeatFunction func;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 1")
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('可用','维护','被占用') DEFAULT '可用'")
    private SeatStatus status;

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setFunc(SeatFunction func) {
        this.func = func;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public String getFloor() {
        return floor;
    }

    public SeatFunction getFunc() {
        return func;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public enum SeatFunction {
        自习区, 讨论区, 电源区
    }

    public enum SeatStatus {
        可用, 维护, 被占用
    }
}