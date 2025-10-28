package cn.edu.bjut.librarymanagementsystem.dto;

public record LoginRequest(String username, String password) {
    public String loginName() {
        return username;
    }
}
