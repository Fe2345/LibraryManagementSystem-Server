package cn.edu.bjut.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cn.edu.bjut.librarymanagementsystem.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDateTime;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    // 根据用户ID查找审计日志
    List<AuditLog> findByOperator_UserId(Long userId);

    // 根据操作类型查找审计日志（例如：登录、借书、还书等）
    List<AuditLog> findByAction(String action);

    // 根据操作时间范围查找审计日志
    List<AuditLog> findByOperationTimeBetween(LocalDateTime start, LocalDateTime end);

    // 根据用户ID和操作类型查找审计日志
    List<AuditLog> findByOperator_UserIdAndAction(Long userId, String action);

    // 根据操作类型和时间范围查找审计日志
    List<AuditLog> findByActionAndOperationTimeBetween(String action, LocalDateTime start, LocalDateTime end);
}
