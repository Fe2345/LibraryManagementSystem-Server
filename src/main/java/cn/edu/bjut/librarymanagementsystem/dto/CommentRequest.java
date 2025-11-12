package cn.edu.bjut.librarymanagementsystem.dto;

import cn.edu.bjut.librarymanagementsystem.entity.BookReview;

public record CommentRequest(Integer userId, Integer bookId, String title, Byte rating, BookReview.ReviewStatus status,String comment) {

}
