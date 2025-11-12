package cn.edu.bjut.librarymanagementsystem.dto;

import cn.edu.bjut.librarymanagementsystem.entity.Users;

public record RegisterRequest(
    String loginName,
    String password,
    String email,
    String phone,
    String realName,
    Boolean gender,
    String studentNo,
    String department,
    Users.Role role
) {}

