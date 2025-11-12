package cn.edu.bjut.librarymanagementsystem.service;

import cn.edu.bjut.librarymanagementsystem.dto.CommentRequest;
import cn.edu.bjut.librarymanagementsystem.dto.CommentResponse;
import cn.edu.bjut.librarymanagementsystem.entity.BookReview;
import cn.edu.bjut.librarymanagementsystem.repository.BookRepository;
import cn.edu.bjut.librarymanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.bjut.librarymanagementsystem.repository.BookReviewRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookReviewService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;

    private final BookReviewRepository bookReviewRepository;
    @Autowired
    public BookReviewService(BookReviewRepository bookReviewRepository) {
        this.bookReviewRepository = bookReviewRepository;
    }

    //添加书评
    public BookReview addBookReview(BookReview bookReview) {
        try{
            return bookReviewRepository.save(bookReview);
        }catch (Exception e){
            return null;
        }
    }

    public List<CommentResponse> getAllBookReviews() {
        //获取全部评价，并转换为CommentResponse返回
        List<BookReview> reviews = bookReviewRepository.findAll();
        return reviews.stream().map(review -> new CommentResponse(
                review.getReviewId(),
                review.getUserId(),
                review.getBookId(),
                review.getRating(),
                review.getReviewTitle(),
                review.getReviewContent(),
                review.getImageAttachments(),
                review.getStatus(),
                review.getCreatedAt(),
                review.getUpdatedAt(),
                bookRepository.findById(review.getBookId()).get().getIsbn(),
                userRepository.findByUserId(review.getUserId()).get().getLoginName()
        )).toList();
    }

    public boolean deleteBookReview(Long id) {
        if(bookReviewRepository.existsById(id)){
            bookReviewRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public boolean updateBookReview(Long id, CommentRequest req) {
        Optional<BookReview> existingReview = bookReviewRepository.findById(id);
        if(existingReview.isPresent()){
            BookReview reviewToUpdate = existingReview.get();
            reviewToUpdate.setBookId(req.bookId());
            reviewToUpdate.setUserId(req.userId());
            reviewToUpdate.setReviewTitle(req.title());
            reviewToUpdate.setRating(req.rating());
            reviewToUpdate.setReviewContent(req.comment());
            reviewToUpdate.setImageAttachments(existingReview.get().getImageAttachments());
            reviewToUpdate.setStatus(req.status());
            reviewToUpdate.setCreatedAt(existingReview.get().getCreatedAt());
            reviewToUpdate.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
            bookReviewRepository.save(reviewToUpdate);
            return true;
        }else{
            return false;
        }
    }
/*
    // 获取所有书评
    public List<BookReview> getAllBookReviews() {
        return bookReviewRepository.findAll();
    }

    // 根据ID查找书评
    public Optional<BookReview> getBookReviewById(Long id) {
        return bookReviewRepository.findById(id);
    }

    // 根据书籍ID查找书评
    public List<BookReview> getReviewsByBookId(Long bookId) {
        return bookReviewRepository.findByBookId(bookId);
    }

    // 根据用户ID查找书评
    public List<BookReview> getReviewsByUserId(Long userId) {
        return bookReviewRepository.findByUserId(userId);
    }

    // 根据评分查询书评（评分大于等于某值）
    public List<BookReview> getReviewsByRatingGreaterThanEqual(int rating) {
        return bookReviewRepository.findByRatingGreaterThanEqual(rating);
    }

    // 根据书籍ID和评分查询书评（评分大于等于某值）
    public List<BookReview> getReviewsByBookIdAndRatingGreaterThanEqual(Long bookId, int rating) {
        return bookReviewRepository.findByBookIdAndRatingGreaterThanEqual(bookId, rating);
    }

    // 根据书籍ID和评价内容查找书评
    public List<BookReview> getReviewsByBookIdAndContentContaining(Long bookId, String content) {
        return bookReviewRepository.findByBookIdAndContentContaining(bookId, content);
    }

    // 根据书籍ID和时间范围查找书评
    public List<BookReview> getReviewsByBookIdAndTimestampBetween(Long bookId, java.util.Date startDate, java.util.Date endDate) {
        return bookReviewRepository.findByBookIdAndTimestampBetween(bookId, startDate, endDate);
    }

    // 保存书评
    public BookReview saveBookReview(BookReview bookReview) {
        return bookReviewRepository.save(bookReview);
    }

    // 删除书评
    public void deleteBookReview(Long id) {
        bookReviewRepository.deleteById(id);
    }

     */
}
