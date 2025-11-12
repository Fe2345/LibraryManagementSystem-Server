package cn.edu.bjut.librarymanagementsystem.controller;

import cn.edu.bjut.librarymanagementsystem.dto.ApiResponse;
import cn.edu.bjut.librarymanagementsystem.dto.BookLocationRequest;
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

    // 根据条码获取图书位置
    @GetMapping("/{barcode}")
    public ResponseEntity<BookLocation> getBookLocationByBarcode(@PathVariable String barcode) {
        Optional<BookLocation> location = bookLocationService.getBookLocationByBarcode(barcode);
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

    // 新增图书位置（服务端自动生成createdAt/updatedAt）
    @PostMapping("/createBookLocation")
    public ResponseEntity<ApiResponse> createBookLocation(@RequestBody BookLocationRequest bookLocation) {
        BookLocation savedLocation = bookLocationService.createBookLocation(bookLocation);
        return ResponseEntity.ok(new ApiResponse(true, "BOOK_LOCATION_CREATED", savedLocation));
    }

    // 更新图书位置（不允许修改barcode，服务端自动更新updatedAt）
    @PutMapping("update/{barcode}")
    public ResponseEntity<ApiResponse> updateBookLocation(@PathVariable String barcode,
                                                           @RequestBody BookLocationRequest bookLocation) {
        Optional<BookLocation> updated = bookLocationService.updateBookLocation(barcode, bookLocation);
        return updated.map(location ->
                ResponseEntity.ok(new ApiResponse(true, "BOOK_LOCATION_UPDATED", location)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse(false, "BOOK_LOCATION_NOT_FOUND", null)));
    }

    // 删除图书位置（按条码）
    @DeleteMapping("delete/{barcode}")
    public ResponseEntity<ApiResponse> deleteBookLocation(@PathVariable String barcode) {
        bookLocationService.deleteBookLocation(barcode);
        return ResponseEntity.ok(new ApiResponse(true, "BOOK_LOCATION_DELETED", null));
    }
}
