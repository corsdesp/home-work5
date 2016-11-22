package com.epam.training.month;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyMonthTest {
    @Test
    public void testEndNext() throws Exception {
        assertTrue(MyMonth.JANUARY == MyMonth.DECEMBER.next());
    }

    @Test
    public void testNext() throws Exception {
        assertTrue(MyMonth.SEPTEMBER == MyMonth.AUGUST.next());
    }

    @Test
    public void testDays() throws Exception {
        assertTrue(MyMonth.APRIL.days(2016) == 30);
    }

    @Test
    public void testFebruaryDaysLeapYear() throws Exception {
        assertTrue(MyMonth.FEBRUARY.days(2016) == 29);
    }

    @Test
    public void testFebruaryDaysNotLeapYear() throws Exception {
        assertTrue(MyMonth.FEBRUARY.days(2015) == 28);
    }
}