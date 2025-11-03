package cn.edu.bjut.librarymanagementsystem.dto;

public record BookQueryByIdRequest(
    int startId,
    int endId
) {}
