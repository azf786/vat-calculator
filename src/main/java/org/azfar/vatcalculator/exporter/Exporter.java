package org.azfar.vatcalculator.exporter;

import java.math.BigDecimal;

public interface Exporter {
    void export(BigDecimal vatAmount, String filename);
}
