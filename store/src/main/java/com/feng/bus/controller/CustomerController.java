package com.feng.bus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.bus.domain.Customer;
import com.feng.bus.service.CustomerService;
import com.feng.bus.vo.CustomerVo;
import com.feng.sys.common.DataGridView;
import com.feng.sys.common.ResultObj;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fwf
 * @since 2020-11-01
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
   @Autowired
    CustomerService customerService;
//全查询
   @RequestMapping("loadAllCustomer")
    public DataGridView loadAllCustomer(CustomerVo customerVo){
       IPage<Customer> page = new Page<>(customerVo.getPage(),customerVo.getLimit());
       QueryWrapper queryWrapper = new QueryWrapper();
       queryWrapper.like(StringUtils.isNotBlank(customerVo.getCustomername()),"customername",customerVo.getCustomername());
       queryWrapper.like(StringUtils.isNotBlank(customerVo.getPhone()),"phone",customerVo.getPhone());
       queryWrapper.like(StringUtils.isNotBlank(customerVo.getConnectionperson()),"connectionperson",customerVo.getConnectionperson());
      this.customerService.page(page,queryWrapper);
       return new DataGridView (page.getTotal(),page.getRecords());
   }
   //添加
    @RequestMapping("/addCustomer")
    public ResultObj addCustomer(CustomerVo customerVo){
        try {
            this.customerService.save(customerVo);
            return  ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    //修改
    @RequestMapping("updateCustomer")
    public ResultObj updateCustomer(CustomerVo customerVo) {
        try {
            this.customerService.updateById(customerVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }


    //  删除

    @RequestMapping("deleteCustomer")
    public ResultObj deleteCustomer(Integer id) {
        try {
            this.customerService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除
     */

    @RequestMapping("batchDeleteCustomer")
    public ResultObj batchDeleteCustomer(CustomerVo customerVo) {
        try {
            Collection<Serializable> idList = new ArrayList<Serializable>();
            for (Integer id : customerVo.getIds()) {
                idList.add(id);

            }
            this.customerService.removeByIds(idList);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}

