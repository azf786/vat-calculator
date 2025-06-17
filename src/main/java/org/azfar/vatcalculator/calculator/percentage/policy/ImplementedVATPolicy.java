package org.azfar.vatcalculator.calculator.percentage.policy;

import org.azfar.vatcalculator.exceptions.LoadException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * An implementation of VATPolicy that loads the VAT rate from a properties file at runtime.
 *
 * The VAT rate is read from a file named "vat.properties" located in the classpath.
 * The expected property key is "vat.rate", and the value should be a valid decimal number (e.g., 0.19 for 19%).
 *
 * If the properties file is missing or the rate is invalid, a LoadException is thrown.
 *
 * Note: This implementation can be extended to support loading VAT policies from a database or
 * to allow dynamic selection of different VAT policies at runtime.
 */
public class ImplementedVATPolicy implements VATPolicy {
    private final double rate;

    public ImplementedVATPolicy() {
        Properties props = new Properties();
        try (InputStream input = VATPolicy.class.getClassLoader().getResourceAsStream("vat.properties")) {
            if (input == null) {
                throw new IllegalStateException("Eigenschaftsdatei für Mehrwertsteuer wurde nicht gefunden.");
            }
            props.load(input);
            this.rate = Double.parseDouble(props.getProperty("vat.rate"));
        } catch (IOException | NumberFormatException e) {
            throw new LoadException("Mehrwertsteuersatz konnte nicht aus der Eigenschaftsdatei geladen werden.", e);
        }
    }


    @Override
    public double getRate() {
        return rate;
    }
}
