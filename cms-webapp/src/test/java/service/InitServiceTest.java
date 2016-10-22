package service;

import cn.zmlio.tinycms.service.InitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ZML on 2016/10/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE)
public class InitServiceTest {
    @Autowired
    InitService initService;

    @Test
    public void collectMappedUrls() throws Exception {
        initService.collectMappedUrls();
    }

}