package cn.zmlio.tinycms.dao;

import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;

/**
 * Created by ZML on 2016/9/1.
 */
@Configuration
@EntityScan("cn.zmlio")
public class DaoAutoConfiguration {

    @Bean(name = "sessionFactory")
    @Resource
    @ConditionalOnMissingBean(name = "sessionFactory")
    public SessionFactory sessionFactory(EntityManagerFactory factory) {

        if (factory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        return factory.unwrap(SessionFactory.class);
    }

    @Bean
    @ConditionalOnMissingBean(name = "hibernateTemplate")
    public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory){
        return new HibernateTemplate(sessionFactory);
    }
}
