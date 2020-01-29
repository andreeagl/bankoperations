/**
 *
 **/
package bank;

public class RonBankAccount extends BankAccount {

    public RonBankAccount(String accountNumber, float amount) {
        super(accountNumber, amount);
    }

    public void add(float amount) {
        setAmount(getAmount() + amount);
    }

    public void remove(float amount){
        if(getAmount() < amount) {
            throw new RuntimeException("Not enough money!");
        }
        setAmount(getAmount() - amount);
    }

    @Override public float getSum() {
        return getAmount();
    }
}
