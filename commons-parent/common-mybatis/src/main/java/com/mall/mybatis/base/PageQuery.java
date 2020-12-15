package com.mall.mybatis.base;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wcy
 */
@Data
public class PageQuery implements Serializable {

    private static final long serialVersionUID = 8479778172024555395L;

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

    public <T> Page<T> convert2Page(Class<T> clazz) {
        return defaultPage();
    }

    private <T> Page<T> defaultPage() {
        return new Page<T>(current, size).addOrder(OrderItem.desc(ColumnName.UPDATE_TIME));
    }

}
