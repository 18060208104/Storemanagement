package com.feng.sys.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author fwf
 * @since 2020-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dept")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer pid;

    private String title;

    private Integer open;

    private String remark;

    private String address;

    /**
     * 状态【0不可用1可用】
     */
    private Integer available;

    /**
     * 排序码【为了调事显示顺序】
     */
    private Integer ordernum;

    private Date createtime;


}
