package com.sample;

import java.util.Scanner;

interface Banking
{
    public void deposit(Details d);
    public void withdrawal(Details d);
}
class ShowDetails
{

    public void showAccount(Details d) {
        System.out.println("Name of account holder: " + d.name);
        System.out.println("Account no.: " + d.accno);
        System.out.println("Account type: " + d.acc_type);
        System.out.println("Balance: " + d.balance);
    }
}
class BankDetails implements Banking {

    Scanner sc = new Scanner(System.in);
    //method to open new account
    public void openAccount(Details d) {
        System.out.print("Enter Account No: ");
        d.accno = sc.next();
        System.out.print("Enter Account type: ");
        d.acc_type = sc.next();
        System.out.print("Enter Name: ");
        d.name = sc.next();
        System.out.print("Enter Balance: ");
        d.balance = sc.nextLong();
        System.out.print("Generate ATM pin: ");
        d.pin= sc.nextInt();
    }
    //method to display account details
    public void showAccount(Details d) {
        ShowDetails sh=new ShowDetails();
        sh.showAccount(d);
    }

    //method to deposit money
    @Override
    public void deposit(Details d) {
        long amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextLong();
        d.balance = d.balance + amt;
    }
    //method to withdraw money
    @Override
    public void withdrawal(Details d) {
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();
        if (d.balance >= amt) {
            d.balance = d.balance - amt;
            System.out.println("Balance after withdrawal: " + d.balance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );
        }
    }
    //method to search an account number
    public boolean search(Details d , String ac_no) {
        if (d.accno.equals(ac_no)) {
            showAccount(d);
            return (true);
        }
        return (false);
    }
}
class ChangePin
{
    public void changePin(Details customerDetails)    //code to change ATM pin
    {
        Scanner scn=new Scanner(System.in);
        System.out.println("\n For verification please enter your current pin :  ");
        int currentPin=scn.nextInt();
        if(customerDetails.pin==currentPin)
        {
            System.out.println("\nEnter new pin: ");
            customerDetails.pin=scn.nextInt();
            System.out.println("\n Pin changed Successfully\n");
        }
        else
        {
            System.out.println("\n Wrong pin\n");
        }
    }
}
class ATM extends BankDetails implements Banking
{

    public void changePin(Details d)    //code to change ATM pin
    {
        ChangePin obj=new ChangePin();
        obj.changePin(d);
    }
}
class Details
{
    String accno;
    String name;
    String acc_type;
    long balance;
    int pin=0;
}
public class Bank {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        //create initial accounts
        System.out.println("How many number of customers do you want to input? ");
        int n = sc.nextInt();
        BankDetails C[] = new BankDetails[n];
        Details data[] = new Details[n];
        {
            int i = 0;
            while (i < C.length) {
                C[i] = new BankDetails();
                data[i]=new Details();
                C[i].openAccount(data[i]);
                i++;
            }
        }
        // loop runs until number 5 is not pressed to exit
        int ch;
        do {
            System.out.println("\n\n***Banking System Application***");
            System.out.println("1. Display all account details \n2. Search by Account number\n3. Deposit the amount \n4. Withdraw amount\n5. Use ATM\n6.Exit ");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    for (int i = 0; i < C.length; i++) {
                        C[i].showAccount(data[i]);
                    }
                    break;
                case 2:
                    System.out.print("Enter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(data[i],ac_no);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(data[i],ac_no);
                        if (found) {
                            C[i].deposit(data[i]);
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(data[i],ac_no);
                        if (found) {
                            C[i].withdrawal(data[i]);
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 5:
                    ATM atm = new ATM();
                    int ch1;
                    String a_no;
                    System.out.println("Enter your account number");
                    a_no=sc.next();
                    boolean foundd = false;
                    int i=0;
                    for (i = 0; i < C.length; i++) {
                        foundd = C[i].search(data[i],a_no);
                        if (foundd) {
                            break;
                        }
                    }
                    if(!foundd)
                    {
                        break;
                    }
                    do {

                        System.out.println("\n\n***ATM Application***");
                        System.out.println("1. Display details \n2. Withdraw Amount\n3. Change Pin \n4. Exit ");
                        System.out.println("Enter your choice: ");
                        ch1=sc.nextInt();
                        switch(ch1) {
                            case 1:
                                atm.showAccount(data[i]);
                                break;
                            case 2:
                                System.out.println("\nEnter your Pin: ");
                                int pin=sc.nextInt();
                                if(pin==data[i].pin)
                                {
                                    atm.withdrawal(data[i]);
                                }
                                else
                                {
                                    System.out.println("Unable to withdraw money, wrong credentials");
                                }
                                break;
                            case 3:
                                atm.changePin(data[i]);
                                break;
                            case 4:
                                System.out.println("Thank you for using ATM");

                        }
                    }while(ch1!=4);
                    break;


                case 6:
                    System.out.println("See you soon...");
                    break;
            }
        }
        while (ch !=6);
    }
}
