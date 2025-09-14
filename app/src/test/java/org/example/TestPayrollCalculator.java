package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPayrollCalculator {
    PayrollCalculator payrollCalculator;
    double hourlyPay = 16.78;
    @BeforeEach
    void setUp(){
        payrollCalculator = new PayrollCalculator();
    }
    @Test
    void itCalculatesThePayForZeroHoursWorked(){
        assertEquals(payrollCalculator.grossPay(0, hourlyPay), 0);
    }
    @Test
    void itCalculatesThePayForOneHourWorked(){
        assertEquals(payrollCalculator.grossPay(1, hourlyPay), 16.78);
    }
    @Test
    void itCalculatesOvertime(){
        assertEquals(payrollCalculator.grossPay(100, hourlyPay), 2181.4);
    }

    @Test
    void itCalculatesTenHoursWorked(){assertEquals(payrollCalculator.grossPay(10, hourlyPay), 167.8);}


}
