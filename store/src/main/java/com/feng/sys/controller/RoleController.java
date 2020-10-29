package com.feng.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.sys.common.DataGridView;
import com.feng.sys.service.RoleService;
import com.feng.sys.vo.RoleVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fwf
 * @since 2020-10-29
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping("loadAllRole")
    public DataGridView laodAllRole(RoleVo roleVo){
            IPage page1 = new Page(roleVo.getPage(),roleVo.getLimit());
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.like(StringUtils.isNotBlank(roleVo.getName()),"name",roleVo.getName());
            queryWrapper.like(StringUtils.isNotBlank(roleVo.getRemark()),"remark",roleVo.getRemark());
            roleService.page(page1,queryWrapper);
            return new DataGridView(page1.getTotal(),page1.getRecords());


        }
}

