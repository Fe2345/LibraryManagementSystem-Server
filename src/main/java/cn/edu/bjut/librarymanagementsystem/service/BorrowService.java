package cn.edu.bjut.librarymanagementsystem.service;

import cn.edu.bjut.librarymanagementsystem.entity.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.bjut.librarymanagementsystem.repository.BorrowRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {
    @Autowired
    private final BorrowRepository borrowRepository;
    @Autowired
    private BookLocationService bookLocationService;
    @Autowired
    private BookService bookService;

    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    public List<Borrow> getBorrowById(Integer id) {
        return borrowRepository.findByUserId(id);
    }

    public boolean createBorrow(Integer userId, String barCode,Integer days) {
        System.out.println(userId);
        Borrow borrow = new Borrow();
        borrow.setUserId(userId);
        borrow.setBarCode(barCode);
        String title = bookService.getBookById(bookLocationService.getBookLocationByBarCode(barCode).get().getBookId()).getTitle();
        borrow.setTitle(title);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        borrow.setBorrowTime(now);
        borrow.setDueTime(new Timestamp(now.getTime() + days * 24 * 60 * 60 * 1000)); // 设置到期时间为借阅时间加上指定天数
        borrow.setStatus(Borrow.BorrowStatus.借出中);
        borrow.setRenewCount(0);
        System.out.println(borrow);
        borrowRepository.save(borrow);
        bookLocationService.updateBookLocationStatus(barCode,"借出");
        bookService.decreaseAvailableCopies(bookLocationService.getBookLocationByBarCode(barCode).get().getBookId());
        return true;
    }

    public boolean renewBorrow(Integer borrowId, Integer days) {
        Optional<Borrow> optionalBorrow = borrowRepository.findByBorrowId(borrowId);
        if (optionalBorrow.isPresent()) {
            Borrow borrow = optionalBorrow.get();
            // 更新续借信息
            borrow.setDueTime(new Timestamp(borrow.getDueTime().getTime() + days * 24 * 60 * 60 * 1000)); // 延长14天
            borrow.setRenewCount(borrow.getRenewCount() + 1);
            borrowRepository.save(borrow);
            return true;
        }
        return false;
    }
    /*

    // 获取所有借阅记录
    public List<Borrow> getAllBorrows() {
        return borrowRepository.findAll();
    }



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
