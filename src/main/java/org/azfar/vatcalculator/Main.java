package org.azfar.vatcalculator;

import org.azfar.vatcalculator.calculator.ImplementedVATPolicy;
import org.azfar.vatcalculator.calculator.PercentVATCalculator;
import org.azfar.vatcalculator.calculator.VATCalculator;
import org.azfar.vatcalculator.calculator.VATPolicy;
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