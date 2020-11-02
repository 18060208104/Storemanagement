package com.feng.bus.vo;

import com.feng.bus.domain.Customer;
import com.feng.bus.domain.Goods;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GoodsVo extends Goods {

        private static final long serialVersionUID = 1L;
        Integer page =1;
        Integer limit=10;

}
