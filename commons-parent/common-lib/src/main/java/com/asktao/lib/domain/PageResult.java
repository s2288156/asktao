package com.asktao.lib.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wcy
 */
@Data
public class PageResult<E> implements Serializable {

    private static final long serialVersionUID = -8086169844802444430L;

    private Long total;

    private Integer size;

    private Long current;

    private List<E> records;

}
