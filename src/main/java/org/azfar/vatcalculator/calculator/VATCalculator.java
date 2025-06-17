package org.azfar.vatcalculator.calculator;

import java.math.BigDecimal;

public interface VATCalculator {
    BigDecimal calculateVAT(BigDecimal grossAmount);
}
