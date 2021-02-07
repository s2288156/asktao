package com.asktao.mybatis.base;

import com.asktao.lib.domain.AbstractPageQuery;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageQuery extends AbstractPageQuery {

    public <T> Page<T> createPage() {
        Page<T> page = new Page<>(getPage(), getLimit());
        List<OrderItem> orderItemList = handleSort()
                .stream()
                .map(sortItem -> sortItem.isAsc() ? OrderItem.asc(sortItem.getFieldName()) : OrderItem.desc(sortItem.getFieldName()))
                .collect(Collectors.toList());
        return page.addOrder(orderItemList);
    }

}
