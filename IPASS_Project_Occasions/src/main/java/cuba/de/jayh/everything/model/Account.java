package cuba.de.jayh.everything.model;

import java.io.Serializable;
import java.security.Principal;
import java.util.*;

public class Account implements Serializable, Principal {
   private String username,email, password,role;



   private ArrayList<Message> myMessages = new ArrayList<Message>();
   private static Account loggedInAccount = null;
   private static List<Account> allAccounts = new ArrayList<>();





   public Account() {}

   public Account(String username,String password) {
      this.username = username;
      this.password = password;
      this.role ="user";
      if(!allAccounts.contains(this)) allAccounts.add(this);

   }



   public String getUsername() { return username; }
   public String getRole() { return role; }
   public void setAdmin(){ role= "admin"; }

   public void addMessage(Message message) {
      myMessages.add(message);
   }
   public static Account getLoggedInAccount() {
      return loggedInAccount;
   }




   // bericht verstuurd door bezoeker zonder account naar alle admins
   public static void messageToAllAdmins(String topic, String question,String name,  String email) {
      for(Account acc: allAccounts){
         if(acc.getRole().equals( "admin")){
            new Message(topic, question,name, email);
         }
      }
   }


   public ArrayList<Message> getMyMessages() {
      return myMessages;
   }




   @Override
   public String getName() {
      return username;
   }

   public static Account getAccountByname(String name){
      return allAccounts.stream()
              .filter(e->e.username.equals(name) )
              .findFirst()
              .orElse(null);
   }

   public static String validateLogin(String uname, String pwd){
      Account found = getAccountByname(uname) ;
      if(found!=null) return pwd.equals(found.password) ? found.getRole(): null;
      return null;
   }

}






