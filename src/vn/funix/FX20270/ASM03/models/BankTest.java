package vn.funix.FX20270.ASM03.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {


    @org.junit.jupiter.api.Test
    void isAccountNumberExist() {
        Bank bank = new Bank();
        // Test có tồn tại AccountNumber 111111
        assertEquals(true, bank.isAccountNumberExist(String.valueOf(111111)));
        // Test không tồn tại AccountNumber 111111
        assertEquals(false, bank.isAccountNumberExist(String.valueOf(123456)));
//        fail("This test has not been implemented");

    }

    @org.junit.jupiter.api.Test
    void getCustomerByID() {
        String a = "121212121212";
        Bank bank = new Bank();
        // Check lấy tên khách hàng bằng ID 121212121212
        assertEquals("121212121212", bank.getCustomerByID(a));
//        fail("This test has not been implemented");

    }
    
}