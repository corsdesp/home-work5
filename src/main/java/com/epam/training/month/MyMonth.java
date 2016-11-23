package com.epam.training.month;

import java.time.LocalDate;

public enum MyMonth {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;

    public MyMonth next() {
        return values()[(ordinal() + 1) % values().length];
    }

    public int days(int year) {
        LocalDate localDate = LocalDate.of(year, ordinal() + 1, 1);
        return localDate.lengthOfMonth();
    }
}
