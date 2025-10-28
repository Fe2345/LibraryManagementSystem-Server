package cn.edu.bjut.librarymanagementsystem.repository;

import cn.edu.bjut.librarymanagementsystem.entity.ReadingDuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReadingDurationRepository extends JpaRepository<ReadingDuration, Long> {
    /*
    // 根据用户ID查找阅读时长记录
    List<ReadingDuration> findByUserId(Long userId);

    // 根据用户ID和日期范围查找阅读时长记录
    List<ReadingDuration> findByUserIdAndDateBetween(Long userId, Date startDate, Date endDate);

    // 根据日期范围查找所有用户的阅读时长记录
    List<ReadingDuration> findByDateBetween(Date startDate, Date endDate);

    // 根据用户ID和特定的书籍ID查找该书籍的阅读时长记录
    List<ReadingDuration> findByUserIdAndBookId(Long userId, Long bookId);

    // 获取某个用户在某一日期的总阅读时长
    ReadingDuration findTopByUserIdAndDateOrderByReadingTimeDesc(Long userId, Date date);

    // 获取某个用户在特定日期范围内的累计阅读时长
    Long sumReadingTimeByUserIdAndDateBetween(Long userId, Date startDate, Date endDate);

    // 根据阅读时长查找记录（例如：查找超过一定时长的记录）
    List<ReadingDuration> findByReadingTimeGreaterThanEqual(Long readingTime);

     */
}
