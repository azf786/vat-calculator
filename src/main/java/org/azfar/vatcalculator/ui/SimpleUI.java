package org.azfar.vatcalculator.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * A simple console-based user interface for interacting with the user.
 *
 * This class provides methods for:
 * - Prompting the user to input a gross amount (as BigDecimal)
 * - Displaying messages to the console
 *
 * The user input is validated to ensure it is a non-negative decimal number.
 * Invalid input results in an error message and a retry prompt.
 */
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
