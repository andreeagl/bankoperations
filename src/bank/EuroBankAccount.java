/**
 *
 **/
package bank;

public class EuroBankAccount extends BankAccount {

    public EuroBankAccount(String accountNumber, float amount) {
        super(accountNumber, amount);
    }

    public float getInterest() {
        float interest = 0;
            if(super.getAmount() > 500) {
                interest = super.getAmount()  * 0.01f;
            }
            return interest;
    }

    @Override public float getSum() {
        return getAmount() * 4.2f;
    }
}
