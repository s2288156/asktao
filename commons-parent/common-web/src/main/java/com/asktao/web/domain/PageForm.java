package com.asktao.web.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wcy
 */
@Data
public class PageForm implements Serializable {
    private static final long serialVersionUID = -6998679630540245645L;

    /**
     * 页数
     */
    private Long current;

    /**
     * 每页行数
     */
    private Long size;

    /**
     * 排序方式集合，格式为 ["name:aes", "age:desc"]
     */
    private List<String> sortList;
}
