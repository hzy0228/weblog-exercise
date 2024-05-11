package top.hdy.weblog.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.hdy.weblog.module.common.domain.dos.UserDO;
import top.hdy.weblog.module.common.domain.mapper.UserMapper;

import java.util.Date;

@SpringBootTest
class WeblogWebApplicationTests {


    @Autowired
    private UserMapper mapper;

    @Test
    void contextLoads() {
    }

    @Test
    void insertTest() {
        UserDO user = UserDO.builder()
                .username("sss")
                .password("123456")
                .createTime(new Date())
                .updateTime(new Date())
                .isDeleted(false).
                build();
        mapper.insert(user);
    }
}
