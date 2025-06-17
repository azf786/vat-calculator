package org.azfar.vatcalculator.calculator.percentage;

import org.azfar.vatcalculator.calculator.VATCalculator;
import org.azfar.vatcalculator.calculator.percentage.policy.VATPolicy;

public class PercentVATCalculator implements VATCalculator {
    private final VATPolicy policy;

    public PercentVATCalculator(VATPolicy policy) {
        this.policy = policy;
    }

    @Override
    public double calculateVAT(double grossAmount) {
        if(grossAmount < 0) {
            throw new IllegalArgumentException("Der Bruttobetrag darf nicht negativ sein");
        }
        double rate = policy.getRate();
        double net = grossAmount / (1 + rate);
        return grossAmount - net;
    }
}
