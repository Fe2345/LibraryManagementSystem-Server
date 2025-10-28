package cn.edu.bjut.librarymanagementsystem.dto;

import cn.edu.bjut.librarymanagementsystem.entity.Book;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;

import java.sql.Timestamp;
import java.time.Year;
import cn.edu.bjut.librarymanagementsystem.entity.Book.BookStatus;

public record BookQueryByIdResponse (
        Integer bookId,
        String title,
        String subtitle,
        String isbn,
        String authors,
        String publisher,
        Year pubYear,
        String language,
        String keywords,
        String summary,
        Integer pages,
        String edition,
        Integer totalCopies,
        Integer availableCopies,
        Book.BookStatus status){
}
