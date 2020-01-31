package me.suhyuk.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void null_또는_공백() {
        assertEquals(0, StringCalculator.splitAndSum(null));
        assertEquals(0, StringCalculator.splitAndSum(""));
    }

    @Test
    public void 값_하나() {
        assertEquals(1, StringCalculator.splitAndSum("1"));
    }

    @Test
    public void 값_쉼표() {
        assertEquals(3, StringCalculator.splitAndSum("1,2"));
    }

    @Test
    public void 값_쉼표_콜론() {
        assertEquals(6, StringCalculator.splitAndSum("1,2:3"));
    }

    @Test
    public void 값_쉼표_콜론_세미콜론() {
        assertEquals(10, StringCalculator.splitAndSum("1,2:3;4", ",:;"));
    }

    @Test(expected = RuntimeException.class)
    public void 숫자가_아닌경우_넘버포맷예외_발생() {
        StringCalculator.splitAndSum("I,2");
    }

    @Test(expected = RuntimeException.class)
    public void 음수인경우_런타임오류발생() {
        int expected = StringCalculator.splitAndSum("-1,2");
        int actual = StringCalculator.splitAndPositiveSum("-1,2");
        assertEquals(expected, actual);
    }

}
