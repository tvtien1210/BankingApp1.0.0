package vn.funix.FX20270.ASM03;

import vn.funix.FX20270.ASM03.models.*;

import javax.swing.plaf.IconUIResource;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ASM03 {
    private static final Scanner sc = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_ID = "121212121212";
    private static final String CUSTOMER_NAME = "TRAN VAN TIEN";

    private static void showCustomer() {
        activeBank.getCustomerByID(CUSTOMER_ID);
        if (activeBank.getCustomers() != null) {
            activeBank.printInformation();
        }
    }

    public static void main(String[] args) {
        // Sử dụng Scanner để đọc dữ liệu từ bàn phím.
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
                case 1: //1.Xem thông tin khách hàng
                    activeBank.setNameAndNumberID(CUSTOMER_NAME, CUSTOMER_ID);
                    // Xem thông tin khách hàng tìm theo mã số CCCD là CUSTOMER_ID đã cài đặt mặc định
                    showCustomer();
                    break;
                case 2: // 2.Thêm tài khoản ATM
                    activeBank.addSavingsAccount();
                    break;
                case 3: // 3.Thêm tài khoản tín dụng
                    activeBank.addLoansAccount();
                    break;
                case 4: // 4.Rút tiền
                    activeBank.withdraw();
                    break;
                case 5: // 5.Tra cứu lịch sử giao dịch
                    activeBank.printInformation();
            }
        }
        while (chucNang != 0);
    }


    public static void showMenu() {
        System.out.println(
                " +----------+--------------------------+ \n" +
                        " | NGÂN HÀNG ĐIỆN TỬ | FX20270@v3.0.0 \n" +
                        " +----------+--------------------------+ \n" +
                        " 1.Xem thông tin khách hàng \n" +
                        " 2.Thêm tài khoản ATM \n" +
                        " 3.Thêm tài khoản tín dụng \n" +
                        " 4.Rút tiền \n" +
                        " 5.Tra cứu lịch sử giao dịch \n" +
                        " 0.Thoat \n" +
                        " +----------+--------------------------+ \n"
        );

    }
}
