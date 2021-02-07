package com.asktao.lib.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
class AbstractPageQueryTest {

    @Test
    void splitSortTestCase1() {
        String sort = "+id";
        TestPageQuery pageQuery = new TestPageQuery();
        pageQuery.setSort(sort);

        assertEquals(0, pageQuery.splitSort().length);
        assertEquals(sort, pageQuery.splitSort()[0]);
    }

    @Test
    void splitSortTestCase2() {
        String s1 = "+id";
        String s2 = "-name";
        String s3 = "+time";
        String sort = s1 + AbstractPageQuery.SEPARATOR + s2 + AbstractPageQuery.SEPARATOR + s3;
        TestPageQuery pageQuery = new TestPageQuery();
        pageQuery.setSort(sort);

        assertAll(
                () -> assertEquals(3, pageQuery.splitSort().length),
                () -> assertEquals(s1, pageQuery.splitSort()[0]),
                () -> assertEquals(s2, pageQuery.splitSort()[1]),
                () -> assertEquals(s3, pageQuery.splitSort()[2])
        );
    }

    class TestPageQuery extends AbstractPageQuery {
    }

}