package org.azfar.vatcalculator.ui;

import java.math.BigDecimal;
import java.util.Scanner;

public class SimpleUI {
    private final Scanner scanner = new Scanner(System.in);

    public BigDecimal askAmount() {
        System.out.print("Bitte geben Sie den Bruttobetrag ein: ");
        String input = scanner.nextLine();
        try {
            BigDecimal grossAmount = new BigDecimal(input.trim());
            if (grossAmount.compareTo(BigDecimal.ZERO) < 0) {
                throw new NumberFormatException("Negativer Betrag ist nicht erlaubt.");
            }
            return grossAmount;
        } catch (NumberFormatException e) {
            System.out.println("Ungültiger Betrag. Bitte geben Sie eine positive Zahl ein.");
            return askAmount(); // retry
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
