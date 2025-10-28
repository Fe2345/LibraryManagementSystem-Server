package cn.edu.bjut.librarymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import cn.edu.bjut.librarymanagementsystem.service.*;
import cn.edu.bjut.librarymanagementsystem.entity.*;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {

    private final AuditLogService auditLogService;

    @Autowired
    public AuditLogController(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    // 获取所有审计日志
    @GetMapping
    public ResponseEntity<List<AuditLog>> getAllAuditLogs() {
        List<AuditLog> auditLogs = auditLogService.getAllAuditLogs();
        return new ResponseEntity<>(auditLogs, HttpStatus.OK);
    }

    // 根据ID获取审计日志
    @GetMapping("/{id}")
    public ResponseEntity<AuditLog> getAuditLogById(@PathVariable Long id) {
        Optional<AuditLog> auditLog = auditLogService.getAuditLogById(id);
        return auditLog.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 根据用户ID获取审计日志
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AuditLog>> getAuditLogsByUserId(@PathVariable Long userId) {
        List<AuditLog> auditLogs = auditLogService.getAuditLogsByUserId(userId);
        return new ResponseEntity<>(auditLogs, HttpStatus.OK);
    }

    // 根据操作类型获取审计日志
    @GetMapping("/action/{actionType}")
    public ResponseEntity<List<AuditLog>> getAuditLogsByActionType(@PathVariable String actionType) {
        List<AuditLog> auditLogs = auditLogService.getAuditLogsByActionType(actionType);
        return new ResponseEntity<>(auditLogs, HttpStatus.OK);
    }

    // 根据时间范围获取审计日志
    @GetMapping("/timestamp")
    public ResponseEntity<List<AuditLog>> getAuditLogsByTimestampBetween(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        List<AuditLog> auditLogs = auditLogService.getAuditLogsByTimestampBetween(startDate, endDate);
        return new ResponseEntity<>(auditLogs, HttpStatus.OK);
    }

    // 根据用户ID和操作类型获取审计日志
    @GetMapping("/user/{userId}/action/{actionType}")
    public ResponseEntity<List<AuditLog>> getAuditLogsByUserIdAndActionType(@PathVariable Long userId, @PathVariable String actionType) {
        List<AuditLog> auditLogs = auditLogService.getAuditLogsByUserIdAndActionType(userId, actionType);
        return new ResponseEntity<>(auditLogs, HttpStatus.OK);
    }

    // 根据操作类型和时间范围获取审计日志
    @GetMapping("/action/{actionType}/timestamp")
    public ResponseEntity<List<AuditLog>> getAuditLogsByActionTypeAndTimestampBetween(@PathVariable String actionType, @RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        List<AuditLog> auditLogs = auditLogService.getAuditLogsByActionTypeAndTimestampBetween(actionType, startDate, endDate);
        return new ResponseEntity<>(auditLogs, HttpStatus.OK);
    }

    // 保存审计日志
    @PostMapping
    public ResponseEntity<AuditLog> saveAuditLog(@RequestBody AuditLog auditLog) {
        AuditLog savedAuditLog = auditLogService.saveAuditLog(auditLog);
        return new ResponseEntity<>(savedAuditLog, HttpStatus.CREATED);
    }

    // 删除审计日志
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuditLog(@PathVariable Long id) {
        auditLogService.deleteAuditLog(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
