package vn.funix.FX20270.ASM03.models;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Bank {
    // final ngan khong cho ke thua, chua ma dinh danh ngau nhien cua NH, duoc khoi tao trong constructor
    String ID;

    // add class ArrayList Customer de them xoa nguoi dung (CCCD)
    private List<Customer> customers = new ArrayList<Customer>();

    public Bank() {

    }

    //Constructor này List customers chưa có khai báo new ArrayList, nên sẽ cần Constructor không tham số bên trên
    public Bank(List<Customer> customers) {
        this.customers = customers;
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
        return this.customers.contains(customerID);
    }

    // Them customer theo (name + customerID)
    public void addCustomers(Customer o) {
        this.customers.add(o);
    }


    public void setNameAndNumberID(String name, String customerID) {
        while (true) {
//            System.out.println("Nhập vào CCCD:");
            String digit = "\\d{12}";
            if (customerID.matches(digit)) {
                // Cấu trúc customer trước khi add vào ArrayList theo tên lớp Customer
                Customer c = new Customer(name, customerID);
                // Thêm customer có name và customerID vào List Customer
                addCustomers(c);
                break;
            }
            System.out.println("Số CCCD không hợp lệ");
            System.out.println("Vui lòng nhập lại CCCD 12 chữ số hoặc nhập '0' để thoát: ");
        }
    }

    // Method nhập giá trị từ bàn phím accountNumber thỏa mãn điều kiện đủ 6 số(Định dạng acccount Number)
    String accountNumberGV; //Global Variable

    public String getAccountNumberGV() {
        return accountNumberGV;
    }

    public double getBalanceGV() {
        return balanceGV;
    }


    public void setAccountNumber() {
        boolean runAgain; // cần thiết khởi tạo biến false trước, nếu không thì runAgain = true ở block else sẽ ko có giá trị để tham chiếu
        do {
            Scanner sc = new Scanner(System.in);
            // Nhập customerID cần tra để thêm số tai khoản 6 chữ số
            System.out.println("Nhập số tài khoản mới bao gồm 6 chữ số: ");
            // Vòng lặp check accountNumber thỏa mãn 6 chữ số
            String inputAccountNumber = sc.nextLine();
            //System.out.println(!isAccountNumberExist(inputAccountNumber));
            // 6 chu so, một biểu thức chính quy (regular expression) reg_ex \\d
            String digit = "\\d{6}";  // \\d la so int = (tu 0 den 9), dấu + để xét match với sự lặp lại của ký tự nhập vào
            if (!isAccountNumberExist(inputAccountNumber)) {
                System.out.println("(Mã số này là duy nhất, chưa tồn tại nên có thể thêm 👍)!!!");
                if (inputAccountNumber.matches(digit)) {
                    System.out.println("Mã số hợp lệ (Bao gồm 6 chữ số!!!)");
                    accountNumberGV = inputAccountNumber;
                    runAgain = false;
                } else {
                    System.out.println("Nhưng mã số này không đủ 6 số, xin vui lòng nhập lại hoặc nhập '0' để thoát!!!");
                    runAgain = true;
                }
            } else {
                System.out.println("Số Account Number đã tồn tại!!!");
                System.out.println("Vui lòng nhập lại hoặc nhập '0' để thoát!!!");
                runAgain = true;
            }
        } while (runAgain);

    }


    // Kiểm tra sự tồn tại của AccountNumber (6 số trùng nhau ?? => loại)
    public boolean isAccountNumberExist(String accountNumber) {
        for (Customer customer : customers) {
            for (int i = 0; i < customer.getAccounts().size(); i++) {
                if (accountNumber.equals(customer.getAccounts().get(i).getAccountNumber())) {
                    return true;
                }
            }
        }
        return false;
    }


    // Method nhập giá trị từ bàn phím balance không được nhỏ hơn 50.000 Đ (Định dạng balance)
    double balanceGV;

    public void setBalance() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập số dư:  ");
            double inputBalance = 0;
            try {
                inputBalance = sc.nextDouble();
            } catch (InputMismatchException ime) {
                System.out.println("Vui lòng nhập lại số dư bằng số!!!");
            }
//            double inputBalance = sc.nextDouble();
            int a = 50000;
            if (inputBalance > a) {
                balanceGV = inputBalance;
                break;
            }
            System.out.println("Số dư không được nhỏ hơn 50.000VND, vui lòng nhập lại số dư: ");
        }

    }

    public void setBalanceLoans() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập số dư:  ");
            double inputBalance = sc.nextDouble();
            int a = 50000;
            int b = 100000000;
            if (inputBalance > a && inputBalance < b) {
                balanceGV = inputBalance;
                break;
            }
            System.out.println("Số dư không được nhỏ hơn 50.000VND, và không lớn hơn 100 triệu VND vui lòng nhập lại số dư: ");
        }

    }

    //     Method cài đặt customerID 12 chữ số
    public void setAccounts() {
        boolean runAgain = false; // cần thiết khởi tạo biến false trước, nếu không thì runAgain = true ở block else sẽ ko có giá trị để tham chiếu
        do {
            // Vòng lặp check customerID gồm 12 chữ số
            Scanner sc = new Scanner(System.in);
            // Nhập customerID cần tra để thêm số tai khoản 6 chữ số
            System.out.println("Nhập số mã số (CCCD) của khách hàng cần thêm thông tin: ");
            String customerID = sc.nextLine();
            for (Customer customer : customers) {
                if (customerID.equals(customer.getCustomerID())) {
                    System.out.println("Đã tìm thấy KH trong danh sách, thỏa mãn điều kiện !!! ");
                    runAgain = false; //  gan runAgain = true de khong chay tiep lech runAgain == false phia duoi
                } else {
                    System.out.println("Khach hang nay chua ton tai trong danh sach (CCCD)!! Vui long nhap lai Ma so khach hang (CCCD) de dien them thong tin!!! ");
                    runAgain = true; // true là cứ chạy tiếp vòng lặp do while(!!!)
                }
            }
        } while (runAgain);

    }


    // Tìm theo CCCD
    public String getCustomerByID(String customerID) {
        boolean runAgain = false;
        for (Customer customer : customers) {
            if (customer.getCustomerID().equals(customerID)) { // equal: tim chinh xac
                runAgain = true;
                break; // khi tim thay mot ket qua se dung lai ngay
            }
        }
        if (runAgain == false) {
            System.out.println("Không tìm thấy thông tin khách hàng! Vui long nhap lai chuc nang!");
        }
        return customerID;
    }

    //Tim theo name (Tim gan dung)
    public void getCustomerbyName(String name) {
        boolean runAgain = false;
        System.out.println("Kết quả tìm kiếm: ");
        for (Customer customer : customers) {
            if (customer.getName().indexOf(name) >= 0) { // indexOf()>=0 giong voi method contain(); tìm gần đúng
                System.out.println(customer);
                runAgain = true;
                // ko co break, vi muon tim tat ca khach hang co ten gan dung
            }
        }
        if (runAgain == false) {
            System.out.println("Khong tim thay thong tin khach hang! Vui long nhap lai chuc nang!");
        }
    }

    public void getCustomerByAccountNumber(String accountNumber) {
        boolean runAgain = false;
        System.out.println("Kết quả tìm kiếm: ");
        for (Customer customer : customers) {
            if (customer.getAccounts().contains(accountNumber)) { // indexOf()>=0 giong voi method contain(); tìm gần đúng
                System.out.println(customer);
                customer.withdraw();
                runAgain = true;
                // ko co break, vi muon tim tat ca khach hang co ten gan dung
            }
        }
        if (runAgain == false) {
            System.out.println("Khong tim thay thong tin khach hang! Vui long nhap lai chuc nang!");
        }
    }


    // In ra tất cả thông tin danh sách khách hàng đã nhập ra màn hình,
// chính là "dòng dưới" : danh sách tài khoản và số dư
    public void printInformation() {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        for (Customer o : customers) {
            System.out.println("Mã khách hàng = " + o.getCustomerID() + " Tên khách hàng = " + o.getName() + " Level = " + o.printPremiumAccount() + " Tổng số dư = " + formatter.format(o.getBalance()) + "VND");
            o.displayInformation(); // hiển thị cho account
            System.out.println("");
            System.out.println("Account" + "|" + "Amount" + "|" + "Time" + "|" + "Transaction ID");
            for (Account account : o.getAccounts()) {
                for (Transaction transaction : account.getAccountTransactions()) {
                    System.out.printf("[GD]   %-20s | %-20s VND| %-20s| %-20s\n" , transaction.getAccountNumber(),formatter.format(transaction.getAmount()),transaction.getTime(),transaction.getTransactionID());

                }
            }
            System.out.println("");
            System.out.println("");
        }
    }


}


