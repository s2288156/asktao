package com.asktao.lib.dto;

import lombok.Data;

import java.util.Collection;

/**
 * @author wuyang
 */
@Data
public class PageResponse<T> extends Response{
    private static final long serialVersionUID = 1L;

    private Long total;

    private Collection<T> data;

    public static <T> PageResponse<T> of(Collection<T> data, long totalCount) {
        PageResponse<T> response = new PageResponse<>();
        response.setSuccess(true);
        response.setData(data);
        response.setTotal(totalCount);
        return response;
    }

}
