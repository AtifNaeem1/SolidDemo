package com.Banking;

public class ATM extends BasicBankFunction implements ChangePin {
    ChangePin changeATMpin;

    public ATM(WithdrawMoney withdrawl, PrintDetails printdetails, ChangePin changeATMpin) {
        super(withdrawl, printdetails);
        this.changeATMpin = changeATMpin;
    }

    public void changePin(Details customerDetails) {
        changeATMpin.changePin(customerDetails);

    }
}
