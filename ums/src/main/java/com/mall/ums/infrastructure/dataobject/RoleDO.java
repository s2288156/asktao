package com.mall.ums.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author wcy-auto
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@TableName(autoResultMap = true, value = "t_role")
public class RoleDO {

    private String id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 名称
     **/
    private String name;

    /**
     * 描述
     **/
    private String description;

    /**
     * 排序
     **/
    private Integer sort;

}
