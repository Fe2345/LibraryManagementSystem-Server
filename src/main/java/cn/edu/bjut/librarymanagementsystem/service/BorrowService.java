package cn.edu.bjut.librarymanagementsystem.service;

import cn.edu.bjut.librarymanagementsystem.entity.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.bjut.librarymanagementsystem.repository.BorrowRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {
    private final BorrowRepository borrowRepository;

    @Autowired
    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }
    public List<Borrow> getBorrowById(Integer id) {
        return borrowRepository.findByUserId(id);
    }
    /*

    // 获取所有借阅记录
    public List<Borrow> getAllBorrows() {
        return borrowRepository.findAll();
    }

    // 根据ID查找借阅记录



    // 根据书籍ID查找借阅记录
    public List<Borrow> getBorrowsByBookId(Long bookId) {
        return borrowRepository.findByBookId(bookId);
    }

    // 根据借阅状态查找借阅记录
    public List<Borrow> getBorrowsByStatus(String status) {
        return borrowRepository.findByStatus(status);
    }

    // 根据借阅时间范围查找借阅记录
    public List<Borrow> getBorrowsByBorrowDateBetween(Date startDate, Date endDate) {
        return borrowRepository.findByBorrowDateBetween(startDate, endDate);
    }

    // 根据用户ID和借阅时间范围查找借阅记录
    public List<Borrow> getBorrowsByUserIdAndBorrowDateBetween(Long userId, Date startDate, Date endDate) {
        return borrowRepository.findByUserIdAndBorrowDateBetween(userId, startDate, endDate);
    }

    // 根据书籍ID和借阅时间范围查找借阅记录
    public List<Borrow> getBorrowsByBookIdAndBorrowDateBetween(Long bookId, Date startDate, Date endDate) {
        return borrowRepository.findByBookIdAndBorrowDateBetween(bookId, startDate, endDate);
    }

    // 保存借阅记录
    public Borrow saveBorrow(Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    // 删除借阅记录
    public void deleteBorrow(Long id) {
        borrowRepository.deleteById(id);
    }

     */
}
