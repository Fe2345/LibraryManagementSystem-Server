package cn.edu.bjut.librarymanagementsystem.repository;

import cn.edu.bjut.librarymanagementsystem.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    Optional<Seat> findBySeatId(Integer seatId);
    /*
    // 根据座位状态查找座位
    List<Seat> findByStatus(String status);

    // 根据座位编号查找座位
    Seat findBySeatId(Long seatId);

    // 根据座位区域查找座位
    List<Seat> findByArea(String area);

    // 根据座位状态和区域查找座位
    List<Seat> findByStatusAndArea(String status, String area);

    // 根据座位状态和预约时间查找座位
    List<Seat> findByStatusAndReservationDateBetween(String status, Date startDate, Date endDate);

    // 查找某一日期和时间段内空闲座位
    List<Seat> findByStatusAndReservationDateBetweenAndTimeSlot(String status, Date startDate, Date endDate, String timeSlot);

    // 根据预约日期和座位区域查找座位
    List<Seat> findByReservationDateAndArea(Date reservationDate, String area);

     */
}
