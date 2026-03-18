package OOPS;
import java.util.*;
class AtmDetails
{
    int limit = 0;
    Scanner sc = new Scanner(System.in);
    //data hiding; 
    private String accountHolderName;
    private double balance;
    private int pin;
    private double dailyWithdrawalLimit;
    private double withdrawnToday;

    //constructor to set everything;
    public AtmDetails(String accountHolderName,double balance,int pin)
    {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.pin = pin;
    }

    //authentication;
    public void authentication()
    {
        int password;
        do
        {
            System.out.println("enter the password of your atm");
            password = sc.nextInt();
            if (password == pin) 
            {
                continue;
            }else
            {
                System.out.println("enter the password again :   \n");
            }
        }while(password != pin);
    }

    //withdrawal;
    public void withdraw()
    {
        double dailyWithdrawalLimit = 40000;
        double withdrawalAmount;
        do
        {
            System.out.println("enter the amount you want to withdraw ");
            withdrawalAmount = sc.nextDouble();
            if (withdrawalAmount > balance && withdrawalAmount > dailyWithdrawalLimit ) 
            {
                break;
            }
        }while(withdrawalAmount > balance || withdrawalAmount > dailyWithdrawalLimit);
        withdrawnToday = withdrawalAmount;
        balance -=withdrawalAmount;
        limit++;
    }


    //deposite money;
    public void depositMoney()
    {
        
        double depositMoney;
        do
        {
            System.out.println("enter the amount you want to deposite ");
            depositMoney = sc.nextDouble();
            if (depositMoney < 0) 
            {
                System.out.println("deposite money cannot be negative");
            }else
            {
                balance +=depositMoney;
            }
        }while(depositMoney < 0);
        
    }
    //display all details;
    public void display()
    {
        System.out.printf("%-22s : %s\n", "Account Holder", accountHolderName);
        System.out.printf("%-22s : %.2f\n", "Balance Available", balance);
        System.out.printf("%-22s : %.2f\n", "Withdrawn Today", withdrawnToday);

    }

    //reset daily limit;
    public void reset()
    {
        limit--;
    }

}
public class ATM 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in); 

        System.out.println("enter the accountholdername  : ");
        String accountHolderName = sc.nextLine();

        System.out.println("enter the balance  :  ");
        double balance = sc.nextDouble();

        System.out.println("set the pin of your atm  : ");
        int pin = sc.nextInt();

        AtmDetails ad = new AtmDetails(accountHolderName, balance, pin);
        
        ad.authentication();
        ad.withdraw();
        ad.display();
    }
}
