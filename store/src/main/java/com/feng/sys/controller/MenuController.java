package com.feng.sys.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feng.sys.common.Constast;
import com.feng.sys.common.DataGridView;
import com.feng.sys.common.TreeNode;
import com.feng.sys.common.TreeNodeBuilder;
import com.feng.sys.common.WebUtils;
import com.feng.sys.domain.Permission;
import com.feng.sys.domain.User;
import com.feng.sys.service.PermissionService;
import com.feng.sys.vo.PermissionVo;

/**
 * <p>
 *  菜单管理前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/menu")
public class MenuController {



    @Autowired
    private PermissionService permissionService;


    @RequestMapping("loadIndexLeftMenuJson")
    public DataGridView  loadIndexLeftMenuJson(PermissionVo permissionVo) {
        //查询所有菜单
        QueryWrapper<Permission> queryWrapper=new QueryWrapper<>();
        //设置只能查询菜单
        queryWrapper.eq("type",Constast.TYPE_MNEU);  //查询字段type  其中值为menu
        queryWrapper.eq("available", Constast.AVAILABLE_TRUE);   //查旬是否可用

        User user = (User) WebUtils.getSession().getAttribute("user");
        List<Permission> list=null;
        if(user.getType()==Constast.USER_TYPE_SUPER) {
            list = permissionService.list(queryWrapper);
        }else {
            //根据用户ID+角色+权限去查询
            list = permissionService.list(queryWrapper);
        }

        List<TreeNode> treeNodes=new ArrayList<>();
        for (Permission p : list) {
            Integer id=p.getId();
            Integer pid=p.getPid();
            String title=p.getTitle();
            String icon=p.getIcon();
            String href=p.getHref();
            Boolean spread=p.getOpen()==Constast.OPEN_TRUE?true:false;
            treeNodes.add(new TreeNode(id, pid, title, icon, href, spread));
        }
        //构造层级关系
        List<TreeNode> list2 = TreeNodeBuilder.build(treeNodes, 1);
        return new DataGridView(list2);
    }

}

