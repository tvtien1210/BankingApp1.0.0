package vn.funix.FX20270.ASM01;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ASM01 {
    // Kiểm tra chuỗi số bảo mật hợp lệ
    public static int maBaoMat1() {
        // Code 100-999 => range of random.nextInt(range) = max-min+1 = 999-100+1= 900
        Random random = new Random();
        int code = random.nextInt(900) + 100; // (0.100-0.999)*1000
        return code;
    }

    public static String maBaoMat2() {
        // Code abcAbc123
        String s = "abcdefghijklmnopqrstxyzABCDEFJHIJKLMNOPQRSTUVWXYZ1234567890";
        // StringBuilder là xây dựng chuỗi từ các phần tử charAt riêng lẻ
        StringBuilder sBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(s.length());
            // append: nối vào
            sBuilder.append(s.charAt(index));
        }
        System.out.println(sBuilder);
        // toString: convert sang chuỗi
        return sBuilder.toString();

    }

    static int a; //biến toàn cục
    static String b; //bien toan cuc

    public static int chonMaBaoMat(int choose) {
        if (choose == 1) {
            a = maBaoMat1();
        } else if (choose == 2) {
            b = maBaoMat2();
        }
        return choose;
    }

    // Kiểm tra nơi sinh
    public static String chucNang1(String inputMaTinh) {
        HashMap<String, String> kiemTraNoiSinh = new HashMap<>();

        kiemTraNoiSinh.put("001", "Hà Nội");
        kiemTraNoiSinh.put("002", "Hà Giang");
        kiemTraNoiSinh.put("004", "Cao Bằng");
        kiemTraNoiSinh.put("006", "Bắc Cạn");
        kiemTraNoiSinh.put("008", "Tuyên Quang");
        kiemTraNoiSinh.put("010", "Lào Cai");
        kiemTraNoiSinh.put("011", "Điện Biên");
        kiemTraNoiSinh.put("012", "Lai Châu");
        kiemTraNoiSinh.put("014", "Sơn La");
        kiemTraNoiSinh.put("015", "Yên Bái");
        kiemTraNoiSinh.put("017", "Hoà Bình");
        kiemTraNoiSinh.put("019", "Thái Nguyên");
        kiemTraNoiSinh.put("020", "Lạng Sơn");
        kiemTraNoiSinh.put("022", "Quảng Ninh");
        kiemTraNoiSinh.put("024", "Bắc Giang");
        kiemTraNoiSinh.put("025", "Phú Thọ");
        kiemTraNoiSinh.put("026", "Vĩnh Phúc");
        kiemTraNoiSinh.put("027", "Bắc Ninh");
        kiemTraNoiSinh.put("030", "Hải Dương");
        kiemTraNoiSinh.put("031", "Hải Phòng");
        kiemTraNoiSinh.put("033", "Hưng Yên");
        kiemTraNoiSinh.put("034", "Thái Bình");
        kiemTraNoiSinh.put("035", "Hà Nam");
        kiemTraNoiSinh.put("036", "Nam Định");
        kiemTraNoiSinh.put("037", "Ninh Bình");
        kiemTraNoiSinh.put("038", "Thanh Hoá");
        kiemTraNoiSinh.put("040", "Nghệ An");
        kiemTraNoiSinh.put("042", "Hà Tĩnh");
        kiemTraNoiSinh.put("044", "Quảng Bình");
        kiemTraNoiSinh.put("045", "Quảng Trị");
        kiemTraNoiSinh.put("046", "Thừa Thiên Huế");
        kiemTraNoiSinh.put("048", "Đà Nẵng");
        kiemTraNoiSinh.put("049", "Quảng Nam");
        kiemTraNoiSinh.put("051", "Quảng Ngãi");
        kiemTraNoiSinh.put("052", "Bình Định");
        kiemTraNoiSinh.put("054", "Phú Yên");
        kiemTraNoiSinh.put("056", "Khánh Hoà");
        kiemTraNoiSinh.put("058", "Ninh Thuận");
        kiemTraNoiSinh.put("060", "Bình Thuận");
        kiemTraNoiSinh.put("062", "Kon Tum");
        kiemTraNoiSinh.put("064", "Gia Lai");
        kiemTraNoiSinh.put("066", "Đắk Lắk");
        kiemTraNoiSinh.put("067", "Đắk Nông");
        kiemTraNoiSinh.put("068", "Lâm Đồng");
        kiemTraNoiSinh.put("070", "Bình Phước");
        kiemTraNoiSinh.put("072", "Tây Ninh");
        kiemTraNoiSinh.put("074", "Bình Dương");
        kiemTraNoiSinh.put("075", "Đồng Nai");
        kiemTraNoiSinh.put("077", "Bà Rịa - Vũng Tàu");
        kiemTraNoiSinh.put("079", "Hồ Chí Minh");
        kiemTraNoiSinh.put("080", "Long An");
        kiemTraNoiSinh.put("082", "Tiền Giang");
        kiemTraNoiSinh.put("083", "Bến Tre");
        kiemTraNoiSinh.put("084", "Trà Vinh");
        kiemTraNoiSinh.put("086", "Vĩnh Long");
        kiemTraNoiSinh.put("087", "Đồng Tháp");
        kiemTraNoiSinh.put("089", "An Giang");
        kiemTraNoiSinh.put("091", "Kiên Giang");
        kiemTraNoiSinh.put("092", "Cần Thơ");
        kiemTraNoiSinh.put("093", "Hậu Giang");
        kiemTraNoiSinh.put("094", "Sóc Trăng");
        kiemTraNoiSinh.put("095", "Bạc Liêu");
        kiemTraNoiSinh.put("096", "Cà Mau");

        // containsKey : từ khoá liên quan
        if (kiemTraNoiSinh.containsKey(inputMaTinh)) {
            System.out.println(inputMaTinh + ": " + kiemTraNoiSinh.get(inputMaTinh));
        }

        return inputMaTinh;
    }

    // Kiểm tra năm sinh, giới tính
    public static void chucNang2() {
        System.out.println(cccd);
        String maGioiTinh = cccd.substring(3, 4);
        String namSinh2socuoi = cccd.substring(4, 6);
        switch (maGioiTinh) {
            case "0":
                System.out.println("Giới : Nam | " + "Năm sinh: 19" + namSinh2socuoi);
                break;
            case "1":
                System.out.println("Giới tính: Nữ | " + "Năm sinh: 19" + namSinh2socuoi);
                break;
            case "2":
                System.out.println("Giới tính: Nam | " + "Năm sinh: 20" + namSinh2socuoi);
                break;
            case "3":
                System.out.println("Giới tính: Nữ | " + "Năm sinh: 20" + namSinh2socuoi);
                break;
            case "4":
                System.out.println("Giới tính: Nam | " + "Năm sinh: 21" + namSinh2socuoi);
                break;
            case "5":
                System.out.println("Giới tính: Nữ | " + "Năm sinh: 21" + namSinh2socuoi);
                break;
            case "6":
                System.out.println("Giới tính: Nam | " + "Năm sinh: 22" + namSinh2socuoi);
                break;
            case "7":
                System.out.println("Giới tính: Nữ | " + "Năm sinh: 22" + namSinh2socuoi);
                break;
            case "8":
                System.out.println("Giới tính: Nam | " + "Năm sinh: 23" + namSinh2socuoi);
                break;
            case "9":
                System.out.println("Giới tính: Nữ | " + "Năm sinh: 23" + namSinh2socuoi);
                break;
        }

    }

    // Kiểm tra số ngẫu nhiên
    public static void chucNang3() {
        String soNgauNhien = cccd.substring(6);
        System.out.println("Mã số ngẫu nhiên trong căn cước công dân là: " + soNgauNhien);
    }

    // Thoát
    public static void chucNang4() {
        System.out.println("Đã thoát chương trình!!!");
        System.exit(0);
    }

    // Hàm hiển thị menu chương trình
    public static void menu() {
        boolean runAgain = false;
        //----------LAP LAI MENU NGAN HANG SO----------
        do {
            System.out.println("+------------------+------------+---------+");
            System.out.println("| NGAN HANG SO | FX20270@v1.0.0           |");
            System.out.println("+------------------+------------+---------+");
            System.out.println("| 1. Nhập CCCD");
            System.out.println("| 0. Thoát");
            System.out.println("+------------------+------------+---------+");

            Scanner sc = new Scanner(System.in);
            int nhapChucNangMenu;
            int nhapMaBaoMat3So;   // biến toàn cục
            String nhapMaBaoMat6KyTu;   // biến toàn cục


            System.out.print("Nhập chức năng: ");
            // Ham try catch duoc viet trong block do while
            try {
                nhapChucNangMenu = sc.nextInt();
                if (nhapChucNangMenu == 1) {
                    runAgain=false; // 📣📣📣Chú ý đổi sang runAgain = false ở block if(nhapChucNangMenu), để runAgain trở về
                    // giá trị false khi đi qua block else()
                    boolean runAgain2 = false; // vòng lặp do while xử lý khi nhập
                    //----------Lap lai CHON MA BAO MAT ----------
                    do {
                        System.out.println("Chọn mã bảo mật EASY (Bam phim 1) ");
                        System.out.println("Chọn mã bảo mật HARD (Bam phim 2) ");
                        try {
                            sc.nextLine(); // !!!Dòng này rất rất quan trọng, ngăn hệ thống tự động Enter
                            // (vòng lặp rất dễ chạy vô hạn gây tốn tài nguyên _ lag máy)
                            int choose = sc.nextInt();
                            chonMaBaoMat(choose);
                            // Vòng lặp do while dùng để lặp ít nhất 1 lần rồi mới xét đến thoả mãn điều kiện trong ngoặc while
                            // Trường hợp này sẽ lặp ít nhất 1 lần(nếu nhapMaBaoMat khác a(giá trị a cố định trong do_while), lặp tiếp từ đầu vòng do_while
                            // cho đến khi nào nhapMaBaoMat bằng a vòng lặp ko quay lại từ đầu nữa
                            // or cho đến khi nào như code mình mong muốn như trong câu if() ở dưới)
                            if (choose == 1) {
                                do {
                                    System.out.println("Nhập mã bảo mật: " + a);
                                    try {
                                        sc.nextLine(); // dòng này ngăn cho Enter nhập tự động vào lệnh lặp của vong ngoài do while, tránh gây lặp vô tận
                                        nhapMaBaoMat3So = sc.nextInt();
                                        if (nhapMaBaoMat3So == a) {
                                            inputCCCD();
                                            runAgain2=false;// 📣📣📣Chú ý đổi sang runAgain2 = false ở block if(nhapMaBaoMat3So),
                                            // để runAgain trở về giá trị false khi đi qua block else()

                                        } else {
                                            System.out.println("Mã bảo mật không đúng! Vui lòng nhập lại mã bảo mật!!!");
                                        }
                                    } catch (InputMismatchException ex) {
                                        System.out.println("Nhập lại mã bảo mật bằng giá trị số ( không phải giá trị chuỗi)");
                                        nhapMaBaoMat3So = 0; //Gán mã số bảo mật = 0 or số bất kỳ có 1 chữ số, để cố tình tạo giá trị khác a ( a có 3 chữ số), để lặp lại do while
                                    }
                                } while (nhapMaBaoMat3So != a);
                            } else if (choose == 2) {
                                do {
                                    System.out.println("Nhập mã bảo mật: " + b);
                                    nhapMaBaoMat6KyTu = sc.next();
                                    sc.nextLine();
                                    if (nhapMaBaoMat6KyTu.equals(b)) {
                                        inputCCCD();
                                        runAgain2=false;// 📣📣📣Chú ý đổi sang runAgain2 = false ở block if(nhapMaBaoMat6KyTu.equal(b)),
                                        // để runAgain trở về giá trị false khi đi qua block else()

                                    } else {
                                        System.out.println("Mã bảo mật không đúng! Vui lòng nhập lại mã bảo mật!!!");
                                    }
                                } while (!nhapMaBaoMat6KyTu.equals(b));
                            } else {
                                System.out.println("Vui lòng chọn lại chế độ bảo mật! Nhấn phím 1 hoặc phím 2");
                                runAgain2 = true;
                            }

                        } catch (InputMismatchException ime) {
                            System.out.println("‼️‼️‼️Yêu cầu nhập dữ liệu bằng số!");
                        }
                    } while (runAgain2);

                } else if (nhapChucNangMenu == 0) {
                    System.out.println("Đã thoát chương trình!");
                    System.exit(nhapChucNangMenu); // Exit nhapChucNangMenu de ket thuc chuong trinh
                } else {
                    System.out.println("🚨🚨🚨Nhập sai chức năng! Xin vui lòng nhập lại!📣📣📣");
                    runAgain = true;
                }

            } catch (InputMismatchException ime) {
                System.out.println("‼️‼️‼️‼️Yêu cầu nhập dữ liệu bằng số!");
            }
        } while (runAgain);

    }


    // Kiểm tra chuỗi CCCD hợp lệ
    public static boolean isCCCD(String CCCD) {
        String digit = "\\d{12}";
        // một biểu thức chính quy (regular expression) reg_ex \\d
        CCCD.matches(digit);
        return CCCD.matches(digit); // \d la so int = (tu 0 den 9), dấu + để xét match với sự lặp lại của ký tự nhập vào
    }

    // Hàm nhập vào CCCD
    static String cccd;

    public static void inputCCCD() {
        boolean runAgain3 = false; // cần thiết khởi tạo biến false trước, nếu không runAgain = true ở block else sẽ ko có giá trị để tham chiếu
        do {
            System.out.println("Nhập vào CCCD:");
            Scanner sc = new Scanner(System.in);
            String cccdNumber = sc.nextLine(); // nextLine: mot chuoi lien mach, khong co dau cach Space
            if (isCCCD(cccdNumber)) {
                cccd = cccdNumber;
                runAgain3=false;
            } else {
                System.out.println("Số CCCD không hợp lệ");
                System.out.println("Vui lòng nhập lại CCCD");
                runAgain3 = true; // true là cứ chạy tiếp vòng lặp do while(!!!)
            }

        } while (runAgain3); // runAgain = false : là kết thúc vòng lặp do while


    }


    // Hàm hiển thị thông tin tỉnh
    // Hàm hiển thị thông tin giới tính, năm sinh
    // Hàm main() điều khiển luồng chính của chương trình.
    public static void main(String[] args) {
        // Sử dụng Scanner để đọc dữ liệu từ bàn phím.
        Scanner sc = new Scanner(System.in);
        int chucNang;
        menu();
        do {
            System.out.println("---------------------------------");
            System.out.println("1| Kiểm tra nơi sinh");
            System.out.println("2| Kiểm tra năm sinh, giới tính");
            System.out.println("3| Kiểm tra số ngẫu nhiên");
            System.out.println("4| Thoát");
            System.out.print("Chọn chức năng: ");
            chucNang = sc.nextInt();

            switch (chucNang) {

                case 1:
                    String xetMaTinh = cccd.substring(0, 3); // Tách 3 số đầu, vứt số thứ 4 (tính từ index = 0)
                    System.out.println("Mã tỉnh là: " + xetMaTinh);
                    chucNang1(xetMaTinh);
                    break;
                case 2:
//                    chucNang2(
//                    "cccdNumber.subString(3,4): gioi tinh, // Tách số thứ 4 (tính từ index = 0)
//                    cccdNumber.subString(4,6): nam sinh" // Tách số 4,5 , vứt số thứ 7 (tính từ index = 0)
//                    );
                    chucNang2();
                    break;
                case 3:
//                    chucNang3("cccdNumber.subString(6): ma ngau nhien"); // Tách từ số thứ 7 đến hết chuỗi
                    chucNang3();
                    break;
                case 4:
                    chucNang4(); //EXIT
                    break;

            }
        } while (chucNang != 0);


    }

    // Sử dụng Scanner để đọc dữ liệu từ bàn phím.
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Chức năng: ");
//        int functionNumber = sc.nextInt();
//
//        if (functionNumber == 1) {
//            System.out.print("Nhập mã xác thực: ");
//            maNgauNhien2();
//            int nhapMaSoNgauNhien = sc.nextInt();
//
//
//        } else if (functionNumber == 0) {
//
//        } else {
//            System.out.println("Hãy nhập lại phím số chức năng 1 hoặc 0");
//        }
//    }


    // Chương trình sẽ cho phép người dùng nhập CCCD và truy xuất được thông tin.
    // Chia tách hàm hợp lý, không để tất cả code vào chung hàm main.


}














/*
// ---VI DU VE TRY CATCH
* class Example2{
   public static void main(String args[]){
     try{
         int a[]=new int[7];
         a[4]=30/0;
         System.out.println("Câu lệnh in đầu tiên trong try block");
     }
     catch(ArithmeticException e){
        System.out.println("Cảnh báo: ngoại lệ ArithmeticException");
     }
     catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Cảnh báo: ngoại lệ ArrayIndexOutOfBoundsException");
     }
     catch(Exception e){
        System.out.println("Cảnh báo: ngoại lệ khác");
     }
   System.out.println("Ra khỏi try-catch block...");
  }
}
Output:
1
2

Cảnh báo: ngoại lệ ArithmeticException
Ra khỏi try-catch block...
Trong ví dụ trên có nhiều catch block và các catch block này thực hiện tuần tự khi có exception xảy ra trong try block.
Điều đó có nghĩa là nếu bạn đặt catch block cuối cùng catch(Exception e) ở vị trí đầu tiên,
ngay sau try block thì trong trường hợp có bất kỳ exception nào, khối này sẽ thực thi vì nó
có thể xử lý tất cả các exception. Catch block này nên được đặt ở cuối cùng để tránh những tình huống như vậy.

-----BIEN STATIC
Từ khóa static trong java: - Từ khóa static được sử dụng để quản lý bộ nhớ tốt hơn và nó có thể được truy cập trực tiếp thông qua lớp mà không cần khởi tạo.

----SecureCode
// Java program to demonstrate working
// of java.lang.Math.random() method
import java.lang.Math;

class Gfg2 {
	// driver code
	public static void main(String args[])
	{
		// define the range
		int max = 10;
		int min = 1;
		int range = max - min + 1;

		// generate random numbers within 1 to 10
		for (int i = 0; i < 10; i++) {
			int rand = (int)(Math.random() * range) + min;

		// Output is different everytime this code is executed
			System.out.println(rand);
		}
	}
}


    System.out.println(
                " 1. Kiem tra noi sinh"
        );
        System.out.println(
                " 2. Kiem tra nam sinh, gioi tinh"
        );
        System.out.println(
                " 3. Kiem tra so ngau nhien"
        );
        System.out.println(
                " 0. Thoat"
        );





        Substring trong java
Một phần của chuỗi được gọi là chuỗi con(substring). Nói cách khác, chuỗi con là một tập hợp con của một chuỗi khác.

Có 2 phương thức để lấy chuỗi con từ một chuỗi đã cho:

public String substring(int startIndex): Phương thức này trả về đối tượng chuỗi mới là chuỗi con của chuỗi đã cho tính từ startIndex đã nhập đến cuối cùng.
public String substring(int startIndex, int endIndex): Phương thức này trả về đối tượng chuỗi mới là chuỗi con của chuỗi đã cho tính startIndex đến endIndex đã nhập.
Chú ý: Chỉ số(index) được tính từ 0.
Xem ví dụ sau để hiểu về startIndex và endIndex

Ví dụ 1:


String s="hello";
System.out.println(s.substring(0,2)); //he
Output:
he

Ví dụ 2:

public class TestSubstring2 {
 public static void main(String args[]) {
  String s = "Hello I'm Java";
  System.out.println(s.substring(5));   //I'm Java
  System.out.println(s.substring(0, 5));//Hello
 }
}
Output:

 I'm Java
Hello







Ví dụ: Số căn cước công dân là: 037153000257 thì:

037 là mã tỉnh Ninh Bình

1 thể hiện giới tính Nữ, sinh tại thế kỷ 20

53 thể hiện công dân sinh năm 1953

000257 là dãy số ngẫu nhiên


* */



