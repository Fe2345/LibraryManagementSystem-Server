package cn.edu.bjut.librarymanagementsystem.dto;

public record BorrowRequest(
    Integer userId,
    String barCode,
    Integer days) {
}
