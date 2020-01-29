package bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankOperations {

    public static void main(String[] args) {
        Bank bank = new Bank(1);
        RonBankAccount ronBankAccount = new RonBankAccount("ROINGB1111", 1000f);
        EuroBankAccount euroBankAccount = new EuroBankAccount("ROINGB2222", 600f);
        Client client = new Client("1880201340056", "John Smith", "Park Lane, 17", ronBankAccount);
        List<BankAccount> accountList = new ArrayList<>();
        client.setAccounts(Arrays.asList(euroBankAccount));

        RonBankAccount ronBankAccount2 = new RonBankAccount("ROINGB44444", 760f);
        EuroBankAccount euroBankAccount2 = new EuroBankAccount("ROINGB3333", 200f);
        Client client2 = new Client("2800204640056", "Jane Son", "Sunshine Blvd, 17", ronBankAccount2);
        client2.setAccounts(Arrays.asList(euroBankAccount2));

        RonBankAccount ronBankAccount3 = new RonBankAccount("ROINGB55555", 1290f);
        RonBankAccount ronBankAccount4 = new RonBankAccount("ROINGB66666", 200f);
        EuroBankAccount euroBankAccount3 = new EuroBankAccount("ROINGB77777", 3000f);
        Client client3 = new Client("2800204640056", "Jane Son", "Sunshine Blvd, 17", euroBankAccount3);
        client3.setAccounts(Arrays.asList(ronBankAccount3, ronBankAccount4));

        bank.addNewClient(client);
        bank.addNewClient(client2);
        bank.addNewClient(client3);

        bank.printClientDetails(client3);

        bank.transferMoney("ROINGB1111", "ROINGB55555", 50f);
       System.out.println("Interest is " +  bank.getInterest("ROINGB2222"));
    }
}
