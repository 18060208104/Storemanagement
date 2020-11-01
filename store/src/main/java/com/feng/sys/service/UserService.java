package com.feng.sys.service;

import com.feng.sys.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feng.sys.vo.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *

 */
public interface UserService extends IService<User> {

    /**
     * 保存用户和角色之间的关系
     * @param uid
     * @param ids
     */
    void saveUserRole(Integer uid, Integer[] ids);

    void updateById(UserVo userVo);

    void save(UserVo userVo);
}
