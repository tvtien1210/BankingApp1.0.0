package vn.funix.FX20270.ASM02.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Customer extends User {
    // Ke thua NAME, customerID va cong them List<Account>

    private List<Account> accounts = new ArrayList<Account>();


    public Customer() {

    }

    public Customer(String customerID) {
        super(customerID);
    }

    public Customer(String name, String customerID) {
        super(name, customerID);
    }

    public Customer(String name, String customerID, List<Account> accounts) {
        super(name, customerID);
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccounts(Account o) {
        this.accounts.add(o);
    }

    // Phương thức cho biết khách hàng có phải là premium hay không, 1 khách hàng là premium nếu có ít nhất 1 tài khoản (Account) là premium(tận dụng account.isPremiumAccount )
    public String isPremiumAccount() {
        for (Account account : accounts) {
            if (account.isPremiumAccount()) {
                return "Premium";
            }
        }
        return "Normal";
    }


    // !!! IMPORTAIN: method geBlance này cần có tham số truyền vào là một ArrayList, nếu không có tham số list truyền vào, sẽ không xác định được List muốn tính tổng!!!
    public double getBalance() {
        double sum = 0;
        for (Account o : accounts) {
            sum += o.getBalance();
        }
        return sum;
    }

    //In ra danh sách gồm mã tài khoản và số dư, !!! Cứ ADD thêm dữ liệu, Method ở dưới sẽ chỉ in ra theo thứ tự dòng trên là thông tin, dòng dưới là danh sách tài khoản và số dư
    public void displayInformation() {
        for (Account a1 : accounts) {
            System.out.println(a1);
        }
    }

    // List ở Class nào, xào luôn Method ở class đó (cụ thể trường hợp này, Customer có khởi tạo <List> accounts,
// vì vậy nên tạo luôn Method printAccounts luôn trong class hiện tại, class Customer)
    public void printAccounts() {
        for (Account o : accounts) {
            System.out.println(o);
        }
    }


}



