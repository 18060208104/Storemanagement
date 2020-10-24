package com.feng.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feng.sys.domain.Loginfo;
import com.feng.sys.mapper.LoginfoMapper;
import com.feng.sys.service.LoginfoService;
import org.springframework.stereotype.Service;

@Service
public class LoginfoServiceImpl extends ServiceImpl<LoginfoMapper, Loginfo> implements LoginfoService {
}
