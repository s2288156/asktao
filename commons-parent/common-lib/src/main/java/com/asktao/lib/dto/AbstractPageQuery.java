package com.asktao.lib.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    private String[] splitSort() {
        return StringUtils.split(getSort(), SEPARATOR);
    }

    public List<SortItem> handleSort() {
        return Arrays.stream(splitSort())
                .map(item -> new SortItem(StringUtils.contains(item, "+"), StringUtils.substring(item, 1)))
                .collect(Collectors.toList());
    }

    public static class SortItem {
        private final boolean isAsc;

        private final String fieldName;

        public SortItem(boolean isAsc, String fieldName) {
            this.isAsc = isAsc;
            this.fieldName = fieldName;
        }

        public boolean isAsc() {
            return isAsc;
        }

        public String getFieldName() {
            return fieldName;
        }

    }
}
