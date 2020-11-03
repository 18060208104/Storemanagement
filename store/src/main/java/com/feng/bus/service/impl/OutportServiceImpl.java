package com.feng.bus.service.impl;

import com.feng.bus.domain.Goods;
import com.feng.bus.domain.Inport;
import com.feng.bus.domain.Outport;
import com.feng.bus.mapper.GoodsMapper;
import com.feng.bus.mapper.InportMapper;
import com.feng.bus.mapper.OutportMapper;
import com.feng.bus.service.OutportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feng.sys.common.WebUtils;
import com.feng.sys.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fwf
 * @since 2020-11-03
 */
@Service
@Transactional

public class OutportServiceImpl extends ServiceImpl<OutportMapper, Outport> implements OutportService {
   @Autowired
    private InportMapper inportMapper;  //要使这不爆红可以在dao层加上@Repository
   @Autowired
   private GoodsMapper goodsMapper;

    public void addOutPort(Integer id, Integer number,String remark){
     //根据进货单ID查询进货单信息
        Inport inport = inportMapper.selectById(id);
     //根据商品信息查询商品信息
        Goods goods = goodsMapper.selectById(inport.getGoodsid());
        goods.setNumber(goods.getNumber()-number);
        goodsMapper.updateById(goods);
     //添加退货信息
        Outport entity = new Outport();
        entity.setGoodsid(inport.getGoodsid());
        entity.setNumber(number);
        User user = (User) WebUtils.getSession().getAttribute("user");
        entity.setOperateperson(user.getName());
        entity.setOutportprice(inport.getInportprice());
        entity.setOutputtime(new Date());
        entity.setPaytype(inport.getPaytype());
        entity.setProviderid(inport.getProviderid());
        entity.setRemark(remark);
        getBaseMapper().insert(entity);
   }
}
