package com.mall.ums.domain.dataobject;

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
@TableName(autoResultMap = true, value = "t_resource")
public class Resource {

    private String id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 资源名称
     **/
    private String name;

    /**
     * 资源URL
     **/
    private String url;

    /**
     * 描述
     **/
    private String description;

}
