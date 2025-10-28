package cn.edu.bjut.librarymanagementsystem.dto;

public record ApiResponse(boolean success, String message, Object data) {
}
