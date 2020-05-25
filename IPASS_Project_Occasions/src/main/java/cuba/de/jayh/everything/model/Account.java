package cuba.de.jayh.everything.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Account implements Serializable{
   private String username;
   private String fullname;
   private String address;
   private String avatarBase64;
   private String avatarUploadId;
   private String email;
   private String password;

   private ArrayList<Message> myMessages = new ArrayList<Message>();
   private static Account loggedInAccount = null;
   //admin heeft meer rechten
   private UserType accountType = null;

   public Account() {}

   public Account(String username, String fullname,String password,  String address, String avatarBase64,UserType type) {
      this.username = username;
      this.fullname = fullname;
      this.address = address;
      this.password = password;
      this.avatarBase64 = avatarBase64;
      accountType = type;

   }

   public String getUsername() { return username; }
   public String getFullname() { return fullname; }
   public String getAddress() { return address; }
   public String getAvatarBase64() { return avatarBase64; }
   public String getAvatarUploadId() { return avatarUploadId; }
   public UserType getAccountType() { return accountType; }
   public void setUsername(String username) { this.username = username; }
   public void setFullname(String fullname) { this.fullname = fullname; }
   public void setAddress(String address) { this.address = address; }
   public void setAvatarBase64(String avatarBase64) { this.avatarBase64 = avatarBase64; }
   public void setAvatarUploadId(String avatarUploadId) { this.avatarUploadId = avatarUploadId; }
   public void setType(UserType type) { accountType = type; }


   public ArrayList<Message> getMyMessages() {
      return myMessages;
   }
   public void addMessage(Message message) {
      myMessages.add(message);
   }


   public static Account getLoggedInAccount() {
      return loggedInAccount;
   }




   // bericht verstuurd door bezoeker zonder account naar alle admins
   public static void messageToAllAdmins(String topic, String question,String name,  String email) {
      for(Account acc: Company.getCompany().getAccounts()){
         if(acc.getAccountType() == UserType.SUPERUSER){
            new Message(topic, question,name, email);
         }
      }
   }


   public static void logInAs(Account account) {
      loggedInAccount = account;
   }


}






