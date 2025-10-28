package cn.edu.bjut.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "audit_log")
public class AuditLog {
    // getter/setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long logId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "operator_id", referencedColumnName = "user_id", nullable = false)
    private Users operator;

    @Column(name = "operator_role", nullable = false, length = 50)
    private String operatorRole;

    @Column(name = "entity_type", nullable = false, length = 50)
    private String entityType;

    @Column(name = "entity_id", nullable = false)
    private Long entityId;

    @Column(name = "action", nullable = false, length = 50)
    private String action;

    @Column(name = "old_data", columnDefinition = "json")
    private String oldData;

    @Column(name = "new_data", columnDefinition = "json")
    private String newData;

    @Column(name = "is_success", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean isSuccess = true;

    @Column(name = "error_message", columnDefinition = "text")
    private String errorMessage;

    @Column(name = "operation_time", nullable = false, insertable = false, updatable = false)
    private LocalDateTime operationTime;

}