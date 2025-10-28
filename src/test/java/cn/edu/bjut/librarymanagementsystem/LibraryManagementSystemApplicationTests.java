package cn.edu.bjut.librarymanagementsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import cn.edu.bjut.librarymanagementsystem.repository.UsersRepository;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class LibraryManagementSystemApplicationTests {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    void testDatabaseConnectionAndQuery() {
        // 查询所有用户
        List<Users> users = usersRepository.findAll();
        System.out.println("用户数量: " + users.size());
        // 可断言或打印结果
        assertNotNull(users);
    }
}
