package cn.edu.bjut.librarymanagementsystem.service;

import cn.edu.bjut.librarymanagementsystem.dto.RegisterRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.bjut.librarymanagementsystem.repository.UserRepository;
import cn.edu.bjut.librarymanagementsystem.entity.*;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 获取所有用户
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    // 根据ID查找用户
    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // 根据用户名查找用户
    public Optional<Users> getUserByUsername(String username) {
        return userRepository.findByLoginName(username);
    }

    // 根据邮箱查找用户
    public Users getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // 保存用户
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    // 删除用户
    @Transactional
    public void deleteUser(Integer id) {
        userRepository.deleteByUserId(id);
    }

    public boolean updateUser(Integer id, RegisterRequest req) {
        Optional<Users> optionalUser = userRepository.findByUserId(id);
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            user.setLoginName(req.loginName());
            user.setPassword(req.password());
            user.setEmail(req.email());
            user.setPhone(req.phone());
            user.setRealName(req.realName());
            user.setGender(req.gender() ? Users.Gender.男 : Users.Gender.女);
            user.setStudentNo(req.studentNo());
            user.setDepartment(req.department());
            userRepository.save(user);
            return  true;
        }
        return false;
    }
}
