package com.Banking;

import java.util.Scanner;

public class PinManagement implements ChangePin {

    @Override
    public void changePin(Details customerDetails)    //code to change ATM pin
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("\n For verification please enter your current pin :  ");
        int currentPin = scn.nextInt();
        if (customerDetails.pin == currentPin) {
            System.out.println("\nEnter new pin: ");
            customerDetails.pin = scn.nextInt();
            System.out.println("\n Pin changed Successfully\n");
        } else {
            System.out.println("\n Wrong pin\n");
        }
    }
}
