package com.asktao.mybatis.base;

import com.asktao.lib.domain.AbstractPageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageQuery extends AbstractPageQuery {

    public <T> Page<T> createPage(Class<T> bean) {
        Page<T> page = new Page<>(getPage(), getLimit());

        return page;
    }
}
