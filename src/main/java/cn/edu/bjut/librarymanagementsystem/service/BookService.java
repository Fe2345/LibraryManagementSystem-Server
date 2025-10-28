package cn.edu.bjut.librarymanagementsystem.service;

import cn.edu.bjut.librarymanagementsystem.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.bjut.librarymanagementsystem.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // 获取所有书籍
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // 根据书名查找书籍
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    // 根据ID查找书籍
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    // 保存书籍
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // 更新书籍
    public Book updateBook(Integer id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setBookId(id); // 设置bookId以确保更新的是正确的书籍
            return bookRepository.save(book);
        }
        return null;
    }

    // 删除书籍
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
