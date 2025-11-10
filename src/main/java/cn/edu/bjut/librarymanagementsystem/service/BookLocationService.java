package cn.edu.bjut.librarymanagementsystem.service;

import cn.edu.bjut.librarymanagementsystem.entity.BookLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.bjut.librarymanagementsystem.repository.BookLocationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookLocationService {

    private final BookLocationRepository bookLocationRepository;

    @Autowired
    public BookLocationService(BookLocationRepository bookLocationRepository) {
        this.bookLocationRepository = bookLocationRepository;
    }

    // 获取所有图书位置
    public List<BookLocation> getAllBookLocations() {
        return bookLocationRepository.findAll();
    }

    // 根据ID查找图书位置
    public Optional<BookLocation> getBookLocationById(Long id) {
        return bookLocationRepository.findById(id);
    }

    // 根据书籍ID查找所有位置
    public List<BookLocation> getBookLocationsByBookId(int bookId) {
        return bookLocationRepository.findByBookId(bookId);
    }

    //根据BarCode查找图书位置
    public Optional<BookLocation> getBookLocationByBarCode(String barCode) {
        return bookLocationRepository.findByBarcode(barCode);
    }

    // 根据图书位置状态查找
    public List<BookLocation> getBookLocationsByStatus(BookLocation.LocationStatus status) {
        return bookLocationRepository.findByStatus(status);
    }

    // 保存图书位置
    public BookLocation saveBookLocation(BookLocation bookLocation) {
        return bookLocationRepository.save(bookLocation);
    }

    // 删除图书位置
    public void deleteBookLocation(Long id) {
        bookLocationRepository.deleteById(id);
    }

    // 更新图书位置状态
    public boolean updateBookLocationStatus(String barCode, String newStatus) {
        Optional<BookLocation> optional = bookLocationRepository.findByBarcode(barCode);
        if (optional.isPresent()) {
            BookLocation location = optional.get();
            try {
                BookLocation.LocationStatus status = BookLocation.LocationStatus.valueOf(newStatus);
                location.setStatus(status);
                bookLocationRepository.save(location);
                return true;
            } catch (IllegalArgumentException e) {
                // newStatus不是有效枚举
                return false;
            }
        }
        return false;
    }
}
