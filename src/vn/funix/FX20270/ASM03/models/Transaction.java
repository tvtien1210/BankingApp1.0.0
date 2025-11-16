package vn.funix.FX20270.ASM03.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String transactionID; // ma random ngau nhien
    private String accountNumber; // ma tai khoan khach hang
    private double amount; // so tien ma khach hang muon rut

    private String time; // thoi gian giao dich

    private boolean status; // true la thanh cong, false la giao dich that bai

    public Transaction(String transactionID, String accountNumber, double amount, String time) {
        this.transactionID = transactionID;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.time = time;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {

        this.transactionID = transactionID;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public boolean isStatus() {
        return status;
    }
}
