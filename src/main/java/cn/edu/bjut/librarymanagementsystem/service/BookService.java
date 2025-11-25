package cn.edu.bjut.librarymanagementsystem.service;

import cn.edu.bjut.librarymanagementsystem.dto.BookQueryRequest;
import cn.edu.bjut.librarymanagementsystem.dto.BookRequest;
import cn.edu.bjut.librarymanagementsystem.entity.Book;
import cn.edu.bjut.librarymanagementsystem.entity.BookLocation;
import cn.edu.bjut.librarymanagementsystem.repository.BookLocationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.bjut.librarymanagementsystem.repository.BookRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Year;
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
        return bookRepository.findBooksByTitleContaining(title);
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
    public boolean updateBook(Integer id,BookRequest req) {
        Book book = BookRequestToEntityFormat(req);
        if (bookRepository.existsById(id)) {
            book.setBookId(id); // 设置bookId以确保更新的是正确的书籍
            book.setStorageTime(bookRepository.findById(id).get().getStorageTime()); // 保持原有的存储时间不变
            book.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
            bookRepository.save(book);
            return true;
        }
        return false;
    }

    private Book BookRequestToEntityFormat(BookRequest req) {
        Book book = new Book();
        book.setTitle(req.title());
        book.setAuthors(req.authors());
        book.setSubtitle(req.subtitle());
        book.setIsbn(req.isbn());
        book.setPublisher(req.publisher());
        book.setPubYear(Year.of(req.pubYear()));
        book.setLanguage(req.language());
        book.setKeywords(req.keywords());
        book.setSummary(req.summary());
        book.setPages(req.pages());
        book.setEdition(req.edition());
        book.setTotalCopies(0);
        book.setAvailableCopies(0);
        book.setStorageTime(Timestamp.valueOf(LocalDateTime.now()));
        book.setStatus(Book.BookStatus.上架);
        return book;
    }

    // 删除书籍
    @Transactional
    public void deleteBook(Integer id) {
        bookLocationRepository.deleteByBookId(id);
        bookRepository.deleteByBookId(id);
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
            List<Integer> bookIds = locations.stream().map(BookLocation::getBookId).toList();
            books = books.stream().filter(book -> bookIds.contains(book.getBookId())).toList();
        }
        return books;
    }

    public Integer addBook(BookRequest req) {
        try{
            Book book = BookRequestToEntityFormat(req);
            return bookRepository.save(book).getBookId();
        }catch (Exception e){
            return null;
        }
    }

    public boolean ModifyAvailableCopies(Integer bookId,Integer delta) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
                book.setAvailableCopies(book.getAvailableCopies() + delta);
                bookRepository.save(book);
                return true;
        }
        return false;
    }

    public boolean ModifyTotalCopies(Integer bookId,Integer delta) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
                book.setTotalCopies(book.getTotalCopies() + delta);
                bookRepository.save(book);
                return true;
        }
        return false;
    }

    public boolean updateBookStatus(Integer bookId, Book.BookStatus status) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setStatus(status);
            bookRepository.save(book);
            return true;
        }
        return false;
    }
}
