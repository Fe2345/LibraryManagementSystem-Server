package cn.edu.bjut.librarymanagementsystem.dto;

import cn.edu.bjut.librarymanagementsystem.entity.BookLocation;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;

import java.math.BigDecimal;

public record BookLocationRequest (String barcode,
                                   int bookId,
                                   String branch,
                                   String floor,
                                   String shelfNo,
                                   String cellNo,
                                   BookLocation.LocationStatus status,
                                   BigDecimal price,
                                   String damageNote){
}
