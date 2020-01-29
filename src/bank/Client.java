package bank; /**
 *
 **/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    private String CNP;
    private String name;
    private String address;
    private List<BankAccount> accounts;

    public Client(String CNP, String name, String address, BankAccount account) {
        this.setCNP(CNP);
        this.name = name;
        this.address = address;
        List<BankAccount> accountList = new ArrayList<>();
        accountList.add(account);
        this.accounts = accountList;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        if(CNP.length() == 13 && (CNP.startsWith("1") || CNP.startsWith("1"))) {
            final DateFormat dateFormat = new SimpleDateFormat("yyMMdd");
            String birthDate = CNP.substring(1,7);
            try {
                dateFormat.parse(birthDate);
                this.CNP = CNP;
            } catch (ParseException pe) {
                throw new RuntimeException("CNP is not valid");
            }

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        if(this.accounts.size() + accounts.size() < 6) {
            this.accounts.addAll(accounts);
        }
    }
}
