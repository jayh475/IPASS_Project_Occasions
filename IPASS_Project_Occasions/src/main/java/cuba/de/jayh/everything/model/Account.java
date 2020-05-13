package cuba.de.jayh.everything.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Account {
   private String email;
   private String password;
   private int accountId;

   //deze velden zijn niet verplicht.
   private String firstname;
   private String surname;
   private String birthday;

   private static ArrayList<Account> allAccounts = new ArrayList<Account>();
   private ArrayList<Message> myMessages = new ArrayList<Message>();
   private static Account loggedInAccount = null;
   private static int ammountAccounts = 0; // zorgt voor account ID verhoging

   //admin heeft meer rechten
   public enum Type {
      normalUser,
      superUser
   }

   private Type accountType = null;



   //must have
   public Account(String em, String pw,Type type) {
      this.email = em;
      this.password = pw;
      this.accountId = ammountAccounts;
      allAccounts.add(this);
      accountType = type;
      ammountAccounts++;

   }

   // niet noodzakelijk, maar zorgt voor een betere klantrelatie later in het proces
   public Account(String em, String pw, String nm, String surn, String birthday, Type type) {
      this.email = em;
      this.password = pw;
      this.accountId = ammountAccounts;
      this.firstname = nm;
      this.surname = surn;
      this.birthday = birthday;
      allAccounts.add(this);
      accountType = type;
      ammountAccounts++;


   }


   // functies

   public Type getAccountType() {
      return accountType;
   }

   public static ArrayList<Account> getAll() {
      return allAccounts;
   }

   public String[] getAccountInfo() {
      return new String[]{email, password};
   }

   public static Account tryLogin(String email, String password) throws Exception {
      for (Account acc : allAccounts) {
         if (Arrays.equals(acc.getAccountInfo(), new String[]{email, password})) {
            return acc;
         }
      }
      throw new Exception("Wrong login details");
   }


   public static Account getLoggedInAccount(){
      return loggedInAccount;
   }

   public static void logoff() {
      loggedInAccount = null;
   }

   public static void loggedInAs(Account account) {
      loggedInAccount = account;
   }

   public int getAccountId() {
      return accountId;
   }

   public static boolean loginStatus() {
      return (loggedInAccount != null);
   }


   public void addMessage(Message message) {
      myMessages.add(message);
   }

   public ArrayList<Message> giveMyMessages() {
      return myMessages;
   }

   // bericht verstuurd door bezoeker zonder account naar alle admins
   public static void messageToAllAdmins(String tp, String qn, String nm, String em) {
      for (Account acc : getAll()) {
         if (acc.getAccountType() == Type.superUser) {
            new Message(tp, qn, nm, em);
         }
      }
   }


      public void setType (Type type){
         accountType = type;
      }
   }







