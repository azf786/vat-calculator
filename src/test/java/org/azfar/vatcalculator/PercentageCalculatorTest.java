package org.azfar.vatcalculator;

import org.azfar.vatcalculator.calculator.VATCalculator;
import org.azfar.vatcalculator.calculator.percentage.PercentVATCalculator;
import org.azfar.vatcalculator.calculator.percentage.policy.VATPolicy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PercentageCalculatorTest {
    @Test
    void shouldCalculateVATForPositiveAmount() {
        VATPolicy mockedPolicy = Mockito.mock(VATPolicy.class);
        Mockito.when(mockedPolicy.getRate()).thenReturn(0.19);

        VATCalculator calculator = new PercentVATCalculator(mockedPolicy);
        BigDecimal gross = new BigDecimal("119.00");

        BigDecimal vat = calculator.calculateVAT(gross);

        assertEquals(new BigDecimal("19.00"), vat);
    }

    @Test
    void shouldReturnZeroVATForZeroAmount() {
        VATPolicy mockedPolicy = Mockito.mock(VATPolicy.class);
        Mockito.when(mockedPolicy.getRate()).thenReturn(0.19);

        VATCalculator calculator = new PercentVATCalculator(mockedPolicy);
        BigDecimal gross = BigDecimal.ZERO;

        BigDecimal vat = calculator.calculateVAT(gross);

        assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP), vat);
    }

    @Test
    void shouldThrowExceptionForNegativeAmount() {
        VATPolicy mockedPolicy = Mockito.mock(VATPolicy.class);
        Mockito.when(mockedPolicy.getRate()).thenReturn(0.19);

        VATCalculator calculator = new PercentVATCalculator(mockedPolicy);
        BigDecimal gross = new BigDecimal("-100.00");

        assertThrows(IllegalArgumentException.class, () -> calculator.calculateVAT(gross));
    }
}
