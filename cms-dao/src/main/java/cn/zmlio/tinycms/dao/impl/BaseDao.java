package cn.zmlio.tinycms.dao.impl;

import cn.zmlio.tinycms.dao.IBaseDao;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by zhangmanliang on 2016/8/22.
 */
@Repository("baseDao")
@Slf4j
public class BaseDao extends HibernateDaoSupport implements IBaseDao {

    @Resource
    public void setHibernateTemplate2(HibernateTemplate hibernateTemplate) {
        logger.trace("hibernateTemplate setting :" + hibernateTemplate);
        super.setHibernateTemplate(hibernateTemplate);
    }

    protected Class getMethodGenericType(String method) {
        try {
            Method currentMethod = this.getClass().getMethod(method);

            Type type = currentMethod.getGenericReturnType();

            return Class.forName(type.getTypeName());

        } catch (NoSuchMethodException e) {
            logger.error(e.getLocalizedMessage(), e);
        } catch (ClassNotFoundException e) {
            logger.error(e.getLocalizedMessage(), e);
        }
        return null;
    }


    @Override
    public <T> T get(Class<T> tClass, Serializable id) {
        return getHibernateTemplate().get(tClass, id);
    }

    @Override
    public <T> T merge(T bean) {
        return getHibernateTemplate().merge(bean);
    }

    @Override
    public <T> List<T> listAll(Class<T> tClass) {
        return getHibernateTemplate().loadAll(tClass);
    }

    @Override
    public <T> Serializable save(T bean) {
        return getHibernateTemplate().save(bean);
    }

    @Override
    public <T> void saveAll(Collection<T> entities) {
        if (entities != null) {
            for (T t : entities) {
                getHibernateTemplate().save(t);
            }
        }
    }

    @Override
    public <T> void update(T bean) {
        getHibernateTemplate().update(bean);
    }

    @Override
    public <T> void delete(Object object) {
        getHibernateTemplate().delete(object);
    }

    @Override
    public <T> void delete(Class<T> tClass, Serializable id) {
        getHibernateTemplate().delete(get(tClass, id));
    }

    @Override
    public <T> void deleteAll(Collection<T> entities) {
        getHibernateTemplate().deleteAll(entities);
    }

    @Override
    public <T> List<T> list(Class<T> tClass, String[] properties, Object[] values) {

        Criteria criteria = prepareCriteria(tClass, properties, values);

        List<T> results = criteria.list();

        return results;

    }

    @Override
    public <T> List<T> list(Class<T> tClass, Map<String, Object> params) {

        Criteria criteria = prepareCriteria(tClass, params);

        List<T> results = criteria.list();

        return results;

    }

    @Override
    public <T> void evict(T t) {
        getHibernateTemplate().evict(t);
    }

    @Override
    public <T> Page<T> listByPage(Criteria criteria, Pageable pageable) {

        int startRow = pageable == null ? 0 : pageable.getOffset();
        int pageSize = pageable == null ? 0 : pageable.getPageSize();

        Long totalCount = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();

        criteria.setProjection(null);
        if (pageSize != 0) {
            criteria.setFirstResult(startRow);
            criteria.setMaxResults(pageSize);
        }
        List<T> results = criteria.list();

        //results = results == null ? new ArrayList<T>() : results;

        Page<T> pager = new PageImpl<T>(results, pageable, totalCount == null ? 0 : totalCount);

        return pager;
    }

    @Override
    public <T> Page<T> listByPage(Class<T> tClass, String[] properties, Object[] values, Pageable pageable) {

        Criteria criteria = prepareCriteria(tClass, properties, values);
        return listByPage(criteria, pageable);

    }


    @Override
    public <T> Page<T> listByPage(Class<T> tClass, Map<String, Object> params, Pageable pageable) {

        Criteria criteria = prepareCriteria(tClass, params);
        int startRow = pageable == null ? 0 : pageable.getOffset();
        int pageSize = pageable == null ? 0 : pageable.getPageSize();

        Long totalCount = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();

        criteria.setProjection(null);
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        if (pageSize != 0) {
            criteria.setFirstResult(startRow);
            criteria.setMaxResults(pageSize);
        }
        List<T> results = criteria.list();

        //results = results == null ? new ArrayList<T>() : results;

        Page<T> pager = new PageImpl<T>(results, pageable, totalCount == null ? 0 : totalCount);

        return pager;

    }

    private Criteria prepareCriteria(Class tClass, String[] properties, Object[] values) {
        Map<String, Object> params = new HashMap();
        if (properties != null && values != null) {
            for (int i = 0; i < properties.length; i++) {
                if (i < values.length) {
                    params.put(properties[i], values[i]);
                }
            }
        }
        return prepareCriteria(tClass, params);
    }

    private Criteria prepareCriteria(Class tClass, Map<String, Object> params) {

        getHibernateTemplate().setCacheQueries(true);
        Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(tClass);
        criteria.setCacheable(true);
        if (criteria != null) {
            if (params != null) {
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    criteria.add(Restrictions.eqOrIsNull(entry.getKey(), entry.getValue()));
                }
            }
        }
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria;
    }
}
