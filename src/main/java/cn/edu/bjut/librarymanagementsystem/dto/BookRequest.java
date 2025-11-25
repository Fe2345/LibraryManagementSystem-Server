package cn.edu.bjut.librarymanagementsystem.dto;

import java.sql.Time;

public record BookRequest(String title,
                          String authors,
                          String subtitle,
                          String isbn,
                          String publisher,
                          int pubYear,
                          String language,
                          String keywords,
                          String summary,
                          int pages,
                          String edition) {
}
