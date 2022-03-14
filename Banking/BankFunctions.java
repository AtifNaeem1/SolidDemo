package com.Banking;

public class BankFunctions extends BasicBankFunction implements OpenBankAccount, DepositMoney, Searching {
    OpenBankAccount openAcc;
    DepositMoney depositMoney;
    Searching searchUserAccount;

    public BankFunctions(Argument bankFunctionArgument) {
        super(bankFunctionArgument.withdraw, bankFunctionArgument.print);
        this.depositMoney = bankFunctionArgument.depositMoney;
        this.openAcc = bankFunctionArgument.openAcc;
        this.searchUserAccount = bankFunctionArgument.searchUserAccount;
    }

    @Override
    public void deposit(Details customerDetails) {
        depositMoney.deposit(customerDetails);
    }

    @Override
    public void openAccount(Details customerDetails) {
        openAcc.openAccount(customerDetails);
    }

    @Override
    public boolean search(String ac_no, Details customerDetails) {

        return searchUserAccount.search(ac_no, customerDetails);
    }
}
