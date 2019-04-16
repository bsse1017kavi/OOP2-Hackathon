package studentPackage;

public class Account
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
}
