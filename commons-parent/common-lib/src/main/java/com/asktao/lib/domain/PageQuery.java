package com.asktao.lib.domain;

import com.asktao.lib.dto.Query;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageQuery extends Query implements Serializable {

    private static final long serialVersionUID = -7601268510908168984L;

    /**
     * 页数
     */
    private Long page;

    /**
     * 每页行数
     */
    private Long limit;

    private String sort;

    /**
     * 排序方式集合，格式为 ["name:aes", "age:desc"]
     */
    private List<String> sortList;

}
