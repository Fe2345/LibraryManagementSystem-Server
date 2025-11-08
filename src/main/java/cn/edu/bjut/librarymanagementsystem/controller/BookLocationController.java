package cn.edu.bjut.librarymanagementsystem.controller;

import cn.edu.bjut.librarymanagementsystem.dto.ApiResponse;
import cn.edu.bjut.librarymanagementsystem.entity.BookLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cn.edu.bjut.librarymanagementsystem.service.BookLocationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book-locations")
public class BookLocationController {

    private final BookLocationService bookLocationService;

    @Autowired
    public BookLocationController(BookLocationService bookLocationService) {
        this.bookLocationService = bookLocationService;
    }

    // 获取所有图书位置
    @GetMapping
    public ResponseEntity<List<BookLocation>> getAllBookLocations() {
        List<BookLocation> locations = bookLocationService.getAllBookLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    // 根据ID获取图书位置
    @GetMapping("/{id}")
    public ResponseEntity<BookLocation> getBookLocationById(@PathVariable Long id) {
        Optional<BookLocation> location = bookLocationService.getBookLocationById(id);
        return location.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 根据书籍ID获取所有位置
    @GetMapping("/book/{bookId}")
    public ResponseEntity<ApiResponse> getBookLocationsByBookId(@PathVariable int bookId) {
        List<BookLocation> locations = bookLocationService.getBookLocationsByBookId(bookId);
        return ResponseEntity.ok(new ApiResponse(true, "FETCH_SUCCESS", locations));
    }

    // 根据位置状态获取图书位置
    @GetMapping("/status/{status}")
    public ResponseEntity<List<BookLocation>> getBookLocationsByStatus(@PathVariable BookLocation.LocationStatus status) {
        List<BookLocation> locations = bookLocationService.getBookLocationsByStatus(status);
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    // 保存图书位置
    @PostMapping
    public ResponseEntity<BookLocation> saveBookLocation(@RequestBody BookLocation bookLocation) {
        BookLocation savedLocation = bookLocationService.saveBookLocation(bookLocation);
        return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
    }

    // 删除图书位置
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookLocation(@PathVariable Long id) {
        bookLocationService.deleteBookLocation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
