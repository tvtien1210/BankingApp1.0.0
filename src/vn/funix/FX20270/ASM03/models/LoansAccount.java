package vn.funix.FX20270.ASM03.models;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoansAccount extends Account implements ReportService, Withdraw {
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    private final double LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;
    private final double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;
    private final double LOAN_ACCOUNT_MAX_BALANCE = 100000000;

    public LoansAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public LoansAccount() {
    }


    @Override
    public boolean withdraw(double amount) {
        // Số tiền cần rút phải thoả mãn điều kiện bên dưới
        if (amount >= 50000 && amount <= 5000000 && (amount % 10000 == 0)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isAccepted(double newBalance) {
        // newBalane = getBalance() - amount;
        if (newBalance >= 50000) {
            return true;
        }
        return false;
    }

    @Override
    public void log(String accountNumber, double amount, double balance, double transactionFee) {
        System.out.println(" +----------+--------------------------");
        System.out.printf("%30s%n", "BIÊN LAI GIAO DỊCH LOAN");
        System.out.printf("NGAY G/D: %28s%n", getDateTime());
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2024");
        System.out.printf("SO TK: %31s%n", accountNumber);
        System.out.printf("SO TIEN: %29s%n", formatter.format(amount) + " VND");
        System.out.printf("SO DU: %31s%n", formatter.format(balance) + " VND");
        System.out.printf("PHI + VAT: %27s%n", formatter.format(transactionFee) + " VND");
    }


    public String getAccountType() {
        return "LOANS";
    }

    @Override
    public String toString() {
        return "Đã thêm số tài khoản " + getAccountNumber() + " =>" + getAccountType() + " |" + formatter.format(getBalance()) + " VND";

    }
}
