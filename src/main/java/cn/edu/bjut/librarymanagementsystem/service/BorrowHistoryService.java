package cn.edu.bjut.librarymanagementsystem.service;

import cn.edu.bjut.librarymanagementsystem.entity.BorrowHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.bjut.librarymanagementsystem.repository.BorrowHistoryRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowHistoryService {
    /*
    private final BorrowHistoryRepository borrowHistoryRepository;

    @Autowired
    public BorrowHistoryService(BorrowHistoryRepository borrowHistoryRepository) {
        this.borrowHistoryRepository = borrowHistoryRepository;
    }

    // 获取所有借阅历史
    public List<BorrowHistory> getAllBorrowHistories() {
        return borrowHistoryRepository.findAll();
    }

    // 根据ID查找借阅历史
    public Optional<BorrowHistory> getBorrowHistoryById(Long id) {
        return borrowHistoryRepository.findById(id);
    }

    // 根据用户ID查找借阅历史
    public List<BorrowHistory> getBorrowHistoriesByUserId(Long userId) {
        return borrowHistoryRepository.findByUserId(userId);
    }

    // 根据书籍ID查找借阅历史
    public List<BorrowHistory> getBorrowHistoriesByBookId(Long bookId) {
        return borrowHistoryRepository.findByBookId(bookId);
    }

    // 根据用户ID和借阅时间范围查找借阅历史
    public List<BorrowHistory> getBorrowHistoriesByUserIdAndBorrowDateBetween(Long userId, Date startDate, Date endDate) {
        return borrowHistoryRepository.findByUserIdAndBorrowDateBetween(userId, startDate, endDate);
    }

    // 根据书籍ID和借阅时间范围查找借阅历史
    public List<BorrowHistory> getBorrowHistoriesByBookIdAndBorrowDateBetween(Long bookId, Date startDate, Date endDate) {
        return borrowHistoryRepository.findByBookIdAndBorrowDateBetween(bookId, startDate, endDate);
    }

    // 根据用户ID和归还时间范围查找借阅历史
    public List<BorrowHistory> getBorrowHistoriesByUserIdAndReturnDateBetween(Long userId, Date startDate, Date endDate) {
        return borrowHistoryRepository.findByUserIdAndReturnDateBetween(userId, startDate, endDate);
    }

    // 根据书籍ID和归还时间范围查找借阅历史
    public List<BorrowHistory> getBorrowHistoriesByBookIdAndReturnDateBetween(Long bookId, Date startDate, Date endDate) {
        return borrowHistoryRepository.findByBookIdAndReturnDateBetween(bookId, startDate, endDate);
    }

    // 根据借阅状态查找借阅历史
    public List<BorrowHistory> getBorrowHistoriesByStatus(String status) {
        return borrowHistoryRepository.findByStatus(status);
    }

    // 保存借阅历史
    public BorrowHistory saveBorrowHistory(BorrowHistory borrowHistory) {
        return borrowHistoryRepository.save(borrowHistory);
    }

    // 删除借阅历史
    public void deleteBorrowHistory(Long id) {
        borrowHistoryRepository.deleteById(id);
    }
     */
}
