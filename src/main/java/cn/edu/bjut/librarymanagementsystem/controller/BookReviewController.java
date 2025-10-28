package cn.edu.bjut.librarymanagementsystem.controller;

import cn.edu.bjut.librarymanagementsystem.entity.BookReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cn.edu.bjut.librarymanagementsystem.service.BookReviewService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book-reviews")
public class BookReviewController {
/*
    private final BookReviewService bookReviewService;

    @Autowired
    public BookReviewController(BookReviewService bookReviewService) {
        this.bookReviewService = bookReviewService;
    }

    // 获取所有书评
    @GetMapping
    public ResponseEntity<List<BookReview>> getAllBookReviews() {
        List<BookReview> reviews = bookReviewService.getAllBookReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // 根据ID获取书评
    @GetMapping("/{id}")
    public ResponseEntity<BookReview> getBookReviewById(@PathVariable Long id) {
        Optional<BookReview> review = bookReviewService.getBookReviewById(id);
        return review.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 根据书籍ID获取书评
    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<BookReview>> getReviewsByBookId(@PathVariable Long bookId) {
        List<BookReview> reviews = bookReviewService.getReviewsByBookId(bookId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // 根据用户ID获取书评
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookReview>> getReviewsByUserId(@PathVariable Long userId) {
        List<BookReview> reviews = bookReviewService.getReviewsByUserId(userId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // 根据评分查询书评（评分大于等于某值）
    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<BookReview>> getReviewsByRatingGreaterThanEqual(@PathVariable int rating) {
        List<BookReview> reviews = bookReviewService.getReviewsByRatingGreaterThanEqual(rating);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // 根据书籍ID和评分查询书评
    @GetMapping("/book/{bookId}/rating/{rating}")
    public ResponseEntity<List<BookReview>> getReviewsByBookIdAndRatingGreaterThanEqual(@PathVariable Long bookId, @PathVariable int rating) {
        List<BookReview> reviews = bookReviewService.getReviewsByBookIdAndRatingGreaterThanEqual(bookId, rating);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // 根据书籍ID和评价内容查找书评
    @GetMapping("/book/{bookId}/content")
    public ResponseEntity<List<BookReview>> getReviewsByBookIdAndContent(@PathVariable Long bookId, @RequestParam String content) {
        List<BookReview> reviews = bookReviewService.getReviewsByBookIdAndContentContaining(bookId, content);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // 根据书籍ID和时间范围查找书评
    @GetMapping("/book/{bookId}/timestamp")
    public ResponseEntity<List<BookReview>> getReviewsByBookIdAndTimestamp(@PathVariable Long bookId, @RequestParam java.util.Date startDate, @RequestParam java.util.Date endDate) {
        List<BookReview> reviews = bookReviewService.getReviewsByBookIdAndTimestampBetween(bookId, startDate, endDate);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // 保存书评
    @PostMapping
    public ResponseEntity<BookReview> saveBookReview(@RequestBody BookReview bookReview) {
        BookReview savedReview = bookReviewService.saveBookReview(bookReview);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    // 删除书评
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookReview(@PathVariable Long id) {
        bookReviewService.deleteBookReview(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

     */
}
