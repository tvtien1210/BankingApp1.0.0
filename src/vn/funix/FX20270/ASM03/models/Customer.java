package vn.funix.FX20270.ASM03.models;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Customer extends User {
    // Ke thua NAME, customerID va cong them List<Account>

    private List<Account> accounts = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String customerID) {
        super(name, customerID);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    // Method add accounts
    public void addAccounts(Account o) {
        this.accounts.add(o);
    }

    // Phương thức cho biết khách hàng có phải là premium hay không, 1 khách hàng là premium nếu có ít nhất 1 tài khoản (Account) là premium
    public String printPremiumAccount() {
        for (Account account : accounts) {
            if (account.isPremiumAccount(account.getBalance())) {
                return "Premium";
            }
        }
        return "Normal";
    }

    // !!! IMPORTAIN: method getBlance này cần có tham số truyền vào là một ArrayList, nếu không có tham số list truyền vào, sẽ không xác định được List muốn tính tổng!!!
    public double getBalance() {
        double sum = 0;
        for (Account o : accounts) {
            sum += o.getBalance();
        }
        return sum;
    }

    public void withdraw() {
        // accountNumber: 6 số
        Scanner sc = new Scanner(System.in);
        SavingsAccount wdrSavingsAccount = new SavingsAccount();
        LoansAccount wdrLoansAccount = new LoansAccount();
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        // Dùng để thông báo Account không tồn tại, còn nếu account tồn tại, sẽ gán runAgain = true ở mỗi block if , và else và chạy tiếp.
        boolean runAgain = false;

        System.out.println("Nhập số tài khoản 6 số cần rút: ");
        String accountNumber = sc.nextLine();

        System.out.println("Nhập số tiền cần rút ");
        double amount = sc.nextDouble();

        // Lấy thông tin khách hàng qua class chính DigitalBank activeBank
        for (Account account : getAccounts()) {
            if (accountNumber.equals(account.getAccountNumber())) {
                if (account.getAccountType() == "SAVINGS") {
                    if (wdrSavingsAccount.isAccepted(account.getBalance() - amount)) {
                        if (wdrSavingsAccount.withdraw(amount)) {
                            double balance = account.getBalance() - amount;
                            account.setBalance(balance);
                            wdrSavingsAccount.log(account.getAccountNumber(), amount, account.getBalance(), 0);
                            // Tạo ID ngẫu nhiên
                            UUID uuid = UUID.randomUUID();
                            Transaction transaction = new Transaction(uuid.toString(), account.getAccountNumber(), amount, account.getDateTime());
                            account.addTransactions(transaction);
                            runAgain = true;
                        } else {
                            System.out.println("La tai khoan SAVINGS ,Khong the rut so tien vua nhap, so tien phai >=50K, <= 5000K, va la boi so cua 10K!!!");
                            runAgain = true;
                        }
                    } else {
                        System.out.println("Số dư tài khoản không đủ (số dư sẽ <50K VND nếu rút số tiền này), không thể thực hiện giao dịch!");
                        runAgain = true;
                    }

                }


                if (account.getAccountType() == "LOANS") {
                    if (wdrLoansAccount.isAccepted(account.getBalance())) {
                        if (wdrLoansAccount.withdraw(amount)) {
                            if (account.isPremiumAccount(account.getBalance())) {
                                double balance = account.getBalance() - amount;
                                // Gan gia tri Fee de getFee
                                account.getPremiumTransactioneFee(amount);
//                                System.out.println("check 1: " + account.getTransactioneFee());
                                double newBalance = balance - wdrLoansAccount.getPremiumTransactioneFee(amount);
                                account.setBalance(newBalance);
//                                System.out.println("check 2: " + account.getTransactioneFee());
                                wdrLoansAccount.log(account.getAccountNumber(), amount, account.getBalance(), account.getPremiumTransactioneFee(amount));
                                // Tạo ID ngẫu nhiên
                                UUID uuid = UUID.randomUUID();
                                Transaction transaction = new Transaction(uuid.toString(), account.getAccountNumber(), amount, account.getDateTime());
                                account.addTransactions(transaction);
                                runAgain = true;

                            } else {
                                double balance = account.getBalance() - amount;
                                account.getNormalTransactioneFee(amount);
                                double newBalance = balance - wdrLoansAccount.getNormalTransactioneFee(amount);
                                account.setBalance(newBalance);
                                wdrLoansAccount.log(account.getAccountNumber(), amount, account.getBalance(), account.getNormalTransactioneFee(amount));
                                // Tạo ID ngẫu nhiên
                                UUID uuid = UUID.randomUUID();
                                Transaction transaction = new Transaction(uuid.toString(), account.getAccountNumber(), amount, account.getDateTime());
                                account.addTransactions(transaction);
                                runAgain = true;
                            }


                        } else {
                            System.out.println("La TK LOANS, Khong the rut so tien vua nhap, so tien phai >=50K, <= 5000K, va la boi so cua 10K!!!!!!");
                            runAgain = true;
                        }
                    } else {
                        System.out.println("Số dư tài khoản không đủ (<50K), không thể thực hiện giao dịch!");
                        runAgain = true;
                    }
                }
                //System.out.println("check cách chạy method");
            }
        }


        if (runAgain == false) {
            System.out.println("Số tài khoản chưa tồn tại! Vui lòng chọn lại chức năng! ");
        }
    }


    // Method (Print Accounts) In ra danh sách gồm mã tài khoản và số dư, !!! Cứ ADD thêm dữ liệu, Method ở dưới sẽ chỉ in ra theo thứ tự dòng trên là thông tin
    public void displayInformation() {
        for (Account a1 : accounts) {
            System.out.println(a1);
        }
    }

}



