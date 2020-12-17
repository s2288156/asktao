package com.asktao.mybatis.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wcy
 */
@Data
public class PageResult<E extends Serializable> implements Serializable {

    private static final long serialVersionUID = -8086169844802444430L;

    private Long total;

    private Integer size;

    private Long current;

    private List<E> records;

    public static <E extends Serializable> PageResult<E> createFor(Page<?> page) {
        PageResult<E> pageResult = new PageResult<>();
        pageResult.setCurrent(page.getCurrent());
        pageResult.setSize(page.getRecords().size());
        pageResult.setTotal(page.getTotal());
        return pageResult;
    }

}
