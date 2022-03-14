package com.Driver;

import com.Banking.*;

import java.util.Scanner;


//Driver Code

public class DriverClass {
    public static void main(String arg[]) {
        Scanner scannerObject = new Scanner(System.in);
        //create initial accounts
        System.out.println("How many number of customers do you want to input? ");
        int numberOfUser = scannerObject.nextInt();
        BankFunctions userClass[] = new BankFunctions[numberOfUser];
        Details dataClass[] = new Details[numberOfUser];
        inputUserData(userClass, dataClass);
        int choice;
        do {
            new ShowMenu();
            choice = scannerObject.nextInt();
            switch (choice) {
                case 1:
                    showAllUser(userClass, dataClass);
                    break;
                case 2:
                    searchUser(scannerObject, userClass, dataClass);
                    break;
                case 3:
                    DepositMoney(scannerObject, userClass, dataClass);
                    break;
                case 4:
                    withdrawMoney(scannerObject, userClass, dataClass);
                    break;
                case 5:
                    useATM(scannerObject, userClass, dataClass);
                    break;
                case 6:
                    System.out.println("See you soon...");
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
        while (choice != 6);
    }

    private static void inputUserData(BankFunctions[] C, Details[] data) {
        int userNumber = 0;
        while (userNumber < C.length) {
            userNumber = getUser(C, data, userNumber);
        }
    }

    private static void useATM(Scanner sc, BankFunctions[] C, Details[] data) {
        ATM atm = new ATM(new Withdraw(), new Printing(), new PinManagement());
        int ch1;
        String a_no;
        System.out.println("Enter your account number");
        a_no= sc.next();
        boolean foundd = false;
        int i=0;
        for (i = 0; i < C.length; i++) {
            foundd = C[i].search(a_no, data[i]);
            if (foundd) {
                break;
            }
        }
        if(!foundd)
        {
            return;
        }
        do {

            System.out.println("\n\n***ATM Application***");
            System.out.println("1. Display details \n2. Withdraw Amount\n3. Change Pin \n4. Exit ");
            System.out.println("Enter your choice: ");
            ch1= sc.nextInt();
            switch(ch1) {
                case 1:
                    atm.showAccount(data[i]);
                    break;
                case 2:
                    System.out.println("\nEnter your Pin: ");
                    int pin= sc.nextInt();
                    if(pin== data[i].pin)
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
    }

    private static void withdrawMoney(Scanner sc, BankFunctions[] C, Details[] data) {
        boolean found;
        String ac_no;
        System.out.print("Enter Account No : ");
        ac_no = sc.next();
        found = false;
        for (int i = 0; i < C.length; i++) {
            found = C[i].search(ac_no, data[i]);
            if (found) {
                C[i].withdrawal(data[i]);
                break;
            }
        }
        if (!found) {
            System.out.println("Search failed! Account doesn't exist..!!");
        }
    }

    private static void DepositMoney(Scanner sc, BankFunctions[] C, Details[] data) {
        String ac_no;
        boolean found;
        System.out.print("Enter Account no. : ");
        ac_no = sc.next();
        found = false;
        for (int i = 0; i < C.length; i++) {
            found = C[i].search(ac_no, data[i]);
            if (found) {
                C[i].deposit(data[i]);
                break;
            }
        }
        if (!found) {
            System.out.println("Search failed! Account doesn't exist..!!");
        }
    }

    private static void searchUser(Scanner sc, BankFunctions[] C, Details[] data) {
        System.out.print("Enter account no. you want to search: ");
        String ac_no = sc.next();
        boolean found = false;
        for (int i = 0; i < C.length; i++) {
            found = C[i].search(ac_no, data[i]);
            if (found) {
                C[i].showAccount(data[i]);
                break;
            }
        }
        if (!found) {
            System.out.println("Search failed! Account doesn't exist..!!");
        }
    }

    private static void showAllUser(BankFunctions[] C, Details[] data) {
        for (int i = 0; i < C.length; i++) {
            C[i].showAccount(data[i]);
        }
    }

    private static int getUser(BankFunctions[] C, Details[] data, int i) {
        Argument bankFunctionArgument=new Argument();
        bankFunctionArgument.withdraw=new Withdraw();
        bankFunctionArgument.print=new Printing();
        bankFunctionArgument.openAcc=new AccountOpen();
        bankFunctionArgument.depositMoney=new Deposit();
        bankFunctionArgument.searchUserAccount=new SearchAccount();
        C[i] = new BankFunctions(bankFunctionArgument);
        data[i]=new Details();
        C[i].openAccount(data[i]);
        i++;
        return i;
    }
}

