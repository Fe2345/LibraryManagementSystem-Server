package cn.edu.bjut.librarymanagementsystem.controller;

import cn.edu.bjut.librarymanagementsystem.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cn.edu.bjut.librarymanagementsystem.service.UserRoleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    // 获取所有用户角色
    @GetMapping
    public ResponseEntity<List<UserRole>> getAllUserRoles() {
        List<UserRole> userRoles = userRoleService.getAllUserRoles();
        return new ResponseEntity<>(userRoles, HttpStatus.OK);
    }

    // 根据ID查找用户角色
    @GetMapping("/{id}")
    public ResponseEntity<UserRole> getUserRoleById(@PathVariable Long id) {
        Optional<UserRole> userRole = userRoleService.getUserRoleById(id);
        return userRole.map(role -> new ResponseEntity<>(role, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 根据角色名查找用户角色
    @GetMapping("/role-name/{roleName}")
    public ResponseEntity<List<UserRole>> getUserRolesByRoleName(@PathVariable String roleName) {
        List<UserRole> userRoles = userRoleService.getUserRolesByRoleName(roleName);
        return new ResponseEntity<>(userRoles, HttpStatus.OK);
    }

    // 根据用户ID查找用户角色
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserRole>> getUserRolesByUserId(@PathVariable Long userId) {
        List<UserRole> userRoles = userRoleService.getUserRolesByUserId(userId);
        return new ResponseEntity<>(userRoles, HttpStatus.OK);
    }

    // 根据多个角色名称查找用户角色
    @GetMapping("/roles")
    public ResponseEntity<List<UserRole>> getUserRolesByRoleNames(@RequestParam List<String> roleNames) {
        List<UserRole> userRoles = userRoleService.getUserRolesByRoleNames(roleNames);
        return new ResponseEntity<>(userRoles, HttpStatus.OK);
    }

    // 保存用户角色
    @PostMapping
    public ResponseEntity<UserRole> saveUserRole(@RequestBody UserRole userRole) {
        UserRole savedUserRole = userRoleService.saveUserRole(userRole);
        return new ResponseEntity<>(savedUserRole, HttpStatus.CREATED);
    }

    // 删除用户角色
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserRole(@PathVariable Long id) {
        userRoleService.deleteUserRole(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
