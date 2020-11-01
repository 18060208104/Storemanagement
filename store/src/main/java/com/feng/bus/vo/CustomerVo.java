package com.feng.bus.vo;

import com.feng.bus.domain.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerVo extends Customer {

        private static final long serialVersionUID = 1L;
        Integer page =1;
        Integer limit=10;
        Integer [] ids;
}
