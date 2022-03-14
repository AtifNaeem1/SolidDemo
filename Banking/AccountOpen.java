package com.Banking;

import java.util.Scanner;

public class AccountOpen implements OpenBankAccount {
    Scanner scannerObject = new Scanner(System.in);

    @Override
    public void openAccount(Details customerDetails) {      //code to open account
        System.out.print("Enter Account No: ");
        customerDetails.accno = scannerObject.next();
        System.out.print("Enter Account type: ");
        customerDetails.acc_type = scannerObject.next();
        System.out.print("Enter Name: ");
        customerDetails.name = scannerObject.next();
        System.out.print("Enter Balance: ");
        customerDetails.balance = scannerObject.nextLong();
        System.out.print("Create your ATM pin: ");
        customerDetails.pin = scannerObject.nextInt();
    }
}
