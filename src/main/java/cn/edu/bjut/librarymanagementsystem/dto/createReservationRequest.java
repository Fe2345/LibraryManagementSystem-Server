package cn.edu.bjut.librarymanagementsystem.dto;

import java.sql.Timestamp;

public record createReservationRequest(Integer userId, Integer seatId, Timestamp startTime, Timestamp endTime) {
}
