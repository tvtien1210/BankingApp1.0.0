package vn.funix.FX20270.ASM03.models;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    @org.junit.jupiter.api.Test
    void withdraw() {
        SavingsAccount savingsAccount = new SavingsAccount();
        //Check số tiền cần rút true >= 50.000 VND
        assertEquals(true,savingsAccount.withdraw(50000));
        //Check số tiền cần rút true <=5 triệu VND
        assertEquals(true,savingsAccount.withdraw(5000000));
        //Check số tiền cần rút không hợp lệ false < 50.000 VND
        assertEquals(false,savingsAccount.withdraw(40000));
        //Check số tiền cần rút không hợp lệ false > 5 triệu VND
        assertEquals(false,savingsAccount.withdraw(6000000));
        //Check số tiền rút không hợp lệ false, vì không là bội của 10.000
        assertEquals(false,savingsAccount.withdraw(51000));


//        fail("This test has not been implemented");
    }

    @org.junit.jupiter.api.Test
    void isAccepted() {
        SavingsAccount savingsAccount = new SavingsAccount();
        //Check trước số dư còn lại hợp lệ (true) >=50.000 VND sau khi rút số tiền mong muốn
        assertEquals(true,savingsAccount.isAccepted(50000));
        //Check trước số dư còn lại không hợp lệ (false) <50.000 VND sau khi rút số tiền mong muốn
        assertEquals(false,savingsAccount.isAccepted(40000));

//        fail("This test has not been implemented");

    }
}