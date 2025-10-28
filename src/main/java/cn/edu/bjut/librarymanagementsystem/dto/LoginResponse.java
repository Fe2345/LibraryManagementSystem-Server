package cn.edu.bjut.librarymanagementsystem.dto;

public record LoginResponse(String token, Integer userId, String loginName) {
}
