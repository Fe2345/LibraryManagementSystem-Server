package cn.edu.bjut.librarymanagementsystem.controller;

import cn.edu.bjut.librarymanagementsystem.dto.ApiResponse;
import cn.edu.bjut.librarymanagementsystem.dto.BookQueryByIdRequest;
import cn.edu.bjut.librarymanagementsystem.dto.BookQueryByTitleRequest;
import cn.edu.bjut.librarymanagementsystem.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cn.edu.bjut.librarymanagementsystem.service.BookService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 根据书名查找书籍
    @PostMapping("/search")
    public ResponseEntity<ApiResponse> searchBooksByTitle(@RequestBody BookQueryByTitleRequest req) {
        List<Book> books = bookService.getBooksByTitle(req.title());
        return ResponseEntity.ok(new ApiResponse(true, "SEARCH_SUCCESS", books));
    }

    @PostMapping("/rangeSearch")
    public ResponseEntity<ApiResponse> getBooksByIdRange(@RequestBody BookQueryByIdRequest req) {
        // 用id获取书籍并组合成列表
        List<Book> books = new ArrayList<Book>();
        for (int id = req.startId(); id <= req.endId(); id++) {
            Book book = bookService.getBookById(id);
            if (book != null) {
                books.add(book);
            }
        }
        return ResponseEntity.ok(new ApiResponse(true, "RANGE_SEARCH_SUCCESS", books));
    }
    // 根据书籍 ID 查找书籍
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    // 添加新书籍
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    // 更新书籍
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    // 删除书籍
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }
}
