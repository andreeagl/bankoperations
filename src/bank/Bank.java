package bank;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Client> clients;
    private int number;

    public Bank(int number) {
        this.number = number;
    }

    public void addNewClient(Client client) {
        if(this.clients != null){
            if(this.clients.contains(client)) {
                throw new RuntimeException("Client already exists!");
            }
            this.clients.add(client);
        } else {
            List<Client> clients = new ArrayList<>();
            clients.add(client);
            this.clients = clients;
        }

    }

    public void printClientDetails(Client client) {
        System.out.println(client.getCNP()  + ", " + client.getName()  + "," + client.getAddress());
        for (BankAccount account : client.getAccounts()) {
            if(account instanceof EuroBankAccount) {
                System.out.println(account.getAccountNumber()  + ": [EURO] "  + account.getSum() + " " +((EuroBankAccount) account).getInterest());
            } else {
                System.out.println(account.getAccountNumber()  + ": [RON] " + account.getSum());
            }

        }
    }

    public void transferMoney(String fromAccountNumber, String toAccountNumber, float sum) {
        BankAccount fromAccount = findBankAccount(fromAccountNumber);
        BankAccount toAccount = findBankAccount(toAccountNumber);
        if(fromAccount instanceof RonBankAccount && toAccount instanceof RonBankAccount) {
            ((RonBankAccount) fromAccount).remove(sum);
            ((RonBankAccount) toAccount).add(sum);
        } else {
            throw new RuntimeException("One Of the Accounts is not in RON");
        }
    }

    public float getInterest(String bankAccountNumber) {
        BankAccount account = findBankAccount(bankAccountNumber);
        if(account instanceof EuroBankAccount) {
           return ((EuroBankAccount) account).getInterest();
        }
        throw new RuntimeException("The Accpunt is not in EUR");
    }

    private BankAccount findBankAccount(String bankAccountNumber) {
        for (Client client : clients) {
            for (BankAccount account : client.getAccounts()) {
                if (bankAccountNumber.equals(account.getAccountNumber())) {
                    return account;
                }
            }
        }
        throw new RuntimeException("there is no account with that number");
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
