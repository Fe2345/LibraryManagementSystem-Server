package cn.edu.bjut.librarymanagementsystem.dto;
import cn.edu.bjut.librarymanagementsystem.entity.BookLocation.LocationStatus;
import java.time.Year;

public record BookQueryRequest(String title, String author, String isbn, String publisher, Year yearFrom, Year yearTo, LocationStatus status) {
}
