package cn.edu.bjut.librarymanagementsystem.service;

import cn.edu.bjut.librarymanagementsystem.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.bjut.librarymanagementsystem.repository.UserRoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    // 获取所有用户角色
    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    // 根据ID查找用户角色
    public Optional<UserRole> getUserRoleById(Long id) {
        return userRoleRepository.findById(id);
    }

    // 根据角色名查找角色
    public List<UserRole> getUserRolesByRoleName(String roleName) {
        return userRoleRepository.findByRoleName(roleName);
    }

    // 根据用户ID查找用户角色
    public List<UserRole> getUserRolesByUserId(Long userId) {
        return userRoleRepository.findByUserId(userId);
    }

    // 保存用户角色
    public UserRole saveUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    // 删除用户角色
    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }

    // 根据多个角色名称查找用户角色
    public List<UserRole> getUserRolesByRoleNames(List<String> roleNames) {
        return userRoleRepository.findByRoleNameIn(roleNames);
    }
}
