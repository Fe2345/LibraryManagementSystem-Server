package cn.edu.bjut.librarymanagementsystem.service;

import cn.edu.bjut.librarymanagementsystem.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.bjut.librarymanagementsystem.repository.SeatRepository;
import cn.edu.bjut.librarymanagementsystem.entity.Seat.SeatStatus;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public boolean updateSeatStatus(Integer seatId) {
        Optional<Seat> seatOptional = seatRepository.findBySeatId(seatId);
        if (seatOptional.isPresent()) {
            Seat seat = seatOptional.get();
            // 切换座位状态
            if (SeatStatus.可用.equals(seat.getStatus())) {
                seat.setStatus(SeatStatus.被占用);
            } else {
                seat.setStatus(SeatStatus.可用);
            }
            seatRepository.save(seat);
            return true;
        } else {
            return false;
        }
    }

    public boolean setSeatReserved(Integer seatId) {
        Optional<Seat> seatOptional = seatRepository.findBySeatId(seatId);
        if (seatOptional.isPresent()) {
            Seat seat = seatOptional.get();
            // 设置座位状态为已预约
            if (seat.getStatus().equals(SeatStatus.可用)) seat.setStatus(SeatStatus.维护);
            if (seat.getStatus().equals(SeatStatus.维护)) seat.setStatus(SeatStatus.可用);
            seatRepository.save(seat);
            return true;
        } else {
            return false;
        }
    }
    /*

    // 根据ID查找座位
    public Optional<Seat> getSeatById(Long id) {
        return seatRepository.findById(id);
    }

    // 根据座位状态查找座位
    public List<Seat> getSeatsByStatus(String status) {
        return seatRepository.findByStatus(status);
    }

    // 根据座位编号查找座位
    public Seat getSeatBySeatId(Long seatId) {
        return seatRepository.findBySeatId(seatId);
    }

    // 根据座位区域查找座位
    public List<Seat> getSeatsByArea(String area) {
        return seatRepository.findByArea(area);
    }

    // 根据座位状态和区域查找座位
    public List<Seat> getSeatsByStatusAndArea(String status, String area) {
        return seatRepository.findByStatusAndArea(status, area);
    }

    // 根据座位状态和预约时间查找座位
    public List<Seat> getSeatsByStatusAndReservationDateBetween(String status, Date startDate, Date endDate) {
        return seatRepository.findByStatusAndReservationDateBetween(status, startDate, endDate);
    }

    // 查找某一日期和时间段内的空闲座位
    public List<Seat> getAvailableSeatsByTimeSlot(Date startDate, Date endDate, String timeSlot) {
        return seatRepository.findByStatusAndReservationDateBetweenAndTimeSlot("available", startDate, endDate, timeSlot);
    }

    // 保存座位
    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    // 删除座位
    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }

     */
}
