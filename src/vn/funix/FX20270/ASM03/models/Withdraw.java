package vn.funix.FX20270.ASM03.models;

public interface Withdraw {
    // Khong can field không, xu ly nghiep vu rut tien cho Saving
    boolean withdraw(double amount); // phuong thuc xac nhan rut tien, xu ly nghiep vu rut tien cho Saving
    boolean isAccepted(double amount); // xac dinh xem co thoa man dieu kien rut tien hay khong
}
