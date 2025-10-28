package cn.edu.bjut.librarymanagementsystem.repository;

import cn.edu.bjut.librarymanagementsystem.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    // 根据角色名查找角色
    List<UserRole> findByRoleName(String roleName);

    // 根据用户ID查找角色
    List<UserRole> findByUserId(Long userId);

    // 根据多个角色名称查找角色列表
    List<UserRole> findByRoleNameIn(List<String> roleNames);

    // 不需要再定义 findById(Long id)，因为 JpaRepository 已经提供了该方法
}
