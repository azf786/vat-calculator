package org.azfar.vatcalculator;

import org.azfar.vatcalculator.ui.SimpleUI;
import org.azfar.vatcalculator.calculator.VATCalculator;
import org.azfar.vatcalculator.exporter.Exporter;

import java.math.BigDecimal;

/**
 * Main application class that coordinates user input, VAT calculation, and result export.
 *
 * This class uses a {@link SimpleUI} to interact with the user, a {@link VATCalculator}
 * to compute the VAT based on a gross amount, and an {@link Exporter} to save the result.
 *
 * The typical flow is:
 * - Prompt the user to enter the gross amount.
 * - Calculate the VAT value using the provided VATCalculator.
 * - Export the VAT amount to a file (e.g., CSV).
 * - Inform the user that the calculation and export have been completed.
 */
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
