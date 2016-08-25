package cn.zmlio.tinycms.model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhangmanliang on 2016/8/22.
 */
public class ModelTest {
    @Test
    public void test(){
        Configuration configuration = new Configuration();
        configuration.configure();
      SessionFactory sessionFactory= configuration.buildSessionFactory();
        sessionFactory.openSession().get(User.class,0);
    }
}