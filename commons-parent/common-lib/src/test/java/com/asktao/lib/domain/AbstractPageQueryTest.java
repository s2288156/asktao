package com.asktao.lib.domain;

import com.asktao.lib.dto.AbstractPageQuery;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
class AbstractPageQueryTest {

    @Test
    void splitSortTestCase() {
        String aes = "+";
        String desc = "-";
        String f1 = "id";
        String f2 = "name";
        String f3 = "time";
        String s1 = aes + f1;
        String s2 = desc + f2;
        String s3 = aes + f3;

        String sort = s1 + AbstractPageQuery.SEPARATOR + s2 + AbstractPageQuery.SEPARATOR + s3;
        TestPageQuery pageQuery = new TestPageQuery();
        pageQuery.setSort(sort);

        List<AbstractPageQuery.SortItem> sortItems = pageQuery.handleSort();
        assertAll(
                () -> assertTrue(sortItems.get(0).isAsc()),
                () -> assertFalse(sortItems.get(1).isAsc()),
                () -> assertTrue(sortItems.get(2).isAsc()),
                () -> assertEquals(f1, sortItems.get(0).getFieldName()),
                () -> assertEquals(f2, sortItems.get(1).getFieldName()),
                () -> assertEquals(f3, sortItems.get(2).getFieldName())
        );

    }

    class TestPageQuery extends AbstractPageQuery {
    }

}