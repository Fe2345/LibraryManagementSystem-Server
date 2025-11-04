package cn.edu.bjut.librarymanagementsystem.controller;

import cn.edu.bjut.librarymanagementsystem.dto.ApiResponse;
import cn.edu.bjut.librarymanagementsystem.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cn.edu.bjut.librarymanagementsystem.service.SeatService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    // 获取所有座位
    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse> getAllSeats() {
        List<Seat> seats = seatService.getAllSeats();
        return ResponseEntity.ok(new ApiResponse(true,"GET_ALL_SEATS_SUCCESS", seats));
    }

    @PutMapping("/updateStatus/{seatId}")
    public ResponseEntity<ApiResponse> updateStatus(@PathVariable Integer seatId) {
        boolean updated = seatService.updateSeatStatus(seatId);
        if (updated) {
            return ResponseEntity.ok(new ApiResponse(true, "SEAT_STATUS_UPDATED", null));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(false, "SEAT_NOT_FOUND", null));
        }
    }

    @PutMapping("/toggleMaintain/{seatId}")
    public ResponseEntity<ApiResponse> setSeatReserved(@PathVariable Integer seatId) {
        boolean updated = seatService.setSeatReserved(seatId);
        if (updated) {
            return ResponseEntity.ok(new ApiResponse(true, "SEAT_STATUS_UPDATED", null));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(false, "SEAT_NOT_FOUND", null));
        }
    }
    /*
    // 根据ID获取座位
    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long id) {
        Optional<Seat> seat = seatService.getSeatById(id);
        return seat.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 根据座位状态获取座位
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Seat>> getSeatsByStatus(@PathVariable String status) {
        List<Seat> seats = seatService.getSeatsByStatus(status);
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    // 根据座位编号查找座位
    @GetMapping("/seat-id/{seatId}")
    public ResponseEntity<Seat> getSeatBySeatId(@PathVariable Long seatId) {
        Seat seat = seatService.getSeatBySeatId(seatId);
        return seat != null ? new ResponseEntity<>(seat, HttpStatus.OK) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // 根据座位区域获取座位
    @GetMapping("/area/{area}")
    public ResponseEntity<List<Seat>> getSeatsByArea(@PathVariable String area) {
        List<Seat> seats = seatService.getSeatsByArea(area);
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    // 根据座位状态和区域获取座位
    @GetMapping("/status/{status}/area/{area}")
    public ResponseEntity<List<Seat>> getSeatsByStatusAndArea(
            @PathVariable String status,
            @PathVariable String area) {
        List<Seat> seats = seatService.getSeatsByStatusAndArea(status, area);
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    // 根据座位状态和预约时间查找座位
    @GetMapping("/status/{status}/reservation-date")
    public ResponseEntity<List<Seat>> getSeatsByStatusAndReservationDateBetween(
            @PathVariable String status,
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<Seat> seats = seatService.getSeatsByStatusAndReservationDateBetween(status, startDate, endDate);
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    // 查找某一日期和时间段内的空闲座位
    @GetMapping("/available")
    public ResponseEntity<List<Seat>> getAvailableSeatsByTimeSlot(
            @RequestParam Date startDate,
            @RequestParam Date endDate,
            @RequestParam String timeSlot) {
        List<Seat> seats = seatService.getAvailableSeatsByTimeSlot(startDate, endDate, timeSlot);
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    // 保存座位
    @PostMapping
    public ResponseEntity<Seat> saveSeat(@RequestBody Seat seat) {
        Seat savedSeat = seatService.saveSeat(seat);
        return new ResponseEntity<>(savedSeat, HttpStatus.CREATED);
    }

    // 删除座位
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Long id) {
        seatService.deleteSeat(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

     */
}
