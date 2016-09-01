package cn.zmlio.tinycms.service;

import cn.zmlio.tinycms.dao.IBaseDao;
import cn.zmlio.tinycms.dao.impl.BaseDao;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * Created by ZML on 2016/9/1.
 */
@Configuration
@ComponentScan(basePackages = "cn.zmlio.tinycms")
public class ServiceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(name = "baseDao")
    public IBaseDao baseDao(HibernateTemplate hibernateTemplate) {
        BaseDao baseDao = new BaseDao();
        baseDao.setHibernateTemplate2(hibernateTemplate);
        return baseDao;
    }

}
