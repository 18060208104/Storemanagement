package com.feng.sys.vo;

import com.feng.sys.domain.Permission;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PermissionVo extends Permission{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     Integer page =1;
     Integer limit=10;
	
	
}
