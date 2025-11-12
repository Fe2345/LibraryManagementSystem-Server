package cn.edu.bjut.librarymanagementsystem.repository;

import cn.edu.bjut.librarymanagementsystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    // 根据邮箱查找用户
    Users findByEmail(String email);

    // 根据邮箱和登录名查找用户
    Users findByEmailAndLoginName(String email, String loginName);

    // 根据登录名查找用户
    Optional<Users> findByLoginName(String loginName);

    Optional<Users> findByUserId(Integer Userid);

    //删除用户
    void deleteByUserId(Integer Userid);
}
