package org.azfar.vatcalculator.calculator.percentage;

import org.azfar.vatcalculator.calculator.VATCalculator;
import org.azfar.vatcalculator.calculator.percentage.policy.VATPolicy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A VATCalculator implementation that calculates VAT based on a fixed percentage rate.
 *
 * This calculator assumes the gross amount already includes VAT. It extracts the net amount
 * from the gross by dividing by (1 + rate), then computes the VAT as the difference between
 * the gross and net amounts.
 *
 * The VAT rate is provided by the VATPolicy and is expressed as a decimal (e.g., 0.19 for 19%).
 * The result is rounded to 2 decimal places.
 *
 * Throws IllegalArgumentException if the gross amount is null or negative.
 */
public class PercentVATCalculator implements VATCalculator {
    private final VATPolicy policy;

    public PercentVATCalculator(VATPolicy policy) {
        this.policy = policy;
    }

    @Override
    public BigDecimal calculateVAT(BigDecimal grossAmount) {
        if (grossAmount == null) throw new IllegalArgumentException("Bruttobetrag darf nicht null sein");
        if (grossAmount.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Bruttobetrag darf nicht negativ sein");

        BigDecimal rate = BigDecimal.valueOf(policy.getRate());

        BigDecimal net = grossAmount.divide(BigDecimal.ONE.add(rate), 10, RoundingMode.HALF_UP);

        return grossAmount.subtract(net).setScale(2, RoundingMode.HALF_UP);
    }
}
