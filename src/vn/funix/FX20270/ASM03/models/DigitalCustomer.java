package vn.funix.FX20270.ASM03.models;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DigitalCustomer extends Customer {
    public DigitalCustomer(String name, String customerID) {
        super(name, customerID);
    }

    public DigitalCustomer() {
    }

    @Override
    public void withdraw() {
     super.withdraw();
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
    }

}
