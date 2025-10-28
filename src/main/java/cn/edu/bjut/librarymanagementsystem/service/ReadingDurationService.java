package cn.edu.bjut.librarymanagementsystem.service;

import cn.edu.bjut.librarymanagementsystem.entity.ReadingDuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.bjut.librarymanagementsystem.repository.ReadingDurationRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReadingDurationService {

    /*
    private final ReadingDurationRepository readingDurationRepository;

    @Autowired
    public ReadingDurationService(ReadingDurationRepository readingDurationRepository) {
        this.readingDurationRepository = readingDurationRepository;
    }

    // 获取所有阅读时长记录
    public List<ReadingDuration> getAllReadingDurations() {
        return readingDurationRepository.findAll();
    }

    // 根据ID查找阅读时长记录
    public Optional<ReadingDuration> getReadingDurationById(Long id) {
        return readingDurationRepository.findById(id);
    }

    // 根据用户ID查找阅读时长记录
    public List<ReadingDuration> getReadingDurationsByUserId(Long userId) {
        return readingDurationRepository.findByUserId(userId);
    }

    // 根据用户ID和日期范围查找阅读时长记录
    public List<ReadingDuration> getReadingDurationsByUserIdAndDateBetween(Long userId, Date startDate, Date endDate) {
        return readingDurationRepository.findByUserIdAndDateBetween(userId, startDate, endDate);
    }

    // 根据日期范围查找所有用户的阅读时长记录
    public List<ReadingDuration> getReadingDurationsByDateBetween(Date startDate, Date endDate) {
        return readingDurationRepository.findByDateBetween(startDate, endDate);
    }

    // 根据用户ID和书籍ID查找阅读时长记录
    public List<ReadingDuration> getReadingDurationsByUserIdAndBookId(Long userId, Long bookId) {
        return readingDurationRepository.findByUserIdAndBookId(userId, bookId);
    }

    // 获取某个用户在特定日期的最高阅读时长记录
    public ReadingDuration getTopReadingDurationByUserIdAndDate(Long userId, Date date) {
        return readingDurationRepository.findTopByUserIdAndDateOrderByReadingTimeDesc(userId, date);
    }

    // 获取某个用户在特定日期范围内的累计阅读时长
    public Long getTotalReadingTimeByUserIdAndDateBetween(Long userId, Date startDate, Date endDate) {
        return readingDurationRepository.sumReadingTimeByUserIdAndDateBetween(userId, startDate, endDate);
    }

    // 保存阅读时长记录
    public ReadingDuration saveReadingDuration(ReadingDuration readingDuration) {
        return readingDurationRepository.save(readingDuration);
    }

    // 删除阅读时长记录
    public void deleteReadingDuration(Long id) {
        readingDurationRepository.deleteById(id);
    }

     */
}
