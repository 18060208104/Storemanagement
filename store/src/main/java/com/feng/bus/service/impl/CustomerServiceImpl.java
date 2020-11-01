package com.feng.bus.service.impl;

import com.feng.bus.domain.Customer;
import com.feng.bus.mapper.CustomerMapper;
import com.feng.bus.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fwf
 * @since 2020-11-01
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
