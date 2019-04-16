package studentPackage;

import java.io.Serializable;

public class Account implements Serializable
{
    private String accountNo;
    private double balance;

    public void withdraw(double amount)
    {
        if(amount>0 && amount<balance)
        {
            balance-=amount;
        }
    }

    public void deposit(double amount)
    {
        if(amount>0) balance+=amount;
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
