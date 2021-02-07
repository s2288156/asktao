package com.asktao.lib.domain;

import com.asktao.lib.dto.Query;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractPageQuery extends Query implements Serializable {

    private static final long serialVersionUID = -7601268510908168984L;

    protected static final String SEPARATOR = ",";

    /**
     * 页数
     */
    private Long page;

    /**
     * 每页行数
     */
    private Long limit;

    /**
     * 格式：“+name” 、 "+id,+name,-age"
     */
    private String sort;

    public String[] splitSort() {
        return StringUtils.split(getSort(), SEPARATOR);
    }
}
