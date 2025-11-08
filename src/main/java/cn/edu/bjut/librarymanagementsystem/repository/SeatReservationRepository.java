package cn.edu.bjut.librarymanagementsystem.repository;

import cn.edu.bjut.librarymanagementsystem.entity.SeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Date;  // 添加此行以解决无法解析 'Date' 问题
import java.util.Optional;


@Repository
public interface SeatReservationRepository extends JpaRepository<SeatReservation, Long> {
    List<SeatReservation> findByUserId(Integer userId);

    Optional<SeatReservation> findByReservationId(Integer reservationId);
    /*
    // 根据用户ID查找座位预约记录
    List<SeatReservation> findByUserId(Long userId);

    // 根据座位ID查找座位预约记录
    List<SeatReservation> findBySeatId(Long seatId);

    // 根据预约状态查找座位预约记录
    List<SeatReservation> findByStatus(SeatReservation.ReservationStatus status);

    // 根据用户ID和预约时间范围查找座位预约记录
    List<SeatReservation> findByUserIdAndStartTimeBetween(Long userId, Date startDate, Date endDate);

    // 根据座位ID和预约时间范围查找座位预约记录
    List<SeatReservation> findBySeatIdAndStartTimeBetween(Long seatId, Date startDate, Date endDate);

     */
}
