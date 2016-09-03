package cn.zmlio.tinycms.service;

import cn.zmlio.tinycms.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by ZML on 2016/8/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE)
public class IBasicServiceTest {

    @Autowired
    IBasicService basicService;

    @Test
    public void get() throws Exception {
        User user=new User();
        user.setUsername("Hello");
        basicService.save(user);
    }

    @Test
    public void merge() throws Exception {

    }

    @Test
    public void listAll() throws Exception {

    }

    @Test
    public void save() throws Exception {

    }

    @Test
    public void saveAll() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void delete1() throws Exception {

    }

    @Test
    public void deleteAll() throws Exception {

    }

    @Test
    public void list() throws Exception {

    }

    @Test
    public void listByPage() throws Exception {

    }

    @Test
    public void listByPage1() throws Exception {

    }

    @Test
    public void list1() throws Exception {

    }

    @Test
    public void evict() throws Exception {

    }

    @Before
    public void setUp() throws Exception {

    }

}