package cn.edu.bjut.librarymanagementsystem.controller;

import cn.edu.bjut.librarymanagementsystem.dto.*;
import cn.edu.bjut.librarymanagementsystem.entity.*;
import cn.edu.bjut.librarymanagementsystem.repository.BookLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cn.edu.bjut.librarymanagementsystem.service.BookService;
import cn.edu.bjut.librarymanagementsystem.entity.Book.BookStatus;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(new ApiResponse(true, "GET_ALL_SUCCESS", books));
    }
    // 根据书名查找书籍
    @GetMapping("/searchTitle/{title}")
    public ResponseEntity<ApiResponse> searchBooksByTitle(@PathVariable String title) {
        List<Book> books = bookService.getBooksByTitle(title);
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

    @PostMapping("ComplexSearch")
    public ResponseEntity<ApiResponse> complexSearch(@RequestBody BookQueryRequest req)
    {
        List<Book> books = bookService.ComplexSearch(req);
        return ResponseEntity.ok(new ApiResponse(true, "COMPLEX_SEARCH_SUCCESS", books));
    }
    // 根据书籍 ID 查找书籍
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    // 添加新书籍
    @PostMapping("/addBook")
    public ResponseEntity<ApiResponse> addBook(@RequestBody BookRequest req) {
        Integer id = bookService.addBook(req);
        return id!=null ? ResponseEntity.ok(new ApiResponse(true, "ADD_BOOK_SUCCESS", id)) :
                ResponseEntity.ok(new ApiResponse(false, "ADD_BOOK_FAILED", id));
    }

    // 更新书籍信息
    @PostMapping("/updateBook/{id}")
    public ResponseEntity<ApiResponse> updateBook(@PathVariable Integer id,@RequestBody BookRequest req) {
        boolean created = bookService.updateBook(id,req);
        return created ? ResponseEntity.ok(new ApiResponse(true, "UPDATE_BOOK_SUCCESS", null)) :
                ResponseEntity.ok(new ApiResponse(false, "UPDATE_BOOK_FAILED", null));
    }

    // 删除书籍
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok(new ApiResponse(true, "DELETE_BOOK_SUCCESS", null));
    }

    @PostMapping("/updateStatus")
    public ResponseEntity<ApiResponse> updateBookStatus(@RequestBody BookStatusUpdateRequest req) {
        boolean updated = bookService.updateBookStatus(req.bookId(), BookStatus.valueOf(req.bookStatus()));
        return updated ? ResponseEntity.ok(new ApiResponse(true, "UPDATE_STATUS_SUCCESS", null)) :
                ResponseEntity.ok(new ApiResponse(false, "UPDATE_STATUS_FAILED", null));
    }
}
