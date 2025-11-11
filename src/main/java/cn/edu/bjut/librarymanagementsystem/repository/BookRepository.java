package cn.edu.bjut.librarymanagementsystem.repository;

import cn.edu.bjut.librarymanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    // 根据书名查找书籍
    List<Book> findByTitleContaining(String title);

    // 根据 ISBN 查找书籍
    Book findByIsbn(String isbn);

    // 根据书籍状态查找书籍
    List<Book> findByStatus(Book.BookStatus status);

    // 根据出版年份查找书籍
    List<Book> findByPubYear(Year pubYear);

    // 根据作者查找书籍
    List<Book> findByAuthorsContaining(String authors);

    // 根据书籍 ID 查找书籍
    Book findByBookId(Integer bookId);

    List<Book> findByTitle(String title);

    //根据书名是否包含关键字查找书籍
    List<Book> findBooksByTitleContaining(String keyword);
}
