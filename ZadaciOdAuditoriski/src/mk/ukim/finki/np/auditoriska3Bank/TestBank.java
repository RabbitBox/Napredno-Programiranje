package mk.ukim.finki.np.auditoriska3Bank;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

interface InterestBearingAccount {
    /**increases the interest rate for this type of account */
    void addInterest();
}

class PlatinumCheckingAccount extends InterestCheckingAccount implements InterestBearingAccount {
    public PlatinumCheckingAccount(String ownerName, int accountNumber, Double currentAmount) {
        super(ownerName, accountNumber, currentAmount);
    }

    @Override
    public void addInterest() {
        this.currentAmount += this.currentAmount * (INTEREST_RATE * 2);
    }
}

class NonInterestCheckingAccount extends Account{
    public NonInterestCheckingAccount(String ownerName, int accountNumber, Double currentAmount) {
        super(ownerName, accountNumber, currentAmount);
    }
}

class InterestCheckingAccount extends Account implements InterestBearingAccount {
    public static final double INTEREST_RATE = .03;

    public InterestCheckingAccount(String ownerName, int accountNumber, Double currentAmount) {
        super(ownerName, accountNumber, currentAmount);
    }

    @Override
    public void addInterest() {
        this.currentAmount += this.currentAmount * INTEREST_RATE;
    }
}


abstract class Account {

    private String ownerName;
    private int accountNumber;
    protected Double currentAmount;

    public Account(String ownerName, int accountNumber, Double currentAmount) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.currentAmount = currentAmount;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public void addAmount(Double amount){
        this.currentAmount += amount;
    }

    public void withdrawAmount(Double amount){
        this.currentAmount -= amount;
    }

}


class Bank {

    private Account [] accouts;
    private int totalAccounts;
    private int max;

    public Bank(int max) {
        this.totalAccounts = 0;
        this.max = max;
        accouts = new Account[max];
    }

    /** add a new account to the array of accounts[] */
    public void addAccount(Account account){
        if(this.accouts.length == totalAccounts){
            System.out.println("You cannot add new account!");
            return;
        }
        this.accouts[totalAccounts++] = account;
    }

    /** returns the sum of all accounts */
    public double totalAssets() {
        if (totalAccounts != max){
            System.out.println("You didn't add correct number of accounts");
            return 0.0;
        }
        return Arrays.stream(accouts).map(i->i.getCurrentAmount()).reduce(0.0,((i, j) -> i + j));

        /** double result = 0.0;
         for(Account a : accouts){       // POINT TO REMEMBER: when we loop array with foreach, the method will loop through all( even the empty ones) the elements  cz the memory is already reserved!!
         if(a == null)
         break;
         result += a.getCurrentAmount();
         }
         return result; */
    }

    /** invokes the method addInterest() of all accounts subject to interest */
    public void addInterest(){
        Arrays.stream(accouts).filter(i -> (i instanceof InterestBearingAccount)).forEach(i -> ((InterestBearingAccount) i).addInterest());

        /** for (Account a : accouts){
         if(a instanceof InterestBearingAccount){
         InterestBearingAccount bearingAccount = (InterestBearingAccount) a;
         bearingAccount.addInterest();
         }
         } */
    }
}

public class TestBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of accounts you want to add:");
        Bank bank = new Bank(sc.nextInt());
        bank.addAccount(new InterestCheckingAccount("Aleksandar", 123123, 10000.0));
        bank.addAccount(new NonInterestCheckingAccount("Furniture", 123123, 10000.0));
        bank.addAccount(new InterestCheckingAccount("Hogwort", 123123, 10000.0));
        bank.addAccount(new NonInterestCheckingAccount("Joran", 123123, 10000.0));
        bank.addAccount(new PlatinumCheckingAccount("Joran", 123123, 10000.0));
        System.out.println(bank.totalAssets());
        bank.addInterest();
        System.out.println(bank.totalAssets());

    }
}
