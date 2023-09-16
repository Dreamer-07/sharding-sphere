package pers.prover07.sharding.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pers.prover07.sharding.mapper.UserMapper;
import pers.prover07.sharding.model.User;

import java.util.List;

/**
 * 读写分离测试
 * @author 小丶木曾义仲丶哈牛柚子露丶蛋卷
 * @version 1.0
 * @date 2023/9/16 12:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadWriteTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test_Insert() {
        User user = new User();
        user.setUsername("prover");

        userMapper.insert(user);
    }

    @Transactional
    @Test
    public void test_Trans() {
        // 为了避免跨服务器之间的事务，shardjdbc 在事务中的插入和查询均会在主库上面执行
        // 同时在测试环境下使用事务，shardjdbc 会自动回滚
        User user = new User();
        user.setUsername("prover02");
        userMapper.insert(user);

        List<User> userList = userMapper.selectList(null);

        System.out.println(userList);
    }

    @Test
    public void test_AllData() {
        // 测试负载均衡
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

        List<User> users2 = userMapper.selectList(null);
        users2.forEach(System.out::println);
    }

}
