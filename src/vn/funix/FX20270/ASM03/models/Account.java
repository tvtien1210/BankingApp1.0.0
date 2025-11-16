package vn.funix.FX20270.ASM03.models;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber; // 6 chu so khong duoc trung nhau trong he thong
    private double balance; // so du tai khoan

    private String accountType;

    private List<Transaction> accountTransactions = new ArrayList<Transaction>();

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public List<Transaction> getTransactionsHistory() {
        return accountTransactions;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDateTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormtObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormtObj);
        return formattedDate;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }


    public void setAccountTransactions(List<Transaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    public List<Transaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void addTransactions(Transaction o) {
        this.accountTransactions.add(o);
    }

    // Kiểm tra từng phần tử trong List accounts được truyền vào qua tham số List<Account> a
    public boolean isPremiumAccount(double balance) {
        if (balance > 10000000) {
            return true;
        }
        return false;
    }

    public double getPremiumTransactioneFee(double amount) {
        return amount / 100;
    }

    public double getNormalTransactioneFee(double amount) {
        return amount * 5 / 100;

    }


    // In ra màn hình Mã tài khoản + Số dư (Hàm toString : cứ trỏ đến class sẽ tự in ra theo cấu trúc toString)
    public String toString() {
        return "Override by SavingsAccount Class and LoansAccount Class";

    }
}