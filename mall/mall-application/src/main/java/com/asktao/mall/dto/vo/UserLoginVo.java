package com.asktao.mall.dto.vo;

import com.asktao.lib.dto.DTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wuyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserLoginVo extends DTO {

    private String token;

}
