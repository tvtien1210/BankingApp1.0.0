package vn.funix.FX20270.ASM02.models;

import java.util.Objects;
import java.util.Scanner;

public class User {
    // interface implement (Comparable) https://codelearn.io/sharing/cau-hoi-thuong-gap-khi-lam-quen-voi-oop
    private String name;
    private String customerID;

    public User() {
    }

    public User(String customerID) {
        this.customerID = customerID;
    }

    public User(String name, String customerID) {
        this.name = name;
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public String getCustomerID() {
        return customerID;
    }

    // Thêm mới tên khách hàng
    public void setName(String name) {
        this.name = name;
    }

    // Thêm mới mã số khách hàng (CCCD)

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    // To String in ra dinh dang User, (ke ca Customer lop con cua User), chi can goi user or (customer qua foreach)
    @Override
    public String toString() {
        return "Đã thêm khách hàng name = " + name + ", và customerID =  " + customerID;
    }


    //Method equals này giúp thực thi Method isCustomerExisted băm từng thuộc thính name or customerID ra riêng biệt
    //để thực hiện phương thức arrayList.contains
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return Objects.equals(customerID, user1.customerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, customerID);
    }
}


