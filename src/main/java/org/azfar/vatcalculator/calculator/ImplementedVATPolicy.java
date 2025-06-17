package org.azfar.vatcalculator.calculator;

import org.azfar.vatcalculator.exceptions.LoadException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
    Note: This can be extended to load policies from DB and allow selection at runtime
 */

public class ImplementedVATPolicy implements VATPolicy{
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
