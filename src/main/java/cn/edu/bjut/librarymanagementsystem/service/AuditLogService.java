package cn.edu.bjut.librarymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.bjut.librarymanagementsystem.repository.AuditLogRepository;
import cn.edu.bjut.librarymanagementsystem.entity.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    @Autowired
    public AuditLogService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    // 获取所有审计日志
    public List<AuditLog> getAllAuditLogs() {
        return auditLogRepository.findAll();
    }

    // 根据ID查找审计日志
    public Optional<AuditLog> getAuditLogById(Long id) {
        return auditLogRepository.findById(id);
    }

    // 根据用户ID查找审计日志
    public List<AuditLog> getAuditLogsByUserId(Long userId) {
        return auditLogRepository.findByOperator_UserId(userId);
    }

    // 根据操作类型查找审计日志
    public List<AuditLog> getAuditLogsByActionType(String actionType) {
        return auditLogRepository.findByAction(actionType);
    }

    // 根据时间范围查找审计日志
    public List<AuditLog> getAuditLogsByTimestampBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return auditLogRepository.findByOperationTimeBetween(startDate, endDate);
    }

    // 根据用户ID和操作类型查找审计日志
    public List<AuditLog> getAuditLogsByUserIdAndActionType(Long userId, String actionType) {
        return auditLogRepository.findByOperator_UserIdAndAction(userId, actionType);
    }

    // 根据操作类型和时间范围查找审计日志
    public List<AuditLog> getAuditLogsByActionTypeAndTimestampBetween(String actionType, LocalDateTime startDate, LocalDateTime endDate) {
        return auditLogRepository.findByActionAndOperationTimeBetween(actionType, startDate, endDate);
    }

    // 保存审计日志
    public AuditLog saveAuditLog(AuditLog auditLog) {
        return auditLogRepository.save(auditLog);
    }

    // 删除审计日志
    public void deleteAuditLog(Long id) {
        auditLogRepository.deleteById(id);
    }
}
