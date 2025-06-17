package org.azfar.vatcalculator;

import org.azfar.vatcalculator.calculator.percentage.policy.ImplementedVATPolicy;
import org.azfar.vatcalculator.calculator.percentage.PercentVATCalculator;
import org.azfar.vatcalculator.calculator.VATCalculator;
import org.azfar.vatcalculator.calculator.percentage.policy.VATPolicy;
import org.azfar.vatcalculator.exporter.CSVExporter;
import org.azfar.vatcalculator.exporter.Exporter;

public class Main {
    public static void main(String[] args) {
        VATPolicy policy = new ImplementedVATPolicy();
        VATCalculator calculator = new PercentVATCalculator(policy);
        Exporter exporter = new CSVExporter();

        Application app = new Application(calculator, exporter);
        app.run();
    }
}