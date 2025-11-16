package vn.funix.FX20270.ASM03.models;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DigitalBank extends Bank {

    public DigitalBank() {
    }

    @Override
    public String getCustomerByID(String customerID) {
        return  super.getCustomerByID(customerID);
    }

    @Override
    public void printInformation() {
        super.printInformation();
    }


    @Override
    public void addCustomers(Customer o) {
        super.addCustomers(o);
    }


    public void addSavingsAccount() {
        setAccounts();
        setAccountNumber();
        setBalance();
        SavingsAccount sa = new SavingsAccount(getAccountNumberGV(), getBalanceGV());
        for (Customer cs : getCustomers()) {
            cs.addAccounts(sa);
        }
    }

    public void addLoansAccount() {
        setAccounts();
        setAccountNumber();
        setBalanceLoans();
        LoansAccount la = new LoansAccount(getAccountNumberGV(), getBalanceGV());
        for (Customer cs : getCustomers()) {
            cs.addAccounts(la);
        }
    }


    double newBalance;
    public void withdraw() {

        boolean runAgain = false; // cần thiết khởi tạo biến false trước, nếu không thì runAgain = true ở block else sẽ ko có giá trị để tham chiếu
        do {
            // Vòng lặp check customerID gồm 12 chữ số
            Scanner sc = new Scanner(System.in);
            // Nhập customerID cần tra để thêm số tai khoản 6 chữ số
            System.out.println("Nhập số mã số (CCCD) của khách hàng cần rút tiền: ");
            String customerID = sc.nextLine();
            for (Customer customer : getCustomers()) {
                if (customerID.equals(customer.getCustomerID())) {
                    System.out.println("Đã tìm thấy KH trong danh sách, thỏa mãn điều kiện !!! ");
                    customer.withdraw();
                    runAgain = false; //  gan runAgain = true de khong chay tiep lech runAgain == false phia duoi
                }else {
                    System.out.println("Khach hang nay chua ton tai trong danh sach (CCCD)!! Vui long nhap lai Ma so khach hang (CCCD) de dien them thong tin!!! ");
                    runAgain = true; // true là cứ chạy tiếp vòng lặp do while(!!!)
                }
            }
        }while (runAgain);
    }
}
