package com.feng.sys.vo;

import com.feng.sys.domain.Loginfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
public class LoginfoVo extends Loginfo {
    private static final long serialVersionUID = 1L;

    private Integer page=1;
    private Integer limit=10;

    private Integer[] ids; //接受多个id  批量删除  也可以不要此字段 在后端时直接获取前面传来的数组（id的集合）
                            //  然后再后端直接传参数为数组
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
