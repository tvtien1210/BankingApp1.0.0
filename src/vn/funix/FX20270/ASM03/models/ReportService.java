package vn.funix.FX20270.ASM03.models;

public interface ReportService {

    // Không cần tạo field Public, Xử lý nghiệp vụ báo cáo
    void log(String accountNumber, double amount, double balance, double transactionFee);
}
