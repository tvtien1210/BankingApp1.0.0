package vn.funix.FX20270.ASM02.models;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class Account {
    private String accountNumber; // 6 chu so khong duoc trung nhau trong he thong
    private double balance; // so du tai khoan

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

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    // Kiểm tra từng phần tử trong List accounts được truyền vào qua tham số List<Account> a
    public boolean isPremiumAccount() {
        if (getBalance() > 10000000) {
            return true;
        }
        return false;
    }


    // In ra màn hình Mã tài khoản + Số dư (Hàm toString : cứ trỏ đến class sẽ tự in ra theo cấu trúc toString)
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return "Đã thêm số tài khoản " + accountNumber + " |               " + formatter.format(balance) + "VND";
    }


}