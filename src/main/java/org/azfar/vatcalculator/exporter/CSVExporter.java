package org.azfar.vatcalculator.exporter;

import org.azfar.vatcalculator.exceptions.LoadException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class CSVExporter implements Exporter{
    @Override
    public void export(BigDecimal vatAmount, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true)) ){
            writer.println(vatAmount);
        } catch (IOException e) {
            throw new LoadException("Fehler beim Schreiben der CSV-Datei.", e);
        }
    }
}
