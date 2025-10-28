package cn.edu.bjut.librarymanagementsystem.repository;

import cn.edu.bjut.librarymanagementsystem.entity.BorrowHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BorrowHistoryRepository extends JpaRepository<BorrowHistory, Long> {
    /*
    // 根据用户ID查找借阅历史
    List<BorrowHistory> findByUserId(Long userId);

    // 根据书籍ID查找借阅历史
    List<BorrowHistory> findByBookId(Long bookId);

    // 根据用户ID和借阅时间范围查找借阅历史
    List<BorrowHistory> findByUserIdAndBorrowDateBetween(Long userId, Date startDate, Date endDate);

    // 根据书籍ID和借阅时间范围查找借阅历史
    List<BorrowHistory> findByBookIdAndBorrowDateBetween(Long bookId, Date startDate, Date endDate);

    // 根据用户ID和归还时间范围查找借阅历史
    List<BorrowHistory> findByUserIdAndReturnDateBetween(Long userId, Date startDate, Date endDate);

    // 根据书籍ID和归还时间范围查找借阅历史
    List<BorrowHistory> findByBookIdAndReturnDateBetween(Long bookId, Date startDate, Date endDate);

    // 根据借阅状态查找借阅历史
    List<BorrowHistory> findByStatus(String status);

    // 根据借阅状态和借阅时间范围查找借阅历史
    List<BorrowHistory> findByStatusAndBorrowDateBetween(String status, Date startDate, Date endDate);

    // 根据借阅状态和归还时间范围查找借阅历史
    List<BorrowHistory> findByStatusAndReturnDateBetween(String status, Date startDate, Date endDate);

    // 根据用户ID和借阅状态查找借阅历史
    List<BorrowHistory> findByUserIdAndStatus(Long userId, String status);

    // 根据书籍ID和借阅状态查找借阅历史
    List<BorrowHistory> findByBookIdAndStatus(Long bookId, String status);

    // 根据用户ID和借阅历史中的书籍列表查找
    List<BorrowHistory> findByUserIdAndBookIdIn(Long userId, List<Long> bookIds);

     */
}
