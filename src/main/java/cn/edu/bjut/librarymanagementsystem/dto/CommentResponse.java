package cn.edu.bjut.librarymanagementsystem.dto;

import cn.edu.bjut.librarymanagementsystem.entity.BookReview;

import java.sql.Timestamp;

public record CommentResponse(Integer reviewId,
                              Integer user,
                              Integer bookId,
                              Byte rating,
                              String reviewTitle,
                              String reviewContent,
                              String imageAttachments,
                              BookReview.ReviewStatus status,
                              Timestamp createdAt,
                              Timestamp updatedAt,
                              String isbn,
                              String username){
}
