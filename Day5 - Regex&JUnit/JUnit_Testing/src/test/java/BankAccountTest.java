import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BankAccountTest {

    BankAccount account = new BankAccount();

    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }

    @Test
    void testDepositIncreaseBalance() {
        account.deposit(100);
        assertEquals(100, account.getBalance());

    }

    @Test
    void testDepositDecreaseBalance() {
        account.deposit(200);
        account.withdraw(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testWithdrawWithInsufficientFundsThrowsException() {
        account.deposit(50.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100.0));
    }

    @Test
    void testInitialBalanceIsZero() {
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void testWithdrawNegativeAmountThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10.0));
    }

    @Test
    void testDepositNegativeAmountDoesNotChangeBalance() {
        account.deposit(-50.0);
        assertEquals(0.0, account.getBalance());
    }
}
