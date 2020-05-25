package cuba.de.jayh.everything.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Company {

    private static Company company = new Company();

    private Map<String, Account> accountsByName = new HashMap<>();
    // omzetting van de maps naar arraylist
    //keys
    ArrayList<String> namen = new ArrayList<String>(accountsByName.keySet());
    //values
    ArrayList<Account> accounts = new ArrayList<Account>(accountsByName.values());

    public ArrayList<Account> getAccounts(){ return accounts;}


    public static Company getCompany() {
        return company;
    }


    public Account getAccount(String username) {
        return accountsByName.get(username);
    }

    public boolean addAccount(Account newAccount) {
        if (newAccount.getUsername().isEmpty() || accountsByName.containsKey(newAccount.getUsername())) {
            return false;
        } else {
            accountsByName.put(newAccount.getUsername(), newAccount);
            return true;
        }
    }
}

