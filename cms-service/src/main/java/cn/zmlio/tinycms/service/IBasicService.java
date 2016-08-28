package cn.zmlio.tinycms.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by ZML on 2016/8/28.
 */
public interface IBasicService {


    <T> T get(Class<T> tClass, Serializable id);


    <T> T merge(T bean);

    <T> List<T> listAll(Class<T> tClass);

    <T> Serializable save(T bean);

    <T> void saveAll(Collection<T> entities);

    <T> void update(T bean);

    <T> void delete(T object);

    <T> void delete(Class<T> tClass, Serializable id);

    <T> void deleteAll(Collection<T> entities);

    <T> List<T> list(Class<T> tClass, String[] properties, Object[] values);

    <T> Page<T> listByPage(Class<T> tClass, String[] properties, Object[] values, Pageable pageable);

    <T> Page<T> listByPage(Class<T> tClass, Map<String, Object> params, Pageable pageable);

    <T> List<T> list(Class<T> tClass, Map<String, Object> params);

    <T> void evict(T t);


}
