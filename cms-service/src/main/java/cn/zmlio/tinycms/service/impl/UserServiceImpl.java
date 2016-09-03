package cn.zmlio.tinycms.service.impl;

import cn.zmlio.tinycms.dao.UserRepository;
import cn.zmlio.tinycms.model.User;
import cn.zmlio.tinycms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ZML on 2016/9/3.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void createUser(User rawUser) {
        userRepository.saveAndFlush(rawUser);
    }
}
