package cn.edu.bjut.librarymanagementsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cn.edu.bjut.librarymanagementsystem.service.*;
import cn.edu.bjut.librarymanagementsystem.dto.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) { this.authService = authService; }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest req) {
        var userOpt = authService.getUserByLoginName(req.loginName());
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(404).body(new ApiResponse(false, "USER_NOT_EXIST", null));
        }
        var user = userOpt.get();
        if (!authService.checkPassword(user, req.password())) {
            return ResponseEntity.status(401).body(new ApiResponse(false, "PWD_ERROR", null));
        }
        String token = authService.generateToken(user);
        // 返回 token 和完整用户信息
        java.util.Map<String, Object> resp = new java.util.HashMap<>();
        resp.put("token", token);
        resp.put("user", user);
        return ResponseEntity.ok(new ApiResponse(true, "LOGIN_SUCCESS", resp));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest req) {
        ApiResponse result = authService.register(req);
        if (!result.success()) {
            return ResponseEntity.status(409).body(result); // 409: 冲突（用户名已存在）
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/modifyPwd")
    public ResponseEntity<ApiResponse> modifyPwd(@RequestBody ModifyPwdRequest req) {
        ApiResponse result = authService.modifyPassword(req);
        if (!result.success()) {
            return ResponseEntity.status(400).body(result); // 400: 错误请求
        }
        return ResponseEntity.ok(result);
    }
}
