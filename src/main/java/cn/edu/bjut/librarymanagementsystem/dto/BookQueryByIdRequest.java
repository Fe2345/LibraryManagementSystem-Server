package cn.edu.bjut.librarymanagementsystem.dto;

public record BookQueryByIdRequest(
    Long startId,
    Long endId
) {}
