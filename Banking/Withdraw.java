package com.Banking;

import java.util.Scanner;

public class Withdraw implements WithdrawMoney {
    Scanner sc = new Scanner(System.in);

    @Override
    public void withdrawal(Details customerDetails)   //code to withdraw money
    {
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();
        if (customerDetails.balance >= amt) {
            customerDetails.balance = customerDetails.balance - amt;
            System.out.println("Balance after withdrawal: " + customerDetails.balance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!");
        }
    }
}
