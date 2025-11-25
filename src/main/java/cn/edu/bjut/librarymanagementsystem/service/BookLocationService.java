package cn.edu.bjut.librarymanagementsystem.service;

import cn.edu.bjut.librarymanagementsystem.dto.BookLocationRequest;
import cn.edu.bjut.librarymanagementsystem.entity.BookLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.bjut.librarymanagementsystem.repository.BookLocationRepository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class BookLocationService {

    private final BookLocationRepository bookLocationRepository;
    @Autowired
    private BookService bookService;

    @Autowired
    public BookLocationService(BookLocationRepository bookLocationRepository) {
        this.bookLocationRepository = bookLocationRepository;
    }

    // 获取所有图书位置
    public List<BookLocation> getAllBookLocations() {
        return bookLocationRepository.findAll();
    }

    // 根据barcode查找图书位置
    public Optional<BookLocation> getBookLocationByBarcode(String barcode) {
        return bookLocationRepository.findByBarcode(barcode);
    }

    // 根据书籍ID查找所有位置
    public List<BookLocation> getBookLocationsByBookId(int bookId) {
        return bookLocationRepository.findByBookId(bookId);
    }

    // 根据图书位置状态查找
    public List<BookLocation> getBookLocationsByStatus(BookLocation.LocationStatus status) {
        return bookLocationRepository.findByStatus(status);
    }

    // 保存图书位置（新增）自动生成createdAt与updatedAt
    public BookLocation createBookLocation(BookLocationRequest bookLocation) {
        BookLocation bookLocationEntity = new BookLocation();
        bookLocationEntity.setBarcode(bookLocation.barcode());
        bookLocationEntity.setBookId(bookLocation.bookId());
        bookLocationEntity.setBranch(bookLocation.branch());
        bookLocationEntity.setFloor(bookLocation.floor());
        bookLocationEntity.setShelfNo(bookLocation.shelfNo());
        bookLocationEntity.setCellNo(bookLocation.cellNo());
        bookLocationEntity.setStatus(bookLocation.status());
        bookLocationEntity.setPrice(bookLocation.price());
        bookLocationEntity.setDamageNote(bookLocation.damageNote());
        Timestamp now = Timestamp.from(Instant.now());
        bookLocationEntity.setCreatedAt(now);
        bookService.ModifyTotalCopies(bookLocation.bookId(), 1); // 新增图书位置时，增加可用副本数
        bookService.ModifyAvailableCopies(bookLocation.bookId(), 1); // 新增图书位置时，增加可借副本数
        return bookLocationRepository.save(bookLocationEntity);
    }

    // 更新图书位置信息（不允许修改barcode主键）
    public Optional<BookLocation> updateBookLocation(String barcode, BookLocationRequest incoming) {
        return bookLocationRepository.findByBarcode(barcode).map(existing -> {
            // 可更新字段
            existing.setBranch(incoming.branch());
            existing.setFloor(incoming.floor());
            existing.setShelfNo(incoming.shelfNo());
            existing.setCellNo(incoming.cellNo());
            existing.setStatus(incoming.status());
            existing.setPrice(incoming.price());
            existing.setDamageNote(incoming.damageNote());
            existing.setUpdatedAt(Timestamp.from(Instant.now()));
            return bookLocationRepository.save(existing);
        });
    }

    // 删除图书位置
    public void deleteBookLocation(String barcode) {
        bookLocationRepository.deleteById(barcode);
        var bookLocation = bookLocationRepository.findByBarcode(barcode).get();
        bookService.ModifyTotalCopies(bookLocation.getBookId(), -1); // 删除图书位置时，减少可用副本数
        if (bookLocation.getStatus() == BookLocation.LocationStatus.在馆) {
            bookService.ModifyAvailableCopies(bookLocation.getBookId(), -1); // 如果删除的图书位置是可借状态，减少可用副本数
        }
    }

    // 更新图书位置状态（单独的状态更新）
    public boolean updateBookLocationStatus(String barCode, String newStatus) {
        Optional<BookLocation> optional = bookLocationRepository.findByBarcode(barCode);
        if (optional.isPresent()) {
            BookLocation location = optional.get();
            try {
                BookLocation.LocationStatus status = BookLocation.LocationStatus.valueOf(newStatus);
                location.setStatus(status);
                location.setUpdatedAt(Timestamp.from(Instant.now()));
                if (status == BookLocation.LocationStatus.在馆) {
                    bookService.ModifyAvailableCopies(location.getBookId(), 1); // 状态改为在馆，增加可借副本数
                } else {
                    bookService.ModifyAvailableCopies(location.getBookId(), -1); // 状态改为非在馆，减少可借副本数
                }
                bookLocationRepository.save(location);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return false;
    }
}
