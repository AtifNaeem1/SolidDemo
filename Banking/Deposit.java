package com.Banking;

import java.util.Scanner;

public class Deposit implements DepositMoney {

    Scanner sc = new Scanner(System.in);

    @Override
    public void deposit(Details customerDetails)   //code to deposit money
    {
        long amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextLong();
        customerDetails.balance = customerDetails.balance + amt;

    }
}
