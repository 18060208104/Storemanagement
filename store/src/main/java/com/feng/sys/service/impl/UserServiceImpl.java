package com.feng.sys.service.impl;

import com.feng.sys.domain.User;
import com.feng.sys.mapper.UserMapper;
import com.feng.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
