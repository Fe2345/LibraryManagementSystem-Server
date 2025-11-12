package cn.edu.bjut.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "login_name", nullable = false, unique = true)
    private String loginName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(name = "real_name", nullable = false)
    private String realName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "student_no", nullable = false, unique = true)
    private String studentNo;

    private String department;

    @Column(name = "created_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_code", nullable = false)
    private Role role;

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setRoleCode(Role role) {
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getRealName() {
        return realName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public String getDepartment() {
        return department;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public  Role getRole() {
        return role;
    }

    public enum Gender {
        男, 女
    }

    public enum Role {
        学生, 管理员
    }
}
