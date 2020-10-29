package com.feng.sys.vo;

import com.feng.sys.domain.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RoleVo extends Role {

    private static final long serialVersionUID = 1L;
    Integer page =1;
    Integer limit=10;

}
