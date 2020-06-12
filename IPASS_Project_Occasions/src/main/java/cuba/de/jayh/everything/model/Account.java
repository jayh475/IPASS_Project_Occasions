package cuba.de.jayh.everything.model;

import java.io.Serializable;
import java.security.Principal;
import java.util.*;

public class Account implements Serializable, Principal {
    private String username, password, role;


    private ArrayList<Message> myMessages = new ArrayList<Message>();
    private static Account loggedInAccount = null;
    private static List<Account> allAccounts = new ArrayList<>();

    public Account(){}


    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = "user";
        for (Account account : allAccounts) {
            if (account.equals(this)) {
                throw new IllegalArgumentException("Account bestaat al");
            }
        }
        allAccounts.add(this);
    }

    public String getRole() {
        return role;
    }

    public static List<Account> getAllAccounts() {
        return Collections.unmodifiableList(allAccounts);
    }

    public void addMessage(Message message) {
        myMessages.add(message);
    }

    @Override
    public String getName() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return username.equals(account.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    public static Account getAccountByname(String username) {
        return allAccounts.stream()
                .filter(e -> e.username.equals(username))
                .findFirst()
                .orElse(null);
    }

    public static String validateLogin(String uname, String pwd) {
        Account found = getAccountByname(uname);
        if (found != null) return pwd.equals(found.password) ? found.getRole() : null;
        return null;
    }
    public static void setAllAccounts(List<Account> loadedAccounts) {
        allAccounts.addAll(loadedAccounts);
    }


    public void setAdmin() {
        role = "admin";
    }


    public static Account getLoggedInAccount() {
        return loggedInAccount;
    }


    // bericht verstuurd door bezoeker zonder account naar alle admins
    public static void messageToAllAdmins(String topic, String question, String name, String email) {
        for (Account acc : allAccounts) {
            if (acc.getRole().equals("admin")) {
                new Message(topic, question, name, email);
            }
        }
    }


    public ArrayList<Message> getMyMessages() {
        return myMessages;
    }

    public static boolean deleteUser(Account user) {
        return allAccounts.remove(user);
    }


}






