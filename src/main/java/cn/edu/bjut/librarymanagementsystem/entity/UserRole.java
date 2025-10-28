package cn.edu.bjut.librarymanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users_roles")
public class UserRole {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Convert(converter = RoleCodeConverter.class)
    @Column(name = "role_code", nullable = false, length = 50, unique = true)
    private RoleCode roleCode;

    @Column(name = "role_name", nullable = false, length = 50)
    private String roleName;

    @Column(name = "description", length = 200)
    private String description;

    // 通过 userId 与 users.user_id 关联，但不让 JPA 在该端写入主键（users 为拥有端）
    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users user;

    // getters and setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public RoleCode getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(RoleCode roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    // Enum with database string values
    public enum RoleCode {
        READER("读者"),
        ADMIN("管理员");

        private final String dbValue;

        RoleCode(String dbValue) {
            this.dbValue = dbValue;
        }

        public String getDbValue() {
            return dbValue;
        }

        public static RoleCode fromDb(String dbValue) {
            if (dbValue == null) return null;
            for (RoleCode rc : values()) {
                if (rc.dbValue.equals(dbValue)) return rc;
            }
            return null;
        }

        @Override
        public String toString() {
            return dbValue;
        }
    }

    @Converter(autoApply = false)
    public static class RoleCodeConverter implements AttributeConverter<RoleCode, String> {

        @Override
        public String convertToDatabaseColumn(RoleCode attribute) {
            return attribute == null ? null : attribute.getDbValue();
        }

        @Override
        public RoleCode convertToEntityAttribute(String dbData) {
            return RoleCode.fromDb(dbData);
        }
    }
}