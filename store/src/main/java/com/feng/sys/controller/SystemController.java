package com.feng.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//返回跳转页面
@RequestMapping("sys")
public class SystemController {
	
	/**
	 * 跳转到登陆页面
	 * 这个是  resouces/static/index.html代码  因为首先就会加载  通过这找到这个控制层实现下面的跳转
	 * <script type="text/javascript">
	 * 		window.location.href="/sys/toLogin";
	 * 	</script>
	 */
	@RequestMapping("toLogin")
	public String toLogin() {
		return "system/index/login";
	}
	
	/**
	 * 跳转到首页
	 * 实行跳转的这个地址是在resources/templates/system/index/login.html (location.href="/sys/index");
	 通过上面找到这个systemcontroller 然后就可以在这个systemcontroller里面实现页面的跳转
	 */
	@RequestMapping("index")
	public String index() {
		return "system/index/index";
	}//返回的是一个页面 index.html
	
	/**
	 * 跳转到工作台
	 */
	@RequestMapping("toDeskManager")
	public String toDeskManager() {
		return "system/index/deskManager";
	}
	
	/**
	 * 跳转到日志管理
	 * 
	 */
	@RequestMapping("toLoginfoManager")
	public String toLoginfoManager() {
		return "system/loginfo/loginfoManager";
	}
	
	/**
	 * 跳转到公告管理
	 * 
	 */
	@RequestMapping("toNoticeManager")
	public String toNoticeManager() {
		return "system/notice/noticeManager";
	}
/*
* 跳转到部门管理
*
* */
 @RequestMapping("toDeptManager")
	public String toDeptManager(){
 	return "system/dept/deptManager";
 }
 /*
   跳转到部门管理 --right
 *  */
 @RequestMapping("toDeptRight")
	public String  toDeptRight(){
 	return "system/dept/deptRight";
 }
	/*
      跳转到部门管理 --left
    *  */
	@RequestMapping("toDeptLeft")
	public String  toDeptLeft() {
		return "system/dept/deptLeft";
	}
	/*
	 * 跳转到菜单管理
	 *
	 * */
	@RequestMapping("toMenuManager")
	public String toPermissionManager(){
		return "system/menu/menuManager";
	}
	/*
         跳转到菜单管理 --left
       *  */
	@RequestMapping("toMenuLeft")
	public String  toPermissionLeft() {
		return "system/menu/menuLeft";
	}
	/*
   跳转到菜单管理 --right
 *  */
	@RequestMapping("toMenuRight")
	public String  toPermissionRight(){
		return "system/menu/menuRight";
	}
}
