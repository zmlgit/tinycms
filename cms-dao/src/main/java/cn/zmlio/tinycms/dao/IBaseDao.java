package cn.zmlio.tinycms.dao;

import org.hibernate.Criteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangmanliang on 2016/8/22.
 */

public interface IBaseDao {


    /**
     * @param tClass
     * @param id
     * @return
     */
    <T> T get(Class<T> tClass, Serializable id);


    <T> T merge(T bean);


    /**
     * @param tClass
     * @return
     */
    <T>  List<T> listAll(Class<T> tClass);

    /**
     * @param bean
     */
    <T> Serializable save(T bean);

    /**
     * @param entities
     */
    <T> void saveAll(Collection<T> entities);

    /**
     * @param bean
     */
    <T> void update(T bean);

    /**
     * @param object
     */
    <T> void delete(Object object);

    /**
     * @param tClass
     * @param id
     */
    <T>  void delete(Class<T> tClass, Serializable id);

    /**
     * @param entities
     */
    <T> void deleteAll(Collection<T> entities);

    /**
     * @param tClass
     * @param properties
     * @param values
     * @return
     */
    <T> List<T> list(Class<T> tClass, String[] properties, Object[] values);

    /**
     * @param tClass
     * @param properties
     * @param values
     * @param pageable
     * @return
     */
    <T> Page<T> listByPage(Class<T> tClass, String[] properties, Object[] values, Pageable pageable);

    /**
     * @param tClass
     * @param params
     * @param pageable
     * @return
     */
    <T> Page<T> listByPage(Class<T> tClass, Map<String, Object> params, Pageable pageable);

    <T> List<T> list(Class<T> tClass, Map<String, Object> params);

    <T> void evict(T t);

    <T> Page<T> listByPage(Criteria criteria, Pageable pageable);

}

