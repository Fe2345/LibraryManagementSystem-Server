package cn.edu.bjut.librarymanagementsystem.service;

import cn.edu.bjut.librarymanagementsystem.dto.BookQueryRequest;
import cn.edu.bjut.librarymanagementsystem.entity.Book;
import cn.edu.bjut.librarymanagementsystem.entity.BookLocation;
import cn.edu.bjut.librarymanagementsystem.repository.BookLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.bjut.librarymanagementsystem.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookLocationRepository bookLocationRepository;

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

    public List<Book> ComplexSearch(BookQueryRequest req){
        //先取得全部记录，如果某一字段为null则不进行筛选
        List<Book> books = bookRepository.findAll();
        if(req.title() != null){
            books = books.stream().filter(book -> book.getTitle().contains(req.title())).toList();
        }
        if (req.author() != null){
            books = books.stream().filter(book -> book.getAuthors().contains(req.author())).toList();
        }
        if (req.isbn() != null){
            books = books.stream().filter(book -> book.getIsbn().equals(req.isbn())).toList();
        }
        if (req.publisher() != null){
            books = books.stream().filter(book -> book.getPublisher().contains(req.publisher())).toList();
        }
        if (req.yearFrom() != null && req.yearTo() != null){
            books = books.stream().filter(book -> book.getPubYear().compareTo(req.yearFrom())>=0 && book.getPubYear().compareTo(req.yearTo())<=0).toList();
        }
        if (req.status() != null){
            List<BookLocation> locations = bookLocationRepository.findByStatus(req.status());
            List<Integer> bookIds = locations.stream().map(BookLocation::getBook).toList();
            books = books.stream().filter(book -> bookIds.contains(book.getBookId())).toList();
        }
        return books;
    }
}
