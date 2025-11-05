package cn.edu.bjut.librarymanagementsystem.repository;

import cn.edu.bjut.librarymanagementsystem.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    List<Borrow> findByUserId(Integer userId);

    Optional<Borrow> findByBorrowId(Integer borrowId);
    /*
    // 根据书籍ID查找借阅记录
    List<Borrow> findByBookId(Long bookId);

    // 根据用户ID和借阅状态查找借阅记录
    List<Borrow> findByUserIdAndStatus(Long userId, String status);

    // 根据书籍ID和借阅状态查找借阅记录
    List<Borrow> findByBookIdAndStatus(Long bookId, String status);

    // 根据借阅时间范围查找借阅记录
    List<Borrow> findByBorrowDateBetween(Date startDate, Date endDate);

    // 根据用户ID和借阅时间范围查找借阅记录
    List<Borrow> findByUserIdAndBorrowDateBetween(Long userId, Date startDate, Date endDate);

    // 根据用户ID和归还时间范围查找借阅记录
    List<Borrow> findByUserIdAndReturnDateBetween(Long userId, Date startDate, Date endDate);

    // 根据书籍ID和借阅时间范围查找借阅记录
    List<Borrow> findByBookIdAndBorrowDateBetween(Long bookId, Date startDate, Date endDate);

    // 根据书籍ID和归还时间范围查找借阅记录
    List<Borrow> findByBookIdAndReturnDateBetween(Long bookId, Date startDate, Date endDate);

    // 根据借阅状态查找借阅记录（例如：借阅中、已归还、逾期等）
    List<Borrow> findByStatus(String status);

    // 根据借阅状态和借阅时间范围查找借阅记录
    List<Borrow> findByStatusAndBorrowDateBetween(String status, Date startDate, Date endDate);

     */
}
