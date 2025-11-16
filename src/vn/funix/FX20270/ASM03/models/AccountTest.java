package vn.funix.FX20270.ASM03.models;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {


    @org.junit.jupiter.api.Test
    void isPremiumAccount() {
        Account account = new Account();
        //Check là tài khoản Premium true nếu tài khoản >10 triệu VND
        assertEquals(true,account.isPremiumAccount(11000000));
        //Check là tài khoản Normal false nếu tài khoản <10 triệu VND
        assertEquals(false,account.isPremiumAccount(9000000));
//        fail("This test has not been implemented");
    }

    @org.junit.jupiter.api.Test
    void setTransactioneFee() {
        Account account = new Account();
        // Check nếu tài khoản LOANS Premium 11 triệu VND: phí rút tiền sẽ là 0.01% = 50.000 VND khi rút 5 triệu
        assertEquals(50000,account.getPremiumTransactioneFee(5000000));
        // Check nếu tài khoản LOANS Nomarl 9 triệu VND, và rút 5 triệu, phí rút tiền sẽ là 0.05% = 250.000 VND
        assertEquals(250000,account.getNormalTransactioneFee(5000000));

//        fail("This test has not been implemented");

    }

}