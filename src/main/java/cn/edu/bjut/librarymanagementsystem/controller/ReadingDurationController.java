package cn.edu.bjut.librarymanagementsystem.controller;

import cn.edu.bjut.librarymanagementsystem.entity.ReadingDuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cn.edu.bjut.librarymanagementsystem.service.ReadingDurationService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reading-durations")
public class ReadingDurationController {
    /*
    private final ReadingDurationService readingDurationService;

    @Autowired
    public ReadingDurationController(ReadingDurationService readingDurationService) {
        this.readingDurationService = readingDurationService;
    }

    // 获取所有阅读时长记录
    @GetMapping
    public ResponseEntity<List<ReadingDuration>> getAllReadingDurations() {
        List<ReadingDuration> durations = readingDurationService.getAllReadingDurations();
        return new ResponseEntity<>(durations, HttpStatus.OK);
    }

    // 根据ID获取阅读时长记录
    @GetMapping("/{id}")
    public ResponseEntity<ReadingDuration> getReadingDurationById(@PathVariable Long id) {
        Optional<ReadingDuration> duration = readingDurationService.getReadingDurationById(id);
        return duration.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 根据用户ID获取阅读时长记录
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReadingDuration>> getReadingDurationsByUserId(@PathVariable Long userId) {
        List<ReadingDuration> durations = readingDurationService.getReadingDurationsByUserId(userId);
        return new ResponseEntity<>(durations, HttpStatus.OK);
    }

    // 根据用户ID和日期范围获取阅读时长记录
    @GetMapping("/user/{userId}/date-range")
    public ResponseEntity<List<ReadingDuration>> getReadingDurationsByUserIdAndDateBetween(
            @PathVariable Long userId,
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<ReadingDuration> durations = readingDurationService.getReadingDurationsByUserIdAndDateBetween(userId, startDate, endDate);
        return new ResponseEntity<>(durations, HttpStatus.OK);
    }

    // 根据日期范围获取所有用户的阅读时长记录
    @GetMapping("/date-range")
    public ResponseEntity<List<ReadingDuration>> getReadingDurationsByDateBetween(
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<ReadingDuration> durations = readingDurationService.getReadingDurationsByDateBetween(startDate, endDate);
        return new ResponseEntity<>(durations, HttpStatus.OK);
    }

    // 根据用户ID和书籍ID获取阅读时长记录
    @GetMapping("/user/{userId}/book/{bookId}")
    public ResponseEntity<List<ReadingDuration>> getReadingDurationsByUserIdAndBookId(
            @PathVariable Long userId,
            @PathVariable Long bookId) {
        List<ReadingDuration> durations = readingDurationService.getReadingDurationsByUserIdAndBookId(userId, bookId);
        return new ResponseEntity<>(durations, HttpStatus.OK);
    }

    // 获取某个用户在特定日期的最高阅读时长记录
    @GetMapping("/user/{userId}/date/{date}/top")
    public ResponseEntity<ReadingDuration> getTopReadingDurationByUserIdAndDate(
            @PathVariable Long userId,
            @PathVariable Date date) {
        ReadingDuration duration = readingDurationService.getTopReadingDurationByUserIdAndDate(userId, date);
        return duration != null ? new ResponseEntity<>(duration, HttpStatus.OK) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // 获取某个用户在特定日期范围内的累计阅读时长
    @GetMapping("/user/{userId}/total-time")
    public ResponseEntity<Long> getTotalReadingTimeByUserIdAndDateBetween(
            @PathVariable Long userId,
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        Long totalReadingTime = readingDurationService.getTotalReadingTimeByUserIdAndDateBetween(userId, startDate, endDate);
        return new ResponseEntity<>(totalReadingTime, HttpStatus.OK);
    }

    // 保存阅读时长记录
    @PostMapping
    public ResponseEntity<ReadingDuration> saveReadingDuration(@RequestBody ReadingDuration readingDuration) {
        ReadingDuration savedReadingDuration = readingDurationService.saveReadingDuration(readingDuration);
        return new ResponseEntity<>(savedReadingDuration, HttpStatus.CREATED);
    }

    // 删除阅读时长记录
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReadingDuration(@PathVariable Long id) {
        readingDurationService.deleteReadingDuration(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

     */
}
