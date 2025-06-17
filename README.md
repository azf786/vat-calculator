# VAT Calculator

A simple console-based VAT calculator built in Java to demonstrate object-oriented design principles.

## Features

- Calculates VAT from a gross amount (default: 19%)
- Saves results to a CSV file
- VAT rate loaded from `vat.properties`

## Requirements
- Java 17+
- Maven

## How to Run

Build and run:

```bash
mvn clean package
java -cp target/vat-calculator-1.0-SNAPSHOT.jar org.azfar.vatcalculator.Main
