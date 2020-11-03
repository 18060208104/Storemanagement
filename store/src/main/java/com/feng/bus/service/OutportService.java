package com.feng.bus.service;

import com.feng.bus.domain.Outport;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fwf
 * @since 2020-11-03
 */

public interface OutportService extends IService<Outport> {

    void addOutPort(Integer id, Integer number, String remark);
}
