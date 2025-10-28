package cn.edu.bjut.librarymanagementsystem.controller;

import cn.edu.bjut.librarymanagementsystem.entity.BorrowHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cn.edu.bjut.librarymanagementsystem.service.BorrowHistoryService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/borrow-histories")
public class BorrowHistoryController {
    /*
    private final BorrowHistoryService borrowHistoryService;

    @Autowired
    public BorrowHistoryController(BorrowHistoryService borrowHistoryService) {
        this.borrowHistoryService = borrowHistoryService;
    }

    // 获取所有借阅历史
    @GetMapping
    public ResponseEntity<List<BorrowHistory>> getAllBorrowHistories() {
        List<BorrowHistory> histories = borrowHistoryService.getAllBorrowHistories();
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }

    // 根据ID获取借阅历史
    @GetMapping("/{id}")
    public ResponseEntity<BorrowHistory> getBorrowHistoryById(@PathVariable Long id) {
        Optional<BorrowHistory> history = borrowHistoryService.getBorrowHistoryById(id);
        return history.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 根据用户ID获取借阅历史
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BorrowHistory>> getBorrowHistoriesByUserId(@PathVariable Long userId) {
        List<BorrowHistory> histories = borrowHistoryService.getBorrowHistoriesByUserId(userId);
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }

    // 根据书籍ID获取借阅历史
    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<BorrowHistory>> getBorrowHistoriesByBookId(@PathVariable Long bookId) {
        List<BorrowHistory> histories = borrowHistoryService.getBorrowHistoriesByBookId(bookId);
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }

    // 根据用户ID和借阅时间范围获取借阅历史
    @GetMapping("/user/{userId}/borrow-date")
    public ResponseEntity<List<BorrowHistory>> getBorrowHistoriesByUserIdAndBorrowDateBetween(
            @PathVariable Long userId,
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<BorrowHistory> histories = borrowHistoryService.getBorrowHistoriesByUserIdAndBorrowDateBetween(userId, startDate, endDate);
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }

    // 根据书籍ID和借阅时间范围获取借阅历史
    @GetMapping("/book/{bookId}/borrow-date")
    public ResponseEntity<List<BorrowHistory>> getBorrowHistoriesByBookIdAndBorrowDateBetween(
            @PathVariable Long bookId,
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<BorrowHistory> histories = borrowHistoryService.getBorrowHistoriesByBookIdAndBorrowDateBetween(bookId, startDate, endDate);
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }

    // 根据用户ID和归还时间范围获取借阅历史
    @GetMapping("/user/{userId}/return-date")
    public ResponseEntity<List<BorrowHistory>> getBorrowHistoriesByUserIdAndReturnDateBetween(
            @PathVariable Long userId,
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<BorrowHistory> histories = borrowHistoryService.getBorrowHistoriesByUserIdAndReturnDateBetween(userId, startDate, endDate);
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }

    // 根据书籍ID和归还时间范围获取借阅历史
    @GetMapping("/book/{bookId}/return-date")
    public ResponseEntity<List<BorrowHistory>> getBorrowHistoriesByBookIdAndReturnDateBetween(
            @PathVariable Long bookId,
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<BorrowHistory> histories = borrowHistoryService.getBorrowHistoriesByBookIdAndReturnDateBetween(bookId, startDate, endDate);
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }

    // 根据借阅状态获取借阅历史
    @GetMapping("/status/{status}")
    public ResponseEntity<List<BorrowHistory>> getBorrowHistoriesByStatus(@PathVariable String status) {
        List<BorrowHistory> histories = borrowHistoryService.getBorrowHistoriesByStatus(status);
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }

    // 保存借阅历史
    @PostMapping
    public ResponseEntity<BorrowHistory> saveBorrowHistory(@RequestBody BorrowHistory borrowHistory) {
        BorrowHistory savedHistory = borrowHistoryService.saveBorrowHistory(borrowHistory);
        return new ResponseEntity<>(savedHistory, HttpStatus.CREATED);
    }

    // 删除借阅历史
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowHistory(@PathVariable Long id) {
        borrowHistoryService.deleteBorrowHistory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

     */
}
