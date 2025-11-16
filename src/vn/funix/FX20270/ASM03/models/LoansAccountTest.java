package vn.funix.FX20270.ASM03.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoansAccountTest {

    @Test
    void withdraw() {
        LoansAccount loansAccount = new LoansAccount();
        //Check số tiền cần rút true >= 50.000 VND
        assertEquals(true, loansAccount.withdraw(50000));
        //Check số tiền cần rút true <=5 triệu VND
        assertEquals(true, loansAccount.withdraw(5000000));
        //Check số tiền cần rút không hợp lệ false < 50.000 VND
        assertEquals(false, loansAccount.withdraw(40000));
        //Check số tiền cần rút không hợp lệ false > 5 triệu VND
        assertEquals(false, loansAccount.withdraw(6000000));
        //Check số tiền rút không hợp lệ false, vì không là bội của 10.000
        assertEquals(false, loansAccount.withdraw(51000));


//        fail("This test has not been implemented");
    }

    @org.junit.jupiter.api.Test
    void isAccepted() {
        LoansAccount loansAccount = new LoansAccount();
        //Check trước số dư còn lại hợp lệ (true) >=50.000 VND sau khi rút số tiền mong muốn
        assertEquals(true, loansAccount.isAccepted(50000));
        //Check trước số dư còn lại không hợp lệ (false) <50.000 VND sau khi rút số tiền mong muốn
        assertEquals(false, loansAccount.isAccepted(40000));

//        fail("This test has not been implemented");

    }
}