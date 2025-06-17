package org.azfar.vatcalculator.UI;

import java.util.Scanner;

public class SimpleUI {
    private final Scanner scanner = new Scanner(System.in);

    public double askAmount() {
        System.out.print("Bitte geben Sie den Bruttobetrag ein: ");
        try {
            double amount = Double.parseDouble(scanner.nextLine().trim());
            if (amount < 0) {
                throw new NumberFormatException("Negativer Betrag ist nicht erlaubt.");
            }
            return amount;
        } catch (NumberFormatException e) {
            System.out.println("Ungültiger Betrag. Bitte geben Sie eine positive Zahl ein.");
            return askAmount(); // retry
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
