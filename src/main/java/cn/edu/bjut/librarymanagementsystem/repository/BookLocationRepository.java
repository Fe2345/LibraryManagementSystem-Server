package cn.edu.bjut.librarymanagementsystem.repository;

import cn.edu.bjut.librarymanagementsystem.entity.BookLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cn.edu.bjut.librarymanagementsystem.entity.BookLocation.LocationStatus;

import java.util.List;

@Repository
public interface BookLocationRepository extends JpaRepository<BookLocation, Long> {

    // 根据书籍ID查找该书籍所有位置
    List<BookLocation> findByBook(int book);

    // 根据书籍的当前状态查找位置（例如在馆或借出）
    List<BookLocation> findByStatus(LocationStatus status);

    // 可以按需求添加更多的自定义查询方法
}
