package com.Banking;

public class BasicBankFunction implements WithdrawMoney, PrintDetails {
    WithdrawMoney withdraw;
    PrintDetails print;

    BasicBankFunction(WithdrawMoney withdraw, PrintDetails print) {
        this.withdraw = withdraw;
        this.print = print;
    }

    @Override
    public void withdrawal(Details customerDetails) {
        withdraw.withdrawal(customerDetails);
    }

    @Override
    public void showAccount(Details customerDetails) {
        print.showAccount(customerDetails);
    }
}
