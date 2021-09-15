package com.asktao.mall.infrastructure.dataobject;

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
@TableName(autoResultMap = true, value = "t_merchant")
public class MerchantDO {

    private String id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String username;

    private String password;

    /**
     * 店铺名称
     **/
    private String shopName;

}
