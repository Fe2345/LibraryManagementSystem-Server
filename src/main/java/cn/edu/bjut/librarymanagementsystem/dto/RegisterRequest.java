package cn.edu.bjut.librarymanagementsystem.dto;

public record RegisterRequest(
    String loginName,
    String password,
    String email,
    String phone,
    String realName,
    Boolean gender,
    String studentNo,
    String department
) {}

