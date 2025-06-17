package org.azfar.vatcalculator;

import org.azfar.vatcalculator.UI.SimpleUI;
import org.azfar.vatcalculator.calculator.VATCalculator;
import org.azfar.vatcalculator.exporter.Exporter;

public class Application {
    private final SimpleUI ui = new SimpleUI();
    private final Exporter exporter;
    private final VATCalculator calculator;

    public Application(VATCalculator calculator, Exporter exporter) {
        this.calculator = calculator;
        this.exporter = exporter;
    }

    public void run() {

        double grossAmount = ui.askAmount();
        double vatAmount = calculator.calculateVAT(grossAmount);

        exporter.export(vatAmount, "output.csv");

        ui.showMessage("Berechnung abgeschlossen. Ergebnis wurde in 'output.csv' gespeichert.");
    }
}
