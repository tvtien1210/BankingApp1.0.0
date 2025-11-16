package vn.funix.FX20270.ASM02.models;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    // final ngan khong cho ke thua, chua ma dinh danh ngau nhien cua NH, duoc khoi tao trong constructor
    private String ID;

    // add class ArrayList Customer de them xoa nguoi dung (CCCD)
    private List<Customer> customers = new ArrayList<Customer>();
    // Constructor cho customerList

    //Constructor này List customers chưa có khai báo new ArrayList, nên sẽ cần Constructor không tham số bên trên
    public Bank(List<Customer> customers) {
        this.customers = customers;
    }

    public Bank() {

    }

    public String getID() {
        return ID;
    }

    public List<Customer> getCustomers() {
        return customers;
    }


    public void setID(String ID) {
        this.ID = ID;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }


    // Kiem tra ton tai CCCD customerID
    public boolean isCustomerExisted(Customer customerID) {
        return this.customers.contains(customerID); //Method này chạy được là nhờ có "method equals" trong User
    }


    // Them customer theo name+ID
    public void addCustomers(Customer o) {
        this.customers.add(o);
    }


    // Thêm tên và mã số khách hàng theo giá trị nhập từ bàn phím

    public void setNameAndNumberID() {
        Scanner sc = new Scanner(System.in);
        // Thêm Khách hàng
        boolean runAgain = false; // cần thiết khởi tạo biến false trước, nếu không thì runAgain = true ở block else sẽ ko có giá trị để tham chiếu
        System.out.println("Nhap vao Ten nguoi dung: ");
        String name = sc.nextLine();
        do {
            System.out.println("Nhập vào CCCD:");
            String customerID = sc.nextLine();
            String digit = "\\d{12}";
            if (customerID.matches(digit)) {
                // Cấu trúc customer trước khi add vào ArrayList theo tên lớp Customer
                Customer c = new Customer(name, customerID);
                // Thêm customer có name và customerID vào List Customer
                addCustomers(c);
                runAgain = false; // không chạy lại
            } else {
                System.out.println("Số CCCD không hợp lệ");
                System.out.println("Vui lòng nhập lại CCCD 12 chữ số hoặc nhập '0' để thoát: ");
                runAgain = true; // true là cứ chạy tiếp vòng lặp do while(!!!)
            }
        } while (runAgain);

        // In ra danh sách khách hàng trong customerList
        // (Muốn in ra customer theo toString trong class User, cần get được list customers trong class Bank theo foreach Customer)

    }


    // Method nhập giá trị từ bàn phím accountNumber thỏa mãn điều kiện đủ 6 số(Định dạng acccount Number)
    String accountNumber;

    public void setAccountNumber() {
        boolean runAgain1 = false;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập số tài khoản mới bao gồm 6 chữ số: ");
            // Vòng lặp check accountNumber thỏa mãn 6 chữ số
            String inputAccountNumber = sc.nextLine();
            // 6 chu so, một biểu thức chính quy (regular expression) reg_ex \\d
            String digit = "\\d{6}";
            // \\d la so int = (tu 0 den 9), dấu + để xét match với sự lặp lại của ký tự nhập vào
            if (inputAccountNumber.matches(digit)) {
                accountNumber = inputAccountNumber;
                runAgain1 = false;
            } else {
                System.out.println("Số Account Number không hợp lệ");
                System.out.println("Vui lòng nhập lại Account Number hoặc nhập '0' để thoát: ");
                runAgain1 = true; // true là cứ chạy tiếp vòng lặp do while(!!!)
            }
        } while (runAgain1); // runAgain = false : là kết thúc vòng lặp do while
    }


    // Method nhập giá trị từ bàn phím balance không được nhỏ hơn 50.000 Đ (Định dạng balance)
    double balance;

    public void setBalance() {
        boolean runagain2 = false;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập số dư:  ");
            double inputBalance = sc.nextDouble();
            int a = 50000;
            if (inputBalance < a) {
                System.out.println("Số dư không được nhỏ hơn 50.000VND, vui lòng nhập lại số dư: ");
                runagain2 = true;
            } else {
                balance = inputBalance;

                runagain2 = false;
            }
        } while (runagain2); //rungain = false sẽ kết thúc vòng lặp;

    }

    // Method cài đặt customerID 12 chữ số
    public void setAccounts() {
        boolean runAgain = false; // cần thiết khởi tạo biến false trước, nếu không thì runAgain = true ở block else sẽ ko có giá trị để tham chiếu
        // Vòng lặp check customerID gồm 12 chữ số
        Scanner sc = new Scanner(System.in);
        // Nhập customerID cần tra để thêm số tai khoản 6 chữ số
        System.out.println("Nhập số mã số (CCCD) của khách hàng cần thêm thông tin: ");
        String customerID = sc.nextLine();
        for (Customer customer : customers) {
            if (customerID.equals(customer.getCustomerID())) {
                System.out.println("Đã tìm thấy KH trong danh sách, thỏa mãn điều kiện !!! ");
                setAccountNumber();
                setBalance();
                Account account = new Account(accountNumber, balance);
                // Add luôn number và balance vào list customer vừa tìm thấy
                customer.getAccounts().add(account);
                runAgain = true; //  gan runAgain = true de khong chay tiep lech runAgain == false phia duoi
                break; // Dung lai ngay sau khi tim duoc mot ket qua
            }
        }
        if (runAgain == false) {
            System.out.println("Khach hang nay chua ton tai trong danh sach (CCCD)!! Vui long nhap lai Chuc nang va Ma so khach hang (CCCD) de dien them thong tin!!! ");
            runAgain = true; // true là cứ chạy tiếp vòng lặp do while(!!!)
        }
    }


    // Tìm theo CCCD
    public void findByCutomerID(String customerID) {
        boolean runAgain = false;
        System.out.println("Kết quả tìm kiếm: ");
        for (Customer customer : customers) {
            if (customer.getCustomerID().equals(customerID)) {
                System.out.println(customer);
                runAgain = true;
                break; // khi tim thay mot ket qua se dung lai ngay
            }
        }
        if (runAgain == false) {
            System.out.println("Không tìm thấy thông tin khách hàng! Vui long nhap lai chuc nang!");
        }
    }

    //Tim theo name (Tim gan dung)
    public void findByName(String name) {
        boolean runAgain = false;
        System.out.println("Kết quả tìm kiếm: ");
        for (Customer customer : customers) {
            if (customer.getName().indexOf(name) >= 0) { // indexOf()>=0 giong voi method contain;
                System.out.println(customer);
                runAgain = true;
                // ko co break, vi muon tim tat ca khach hang co ten gan dung
            }
        }
        if (runAgain == false) {
            System.out.println("Khong tim thay thong tin khach hang! Vui long nhap lai chuc nang!");
        }
    }


    // In danh sách khách hàng gồm tên và mã số
    public void printCustomers() {
        for (Customer o : customers) {
            System.out.println(o);
        }
    }

    // In ra tất cả thông tin danh sách khách hàng đã nhập ra màn hình
    public void printInformation() {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        for (Customer o : customers) {
            System.out.println("Mã khách hàng = " + o.getCustomerID() + " Tên khách hàng = " + o.getName() + " Level = " + o.isPremiumAccount() + " Tổng số dư = " + formatter.format(o.getBalance())+"VND");
            o.displayInformation();
        }
    }


}


