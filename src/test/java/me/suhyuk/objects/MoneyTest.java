package me.suhyuk.objects;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyTest {

    @Test
    public void testAddMoney() {
        Money actual = Money.wons(10).plus(Money.wons(10));
        Money expected = Money.wons(20);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinusMoney() {
        Money actual = Money.wons(10).minus(Money.wons(10));
        Money expected = Money.wons(0);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyMoney() {
        Money actual = Money.wons(10).times(10);
        Money expected = Money.wons(100);
        assertEquals(expected, actual);
    }

}
