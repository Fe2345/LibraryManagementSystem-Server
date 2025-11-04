package cn.edu.bjut.librarymanagementsystem.controller;

import cn.edu.bjut.librarymanagementsystem.dto.ApiResponse;
import cn.edu.bjut.librarymanagementsystem.dto.RenewRequest;
import cn.edu.bjut.librarymanagementsystem.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cn.edu.bjut.librarymanagementsystem.service.BorrowService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {
    private final BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse> getBorrowsByUserId(@PathVariable Integer userId) {
        List<Borrow> borrows = borrowService.getBorrowById(userId);
        if (!borrows.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse(true, "FETCH_SUCCESS", borrows));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(false, "BORROW_NOT_FOUND", null));
        }
    }

    @PostMapping("/renew")
    public ResponseEntity<ApiResponse> renewBorrow(@RequestBody RenewRequest req) {
        System.out.println("Received renew request for borrowId: " + req.borrowId() + " for " + req.days() + " days");
        boolean renewed = borrowService.renewBorrow(req.borrowId(),req.days());
        if (renewed) {
            return ResponseEntity.ok(new ApiResponse(true, "RENEW_SUCCESS", null));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse(false, "RENEW_FAILED", null));
        }
    }
    /*
    // 获取所有借阅记录
    @GetMapping
    public ResponseEntity<List<Borrow>> getAllBorrows() {
        List<Borrow> borrows = borrowService.getAllBorrows();
        return new ResponseEntity<>(borrows, HttpStatus.OK);
    }

    // 根据ID获取借阅记录
    @GetMapping("/{id}")
    public ResponseEntity<Borrow> getBorrowById(@PathVariable Long id) {
        Optional<Borrow> borrow = borrowService.getBorrowById(id);
        return borrow.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 根据用户ID获取借阅记录

    // 根据书籍ID获取借阅记录
    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Borrow>> getBorrowsByBookId(@PathVariable Long bookId) {
        List<Borrow> borrows = borrowService.getBorrowsByBookId(bookId);
        return new ResponseEntity<>(borrows, HttpStatus.OK);
    }

    // 根据借阅状态获取借阅记录
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Borrow>> getBorrowsByStatus(@PathVariable String status) {
        List<Borrow> borrows = borrowService.getBorrowsByStatus(status);
        return new ResponseEntity<>(borrows, HttpStatus.OK);
    }

    // 根据借阅时间范围获取借阅记录
    @GetMapping("/borrow-date")
    public ResponseEntity<List<Borrow>> getBorrowsByBorrowDateBetween(@RequestParam Date startDate, @RequestParam Date endDate) {
        List<Borrow> borrows = borrowService.getBorrowsByBorrowDateBetween(startDate, endDate);
        return new ResponseEntity<>(borrows, HttpStatus.OK);
    }

    // 根据用户ID和借阅时间范围获取借阅记录
    @GetMapping("/user/{userId}/borrow-date")
    public ResponseEntity<List<Borrow>> getBorrowsByUserIdAndBorrowDateBetween(@PathVariable Long userId, @RequestParam Date startDate, @RequestParam Date endDate) {
        List<Borrow> borrows = borrowService.getBorrowsByUserIdAndBorrowDateBetween(userId, startDate, endDate);
        return new ResponseEntity<>(borrows, HttpStatus.OK);
    }

    // 根据书籍ID和借阅时间范围获取借阅记录
    @GetMapping("/book/{bookId}/borrow-date")
    public ResponseEntity<List<Borrow>> getBorrowsByBookIdAndBorrowDateBetween(@PathVariable Long bookId, @RequestParam Date startDate, @RequestParam Date endDate) {
        List<Borrow> borrows = borrowService.getBorrowsByBookIdAndBorrowDateBetween(bookId, startDate, endDate);
        return new ResponseEntity<>(borrows, HttpStatus.OK);
    }

    // 保存借阅记录
    @PostMapping
    public ResponseEntity<Borrow> saveBorrow(@RequestBody Borrow borrow) {
        Borrow savedBorrow = borrowService.saveBorrow(borrow);
        return new ResponseEntity<>(savedBorrow, HttpStatus.CREATED);
    }

    // 删除借阅记录
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrow(@PathVariable Long id) {
        borrowService.deleteBorrow(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
     */
}
