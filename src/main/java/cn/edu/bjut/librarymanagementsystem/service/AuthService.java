package cn.edu.bjut.librarymanagementsystem.service;

import cn.edu.bjut.librarymanagementsystem.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import cn.edu.bjut.librarymanagementsystem.utils.*;
import cn.edu.bjut.librarymanagementsystem.dto.*;
import cn.edu.bjut.librarymanagementsystem.entity.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import cn.edu.bjut.librarymanagementsystem.entity.Users.Gender;

import static cn.edu.bjut.librarymanagementsystem.entity.Users.Gender.*;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder pwEncoder;
    private final JWTUtil jwtUtil;

    public AuthService(UserRepository userRepository, JWTUtil jwtUtil) {
        this.userRepository = userRepository;
        this.pwEncoder = new BCryptPasswordEncoder();
        this.jwtUtil = jwtUtil;
    }

    public ApiResponse login(String loginName, String rawPassword) {
        return userRepository.findByLoginName(loginName).map(user -> {
            if (pwEncoder.matches(rawPassword, user.getPassword())) {
                String token = jwtUtil.generateToken(user.getUserId(), user.getLoginName());
                // 登录成功时，返回用户全部数据
                return new ApiResponse(true, "LOGIN_SUCCESS", user);
            } else {
                return new ApiResponse(false, "INVALID_CREDENTIALS", null);
            }
        }).orElse(new ApiResponse(false, "USER_NOT_FOUND", null));
    }

    public ApiResponse register(RegisterRequest req) {
        System.out.println(req.realName());
        if (userRepository.findByLoginName(req.loginName()).isPresent()) {
            return new ApiResponse(false, "USERNAME_EXIST", null);
        }
        else if (userRepository.findByEmail(req.email()).isPresent()) {
            return new ApiResponse(false, "EMAIL_EXIST", null);
        }
        else if (userRepository.findByPhone(req.phone()).isPresent()) {
            return new ApiResponse(false, "PHONE_EXIST", null);
        }
        else if (userRepository.findByStudentNo(req.studentNo()).isPresent()) {
            return new ApiResponse(false, "STUDENT_NO_EXIST", null);
        }
        String hash = pwEncoder.encode(req.password());
        Users u = new Users();
        u.setLoginName(req.loginName());
        u.setPassword(hash);
        u.setEmail(req.email());
        u.setPhone(req.phone());
        u.setRealName(req.realName());
        u.setGender(req.gender() ? 男 : 女);
        u.setStudentNo(req.studentNo());
        u.setDepartment(req.department());
        u.setRoleCode(req.role());
        u.setCreatedTime(Timestamp.valueOf(LocalDateTime.now()));
        var saves = userRepository.save(u);
        return new ApiResponse(true, "REGISTER_SUCCESS", saves);
    }

    public Optional<Users> getUserByLoginName(String loginName) {
        return userRepository.findByLoginName(loginName);
    }

    public ApiResponse modifyPassword(ModifyPwdRequest req) {
        var userOpt = userRepository.findByLoginName(req.loginName());
        if (userOpt.isEmpty()) {
            return new ApiResponse(false, "USER_NOT_EXIST", null);
        }
        var user = userOpt.get();
        if (!user.getEmail().equals(req.email())) {
            return new ApiResponse(false, "EMAIL_INCORRECT", null);
        }
        String newHash = pwEncoder.encode(req.newPwd());
        user.setPassword(newHash);
        userRepository.save(user);
        return new ApiResponse(true, "MODIFY_PWD_SUCCESS", null);
    }

    public boolean checkPassword(Users user, String rawPassword) {
        return pwEncoder.matches(rawPassword, user.getPassword());
    }

    public String generateToken(Users user) {
        return jwtUtil.generateToken(user.getUserId(), user.getLoginName());
    }
}
