package cn.edu.bjut.librarymanagementsystem.controller;

import cn.edu.bjut.librarymanagementsystem.entity.SeatReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cn.edu.bjut.librarymanagementsystem.service.SeatReservationService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seats/reservations")
public class SeatReservationController {
    /*
    private final SeatReservationService seatReservationService;

    @Autowired
    public SeatReservationController(SeatReservationService seatReservationService) {
        this.seatReservationService = seatReservationService;
    }

    // 获取所有座位预约记录
    @GetMapping
    public ResponseEntity<List<SeatReservation>> getAllSeatReservations() {
        List<SeatReservation> seatReservations = seatReservationService.getAllSeatReservations();
        return new ResponseEntity<>(seatReservations, HttpStatus.OK);
    }

    // 根据ID查找座位预约记录
    @GetMapping("/{id}")
    public ResponseEntity<SeatReservation> getSeatReservationById(@PathVariable Long id) {
        Optional<SeatReservation> seatReservation = seatReservationService.getSeatReservationById(id);
        return seatReservation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 根据用户ID获取座位预约记录
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SeatReservation>> getSeatReservationsByUserId(@PathVariable Long userId) {
        List<SeatReservation> seatReservations = seatReservationService.getSeatReservationsByUserId(userId);
        return new ResponseEntity<>(seatReservations, HttpStatus.OK);
    }

    // 根据座位ID获取座位预约记录
    @GetMapping("/seat/{seatId}")
    public ResponseEntity<List<SeatReservation>> getSeatReservationsBySeatId(@PathVariable Long seatId) {
        List<SeatReservation> seatReservations = seatReservationService.getSeatReservationsBySeatId(seatId);
        return new ResponseEntity<>(seatReservations, HttpStatus.OK);
    }

    // 根据预约状态获取座位预约记录
    @GetMapping("/status/{status}")
    public ResponseEntity<List<SeatReservation>> getSeatReservationsByStatus(@PathVariable String status) {
        try {
            List<SeatReservation> seatReservations = seatReservationService.getSeatReservationsByStatus(status);
            return new ResponseEntity<>(seatReservations, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // 根据用户ID和预约时间范围获取座位预约记录
    @GetMapping("/user/{userId}/reservation-date")
    public ResponseEntity<List<SeatReservation>> getSeatReservationsByUserIdAndReservationDate(
            @PathVariable Long userId,
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<SeatReservation> seatReservations = seatReservationService.getSeatReservationsByUserIdAndReservationDate(userId, startDate, endDate);
        return new ResponseEntity<>(seatReservations, HttpStatus.OK);
    }

    // 根据座位ID和预约时间范围获取座位预约记录
    @GetMapping("/seat/{seatId}/reservation-date")
    public ResponseEntity<List<SeatReservation>> getSeatReservationsBySeatIdAndReservationDate(
            @PathVariable Long seatId,
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<SeatReservation> seatReservations = seatReservationService.getSeatReservationsBySeatIdAndReservationDate(seatId, startDate, endDate);
        return new ResponseEntity<>(seatReservations, HttpStatus.OK);
    }

    // 保存座位预约记录
    @PostMapping
    public ResponseEntity<SeatReservation> saveSeatReservation(@RequestBody SeatReservation seatReservation) {
        SeatReservation savedSeatReservation = seatReservationService.saveSeatReservation(seatReservation);
        return new ResponseEntity<>(savedSeatReservation, HttpStatus.CREATED);
    }

    // 删除座位预约记录
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeatReservation(@PathVariable Long id) {
        seatReservationService.deleteSeatReservation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    */
}
