package com.sword1024.test.nameapi.test1;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class NumbersServiceTest {

    private NumbersService numbersService = new NumbersServiceImpl();

    @Test
    public void testMin() {
        numbersService.clear();
        numbersService.offer(new BigDecimal("1"));
        numbersService.offer(new BigDecimal("2"));
        numbersService.offer(new BigDecimal("3"));
        assertEquals(new BigDecimal("1"), numbersService.getMin());
    }

    @Test
    public void testMax() {
        numbersService.clear();
        numbersService.offer(new BigDecimal("1"));
        numbersService.offer(new BigDecimal("2"));
        numbersService.offer(new BigDecimal("3"));
        assertEquals(new BigDecimal("3"), numbersService.getMax());
    }

    @Test
    public void testAvg() {
        numbersService.clear();
        numbersService.offer(new BigDecimal("1"));
        numbersService.offer(new BigDecimal("2"));
        numbersService.offer(new BigDecimal("3"));
        assertEquals(new BigDecimal("2"), numbersService.getAvg());
    }
}
