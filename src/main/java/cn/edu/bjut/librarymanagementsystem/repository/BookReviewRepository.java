package cn.edu.bjut.librarymanagementsystem.repository;

import cn.edu.bjut.librarymanagementsystem.entity.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookReviewRepository extends JpaRepository<BookReview, Long> {
    List<BookReview> findByUserId(Integer userId);

    /*
    // 根据书籍ID查找所有评价
    List<BookReview> findByBookId(Long bookId);

    // 根据用户ID查找该用户的所有书籍评价
    List<BookReview> findByUserId(Long userId);

    // 根据评分查找评价（例如：查询评分大于某个值的评价）
    List<BookReview> findByRatingGreaterThanEqual(int rating);

    // 根据书籍ID和评分查找评价
    List<BookReview> findByBookIdAndRatingGreaterThanEqual(Long bookId, int rating);

    // 根据书籍ID和评价内容查找
    List<BookReview> findByBookIdAndContentContaining(Long bookId, String content);

    // 根据用户ID和评分查找评价
    List<BookReview> findByUserIdAndRatingGreaterThanEqual(Long userId, int rating);

    // 根据书籍ID和时间范围查找评价
    List<BookReview> findByBookIdAndTimestampBetween(Long bookId, java.util.Date startDate, java.util.Date endDate);

    // 根据评分降序排列，查询前N条评价
    List<BookReview> findTopNByBookIdOrderByRatingDesc(Long bookId, int limit);
    */
}
