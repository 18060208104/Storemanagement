package com.feng.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.sys.common.DataGridView;
import com.feng.sys.common.ResultObj;
import com.feng.sys.domain.Loginfo;
import com.feng.sys.service.LoginfoService;
import com.feng.sys.vo.LoginfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("loginfo")
public class LoginfoController {

    @Autowired
    private LoginfoService loginfoService;

    //全查询

    @RequestMapping("loadAllLoginfo")
    public DataGridView loadAllLoginfo(LoginfoVo loginfoVo){
        IPage<Loginfo> page = new Page<>(loginfoVo.getPage(),loginfoVo.getLimit());
        QueryWrapper<Loginfo> queryWrapper = new QueryWrapper<>();//batisplus的查询操作
      //模糊查询
        queryWrapper.like(StringUtils.isNotBlank(loginfoVo.getLoginname()),"loginname", loginfoVo.getLoginname());

        queryWrapper.like(StringUtils.isNotBlank(loginfoVo.getLoginip()), "loginip",loginfoVo.getLoginip());
        //ge  大于  le 小于
        queryWrapper.ge(loginfoVo.getStartTime()!=null, "logintime", loginfoVo.getStartTime());
        queryWrapper.le(loginfoVo.getEndTime()!=null, "logintime", loginfoVo.getEndTime());
        //按照时间排序
        queryWrapper.orderByDesc("logintime");

        this.loginfoService.page(page, queryWrapper);

        return new DataGridView(page.getTotal(),page.getRecords());  //查看类DataGridView构造方法

    }
  //删除    根据id删除
    @RequestMapping("deleteLoginfo")
    public ResultObj deleteLoginfo(Integer id){
        try{
            this.loginfoService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultObj.DELETE_ERROR;
        }
    }
    /*这种String的也可以  但是要取修改页面的JavaScript函数
      否则后得不到状态码而不自动重新加载页面  使得虽然删除成功但还显示
      if(res.code==200){  //状态码
			tableIns.reload();  删除完重新加载当前文档}
    @RequestMapping("deleteLoginfo")
    public String deleteLoginfo(Integer id){
       try{
            this.loginfoService.removeById(id);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return  "no";
        }
    }*/
  /*  @RequestMapping("batchDeleteLoginfo")
  //批量删除： 这里的 实体类+Vo（其实就是数据库字段为了操作的需要而额外添加的 继承了原来的实体类）
  //后面传的是批量选中的id数组（详见LoginfoManger.html中） 此时下来的方法可以直接将数组作为参数
  //使用mybatisplus来删除操作
  //public ResultObj  batchDeleteLoginfo(LoginfoVo  loginfoVo)参数是一个实体类
  //但是下面还是根据实体获取当数据字段ids  for (Integer id : loginfoVo.getIds())
  // 没被注释的是直接传数组
     public ResultObj  batchDeleteLoginfo(LoginfoVo  loginfoVo) {
        try {
        Collection<Serializable> idList=new ArrayList<Serializable>();
        for (Integer id : loginfoVo.getIds()) {  //前端
            idList.add(id);
        }
        this.loginfoService.removeByIds(idList);
        return ResultObj.DELETE_SUCCESS;
    } catch (Exception e) {
        e.printStackTrace();
        return ResultObj.DELETE_ERROR;
    }

    }*/
    @RequestMapping("batchDeleteLoginfo")
    public ResultObj  batchDeleteLoginfo(int  ids[]) {  //批量删除的id集合
        try {
            Collection<Serializable> idList=new ArrayList<Serializable>();
            for (Integer id : ids) {  //前端
                idList.add(id);
            }
            this.loginfoService.removeByIds(idList);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

}
