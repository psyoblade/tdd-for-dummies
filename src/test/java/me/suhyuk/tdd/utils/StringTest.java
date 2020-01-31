package me.suhyuk.tdd.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @Test
    public void 스플릿함수_테스트() {
        int expected = 10;
        int actual = 0;
        String[] values = "1,2.3:4".split("[,:.]");
        for (String value: values) actual += Integer.parseInt(value);
        assertEquals(expected, actual);
    }
}
