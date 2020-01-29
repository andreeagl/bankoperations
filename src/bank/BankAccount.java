package bank; /**
 *
 **/

public abstract class BankAccount implements TotalSum {

    private String accountNumber;

    private float amount;

    public BankAccount(String accountNumber, float amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

}
