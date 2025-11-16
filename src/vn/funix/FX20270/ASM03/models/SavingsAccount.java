package vn.funix.FX20270.ASM03.models;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SavingsAccount extends Account implements ReportService, Withdraw { //Create Test: option+Enter
    DecimalFormat formatter = new DecimalFormat("###,###,###");

    private static final double SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;


    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public SavingsAccount() {
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
        if (newBalance >= 50000) {
            return true;
        }
        return false;
    }


    // In ra lịch sử giao dịch
    @Override
    public void log(String accountNumber,double amount, double balance, double transactionFee) {
        System.out.println(" +----------+--------------------------");
        System.out.printf("%30s%n", "BIÊN LAI GIAO DỊCH SAVINGS");
        System.out.printf("NGAY G/D: %28s%n", getDateTime());
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2024");
        System.out.printf("SO TK: %31s%n", accountNumber);
        System.out.printf("SO TIEN: %29s%n", formatter.format(amount) + " VND");
        System.out.printf("SO DU: %31s%n", formatter.format(balance) + " VND");
        System.out.printf("PHI + VAT: %27s%n", transactionFee + " VND");
    }

    public String getAccountType() {
        return "SAVINGS";
    }

    @Override
    public String toString() {
        return "Đã thêm số tài khoản " + getAccountNumber() + " =>" + getAccountType() + " |" + formatter.format(getBalance()) + " VND";
    }

}


/*
Chuỗi format theo cấu trúc sau:

1
"% [argument index] [flag] [width] [.precision] type"
% là một ký tự đặc biệt biểu thị rằng một hướng dẫn định dạng sau.
[argument index] : xác định chỉ số của các đối số để được định dạng. Nếu không xác định cụ thể, các đối số sẽ được định dạng theo thứ tự như chúng xuất hiện trong danh sách đối số.
[flag] là một hướng dẫn định dạng đặc biệt. Ví dụ, cờ + xác định rằng một giá trị số phải luôn luôn được định dạng với một ký hiệu, và cờ 0 chỉ định rằng 0 là ký tự đệm. Các cờ khác bao gồm – đó là pad ở bên phải, + pad ở bên trái (nếu đối tượng được định dạng là một chuỗi). Lưu ý rằng một số cờ không thể được kết hợp với một số cờ khác hoặc với các đối tượng được định dạng nhất định.
[width] xác định số lượng tối thiểu các ký tự output cho đối tượng đó.
[.precession] xác định chính xác của các số dấu chấm động trong output. Đó là cơ bản số chữ số thập phân bạn muốn in trên đầu ra. Nhưng nó có thể được sử dụng cho các loại khác để cắt giảm chiều rộng đầu ra
type : type và % là các tham số định dạng bắt buộc duy nhất. type là kiểu đối tượng sẽ được định dạng trong đầu ra. Đối với các số nguyên d, cho các chuỗi đó là s, cho các số dấu phẩy là f, cho các số nguyên có định dạng hex là x.
Ví dụ:

public class StringFormat {
    public static void main(String[] args) {
        System.out.printf("Integer : %d\n", 15);
        System.out.printf("Floating point number with 3 decimal digits: %.3f \n", 1.21312939123);
        System.out.printf("Floating point number with 8 decimal digits: %.8f \n", 1.21312939123);
        System.out.printf("String: %s, integer: %d, float: %.6f \n", "Hello World", 89, 9.231435);
        System.out.printf("Re-order output %4$2s %1$2s %3$2s %2$2s \n", "a", "b", "c", "d");
    }
}
Kết quả:

Integer : 15
Floating point number with 3 decimal digits: 1.213
Floating point number with 8 decimal digits: 1.21312939
String: Hello World, integer: 89, float: 9.231435
Re-order output  d  a  c  b
 */
