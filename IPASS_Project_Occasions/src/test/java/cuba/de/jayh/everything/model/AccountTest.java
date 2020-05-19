package cuba.de.jayh.everything.model;

import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account a1,a2,a3,a4;


    @BeforeEach
    public void init(){
        a1 = new Account("jayh.decuba@gmail.com","123", UserType.SUPERUSER);
        a2 = new Account("kees.jan@gmail.com","234",UserType.NORMALUSER);
        a3 = new Account("beer.dejong@gmail.com","345",UserType.NORMALUSER);

    }



    @Test
    void getAccountType() {
        Assert.assertEquals("SUPERUSER",a1.getAccountType().toString());
        Assert.assertEquals("NORMALUSER", a2.getAccountType().toString());

    }

    @Test
    void getAllAccounts() {



    }

    @Test
    void getAccountInfo() {
//        Assert.assertEquals(,a1.getAccountInfo());
        System.out.println(a1.getAccountInfo());

    }

    @Test
    void tryLogin() {

    }

    @Test
    void getLoggedInAccount() {
    }

    @Test
    void logoff() {
    }

    @Test
    void loggedInAs() {
    }

    @Test
    void getAccountId() {
    }

    @Test
    void loginStatus() {
    }

    @Test
    void addMessage() {
    }

    @Test
    void giveMyMessages() {
    }

    @Test
    void messageToAllAdmins() {
    }

    @Test
    void setType() {
    }
}
