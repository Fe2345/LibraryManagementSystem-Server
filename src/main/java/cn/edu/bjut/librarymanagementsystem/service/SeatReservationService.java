package cn.edu.bjut.librarymanagementsystem.service;

import cn.edu.bjut.librarymanagementsystem.entity.SeatReservation;
import cn.edu.bjut.librarymanagementsystem.entity.SeatReservation.ReservationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.bjut.librarymanagementsystem.repository.SeatReservationRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SeatReservationService {

    private final SeatReservationRepository seatReservationRepository;

    @Autowired
    public SeatReservationService(SeatReservationRepository seatReservationRepository) {
        this.seatReservationRepository = seatReservationRepository;
    }

    // 根据ID查找座位预约记录
    public Optional<SeatReservation> getSeatReservationById(Long id) {
        return seatReservationRepository.findById(id);
    }

    public List<SeatReservation> getAllSeatReservations() {
        return seatReservationRepository.findAll();
    }

    public List<SeatReservation> getSeatReservationsByUserId(Integer userId) {
        return seatReservationRepository.findByUserId(userId);
    }

    public boolean toggleSeatReservationStatus(Integer reservationId,String status) {
        Optional<SeatReservation> optionalReservation = seatReservationRepository.findByReservationId(reservationId);
        if (optionalReservation.isPresent()) {
            SeatReservation reservation = optionalReservation.get();
            // 切换状态
            reservation.setStatus(ReservationStatus.valueOf(status));
            seatReservationRepository.save(reservation);
            return true;
        } else {
            return false;
        }
    }
    /*
    // 获取所有座位预约记录
    public List<SeatReservation> getAllSeatReservations() {
        return seatReservationRepository.findAll();
    }



    // 根据用户ID获取座位预约记录
    public List<SeatReservation> getSeatReservationsByUserId(Long userId) {
        return seatReservationRepository.findByUserId(userId);
    }

    // 根据座位ID获取座位预约记录
    public List<SeatReservation> getSeatReservationsBySeatId(Long seatId) {
        return seatReservationRepository.findBySeatId(seatId);
    }

    // 根据预约状态获取座位预约记录
    public List<SeatReservation> getSeatReservationsByStatus(String status) {
        try {
            // 将字符串转换为枚举类型
            ReservationStatus reservationStatus = ReservationStatus.valueOf(status);
            return seatReservationRepository.findByStatus(reservationStatus);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status value: " + status);
        }
    }

    // 根据用户ID和预约时间范围获取座位预约记录
    public List<SeatReservation> getSeatReservationsByUserIdAndReservationDate(Long userId, Date startDate, Date endDate) {
        return seatReservationRepository.findByUserIdAndStartTimeBetween(userId, startDate, endDate);
    }

    // 根据座位ID和预约时间范围获取座位预约记录
    public List<SeatReservation> getSeatReservationsBySeatIdAndReservationDate(Long seatId, Date startDate, Date endDate) {
        return seatReservationRepository.findBySeatIdAndStartTimeBetween(seatId, startDate, endDate);
    }

    // 保存座位预约记录
    public SeatReservation saveSeatReservation(SeatReservation seatReservation) {
        return seatReservationRepository.save(seatReservation);
    }

    // 删除座位预约记录
    public void deleteSeatReservation(Long id) {
        seatReservationRepository.deleteById(id);
    }

     */
}
