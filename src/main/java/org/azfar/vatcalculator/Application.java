package org.azfar.vatcalculator;

import org.azfar.vatcalculator.ui.SimpleUI;
import org.azfar.vatcalculator.calculator.VATCalculator;
import org.azfar.vatcalculator.exporter.Exporter;

import java.math.BigDecimal;

public class Application {
    private final SimpleUI ui = new SimpleUI();
    private final Exporter exporter;
    private final VATCalculator calculator;

    public Application(VATCalculator calculator, Exporter exporter) {
        this.calculator = calculator;
        this.exporter = exporter;
    }

    public void run() {

        BigDecimal grossAmount = ui.askAmount();
        BigDecimal vatAmount = calculator.calculateVAT(grossAmount);

        exporter.export(vatAmount, "output.csv");

        ui.showMessage("Berechnung abgeschlossen. Ergebnis wurde in 'output.csv' gespeichert.");
    }
}
