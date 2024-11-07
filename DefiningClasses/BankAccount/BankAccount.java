package JavaAdvanced.DefiningClasses.BankAccount;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;
    private int id;
    private double balance;

    //конструктор, който автоматично инкрементира id-то при всяко създаване
    public  BankAccount(){
        this.id = bankAccountCount++;
    }

    //сетер за interestRate
    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    //депозит / сетер за баланса
    public void deposit (double amount){
        this.balance += amount;
    }

    //геттер за interestRate
    public double getInterestRate(int years){
        return  this.interestRate * years * this.balance;
    }

    //геттер за ИД
    public int getId(){
        return this.id;
    }

}
