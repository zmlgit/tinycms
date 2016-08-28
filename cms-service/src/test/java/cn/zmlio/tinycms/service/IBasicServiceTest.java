package cn.zmlio.tinycms.service;

import cn.zmlio.tinycms.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ZML on 2016/8/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class IBasicServiceTest {

    @Autowired
    IBasicService basicService;

    @Test
    public void get() throws Exception {
        basicService.get(User.class,0);
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