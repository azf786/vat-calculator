package org.azfar.vatcalculator.calculator.percentage;

import org.azfar.vatcalculator.calculator.VATCalculator;
import org.azfar.vatcalculator.calculator.percentage.policy.VATPolicy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PercentVATCalculator implements VATCalculator {
    private final VATPolicy policy;

    public PercentVATCalculator(VATPolicy policy) {
        this.policy = policy;
    }

    @Override
    public BigDecimal calculateVAT(BigDecimal grossAmount) {
        if (grossAmount == null) throw new IllegalArgumentException("Gross amount cannot be null");
        if (grossAmount.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Gross amount cannot be negative");

        BigDecimal rate = BigDecimal.valueOf(policy.getRate());

        BigDecimal net = grossAmount.divide(BigDecimal.ONE.add(rate), 10, RoundingMode.HALF_UP);

        return grossAmount.subtract(net).setScale(2, RoundingMode.HALF_UP);
    }
}
