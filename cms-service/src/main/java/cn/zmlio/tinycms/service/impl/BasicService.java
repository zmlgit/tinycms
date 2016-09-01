package cn.zmlio.tinycms.service.impl;

import cn.zmlio.tinycms.dao.IBaseDao;
import cn.zmlio.tinycms.service.IBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by ZML on 2016/8/28.
 */
@Service(value = "basicService")
@Transactional(readOnly = true)
public class BasicService implements IBasicService {

    @Autowired
    private IBaseDao baseDao;

    @Override
    public <T> T get(Class<T> tClass, Serializable id) {
        return baseDao.get(tClass, id);
    }

    @Override
    @Transactional
    public <T> T merge(T bean) {
        return baseDao.merge(bean);
    }

    @Override
    public <T> List<T> listAll(Class<T> tClass) {
        return baseDao.listAll(tClass);
    }

    @Override
    @Transactional
    public <T> Serializable save(T bean) {
        return baseDao.save(bean);
    }

    @Override
    @Transactional
    public <T> void saveAll(Collection<T> entities) {
        baseDao.saveAll(entities);
    }

    @Override
    @Transactional
    public <T> void update(T bean) {
        baseDao.update(bean);
    }

    @Override
    @Transactional
    public <T> void delete(T object) {
        baseDao.delete(object);
    }

    @Override
    @Transactional
    public <T> void delete(Class<T> tClass, Serializable id) {
        baseDao.delete(tClass, id);
    }

    @Override
    @Transactional
    public <T> void deleteAll(Collection<T> entities) {
        baseDao.deleteAll(entities);
    }

    @Override
    public <T> List<T> list(Class<T> tClass, String[] properties, Object[] values) {
        return baseDao.list(tClass, properties, values);
    }

    @Override
    public <T> Page<T> listByPage(Class<T> tClass, String[] properties, Object[] values, Pageable pageable) {
        return baseDao.listByPage(tClass, properties, values, pageable);
    }

    @Override
    public <T> Page<T> listByPage(Class<T> tClass, Map<String, Object> params, Pageable pageable) {
        return baseDao.listByPage(tClass, params, pageable);
    }

    @Override
    public <T> List<T> list(Class<T> tClass, Map<String, Object> params) {
        return baseDao.list(tClass, params);
    }

    @Override
    @Transactional
    public <T> void evict(T t) {
        baseDao.evict(t);
    }
}
