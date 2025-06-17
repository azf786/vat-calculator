package org.azfar.vatcalculator.exporter;

public interface Exporter {
    void export(double vatAmount, String filename);
}
