package vn.funix.FX20270.ASM02;

import vn.funix.FX20270.ASM02.models.Account;
import vn.funix.FX20270.ASM02.models.Bank;
import vn.funix.FX20270.ASM02.models.Customer;
import vn.funix.FX20270.ASM02.models.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ASM02 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        // Sử dụng Scanner để đọc dữ liệu từ bàn phím.
        Scanner sc = new Scanner(System.in);
        int chucNang = 0;
        do {
            showMenu();
            System.out.print("Chọn chức năng: ");
            try {
                chucNang = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Vui lòng nhập lại chức năng bằng số!!!");
            }
            sc.nextLine();
            switch (chucNang) {
                case 1:
                    // Nhap vao Ten va Ma so khach hang can them
                    bank.setNameAndNumberID();
                    bank.printCustomers();
                    break;
                case 2:
                    // Thêm tài khoản 6 số và số dư cho tài khoản
                    bank.setAccounts();
                    break;
                case 3:
                    // Hiển thị danh sách khách hàng
                    bank.printInformation();
                    break;
                case 4:
                    // Tìm theo CCCD (customerID)
                    boolean runAgain = false; // cần thiết khởi tạo biến false trước, nếu không thì runAgain = true ở block else sẽ ko có giá trị để tham chiếu
                    do {
                        System.out.println("Nhập vào CCCD muốn tìm kiếm: ");
                        String customerID = sc.nextLine();
                        String digit = "\\d{12}";
                        if (customerID.matches(digit)) {
                            bank.findByCutomerID(customerID);
                            runAgain = false; // không chạy lại
                        } else {
                            System.out.println("Số CCCD không hợp lệ");
                            System.out.println("Vui lòng nhập lại CCCD 12 chữ số hoặc nhập '0' để thoát: ");
                            runAgain = true; // true là cứ chạy tiếp vòng lặp do while(!!!)
                        }
                    } while (runAgain);
                    break;
                case 5:
                    // Thêm Khách hàng
                    System.out.println("Nhap vao Ten nguoi dung: ");
                    String name = sc.nextLine();
                    // Tìm theo tên khách hàng
                    bank.findByName(name);
                    break;
            }
        }
        while (chucNang != 0);
    }

    public static void showMenu() {
        System.out.println(
                " +----------+--------------------------+ \n" +
                        " | NGAN HANG SO | FX20270@v2.0.0 \n" +
                        " +----------+--------------------------+ \n" +
                        " 1.Them ten khach hang \n" +
                        " 2.Them tai khoan cho khach hang \n" +
                        " 3.Hien thi danh sach khach hang \n" +
                        " 4.Tim theo CCCD \n" +
                        " 5.Tim theo ten khach hang \n" +
                        " 0.Thoat \n" +
                        " +----------+--------------------------+ \n"
        );

    }
}
