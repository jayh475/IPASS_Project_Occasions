package cuba.de.jayh.everything.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;


public class Account implements Serializable {
   private String email;
   private String password;
   private int accountId;

   //admin heeft meer rechten
   private UserType accountType = null;

   //deze velden zijn niet verplicht.
   private String firstname;
   private String surname;
   private String birthday;

   private static ArrayList<Account> allAccounts = new ArrayList<Account>();
   private ArrayList<Message> myMessages = new ArrayList<Message>();
   private static Account loggedInAccount = null;
   private static int ammountAccounts = 0; // zorgt voor account ID verhoging


   //must have
   public Account(String email, String password, UserType type) {
      this.email = email;
      this.password = password;
      this.accountId = ammountAccounts;
      allAccounts.add(this);
      accountType = type;
      ammountAccounts++;

   }

   // niet noodzakelijk, maar zorgt voor een betere klantrelatie later in het proces
   public Account(String email, String password, String firstname, String surname, String birthday, UserType type) {
      this.email = email;
      this.password = password;
      this.accountId = ammountAccounts;
      this.firstname = firstname;
      this.surname = surname;
      this.birthday = birthday;
      allAccounts.add(this);
      accountType = type;
      ammountAccounts++;


   }


   //getters account
   public UserType getAccountType() {
      return accountType;
   }

   public static ArrayList<Account> getAllAccounts() {
      return allAccounts;
   }

   public String[] getAccountInfo() {
      return new String[]{email, password};
   }

   public static Account getLoggedInAccount() {
      return loggedInAccount;
   }

   public int getAccountId() {
      return accountId;
   }

   //setters account
   public void setType(UserType type) {
      accountType = type;
   }


   //functions account
   public static Account tryLogin(String email, String password) throws Exception {
      for (Account acc : allAccounts) {
         if (Arrays.equals(acc.getAccountInfo(), new String[]{email, password})) {
            return acc;
         }
      }
      throw new Exception("Wrong login details");
   }

   public static void logoff() {
      loggedInAccount = null;
   }

   public static void logInAs(Account account) {
      loggedInAccount = account;
   }

   public static boolean loginStatus() {
      return (loggedInAccount != null);
   }


   // functions messages
   public void addMessage(Message message) {
      myMessages.add(message);
   }

   public ArrayList<Message> getMyMessages() {
      return myMessages;
   }

   // bericht verstuurd door bezoeker zonder account naar alle admins
   public static void messageToAllAdmins(String tp, String qn, String nm, String em) {
      for (Account acc : getAllAccounts()) {
         if (acc.getAccountType() == UserType.SUPERUSER) {
            new Message(tp, qn, nm, em);
         }
      }
   }


}







