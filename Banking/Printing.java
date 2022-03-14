package com.Banking;

public class Printing implements PrintDetails {

    @Override
    public void showAccount(Details customerDetails)   //printing customer details
    {
        System.out.println("Name of account holder: " + customerDetails.name);
        System.out.println("Account no.: " + customerDetails.accno);
        System.out.println("Account type: " + customerDetails.acc_type);
        System.out.println("Balance: " + customerDetails.balance);
    }
}
