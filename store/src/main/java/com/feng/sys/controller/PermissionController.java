package com.feng.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.sys.common.Constast;
import com.feng.sys.common.DataGridView;
import com.feng.sys.common.ResultObj;
import com.feng.sys.common.TreeNode;
import com.feng.sys.domain.Permission;
import com.feng.sys.service.PermissionService;
import com.feng.sys.vo.PermissionVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

  @Autowired
  PermissionService permissionService;
  //加载权限管理左边的树  json数据格式
    @RequestMapping("loadPermissionManagerLeftTreeJson")
  public DataGridView loadPermissionManagerLeftJson(PermissionVo permissionVo){
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("type", Constast.TYPE_MNEU);
        List<Permission> list =permissionService.list(queryWrapper);
        List<TreeNode> treeNodes=new ArrayList<>();

        for(Permission permission:list){
            Boolean spread=permission.getOpen()==1?true:false;
            treeNodes.add(new TreeNode(permission.getId(),permission.getPid(),permission.getTitle(),spread));
        }
        return  new DataGridView(treeNodes);
    }

    //查询
    @RequestMapping("loadAllPermission")
    public DataGridView loadAllPermisson(PermissionVo permissionVo){
        IPage page1 = new Page(permissionVo.getPage(),permissionVo.getLimit());
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("type",Constast.TYPE_PERMISSION);//只查权限
        queryWrapper.like(StringUtils.isNotBlank(permissionVo.getPercode()),"percode",permissionVo.getPercode());
        queryWrapper.like(StringUtils.isNotBlank(permissionVo.getTitle()),"title",permissionVo.getTitle());
        queryWrapper.eq(permissionVo.getId() != null, "id", permissionVo.getId());
        queryWrapper.eq(permissionVo.getId() != null, "pid", permissionVo.getId());
        queryWrapper.orderByAsc("ordernum");
        permissionService.page(page1,queryWrapper);

        return new DataGridView(page1.getTotal(),page1.getRecords());
    }
    //加载最大排序码
    @RequestMapping("loadPermissionMaxOrderNum")
    public Map<String, Object> loadPermissionMaxOrderNum() {
        Map<String, Object> map = new HashMap<String, Object>();

        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("ordernum");
        IPage<Permission> page = new Page<>(1, 1);
        List<Permission> list = this.permissionService.page(page, queryWrapper).getRecords();
        if (list.size() > 0) {
            map.put("value", list.get(0).getOrdernum() + 1);
        } else {
            map.put("value", 1);

        }
        return map;
    }
//添加
    @RequestMapping("addPermission")
    public ResultObj addPermission(PermissionVo permissionVo){
        try {
            permissionVo.setType(Constast.TYPE_PERMISSION);
            permissionService.save(permissionVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    //修改
    @RequestMapping("updatePermission")
    public ResultObj updatePermission(PermissionVo permissionVo){
        try {

            permissionService.updateById(permissionVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
    //删除
    @RequestMapping("deletePermission")
    public ResultObj deletePermission(PermissionVo permissionVo){
        try {
            permissionService.removeById(permissionVo.getId());
            return  ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

}

