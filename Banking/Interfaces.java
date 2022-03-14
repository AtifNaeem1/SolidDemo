package com.Banking;

interface DepositMoney
{
    void deposit(Details customerDetails);
}
interface WithdrawMoney
{
    void withdrawal(Details customerDetails);           //following Interface segregation principle
}
interface OpenBankAccount
{
    void openAccount(Details customerDetails);
}

interface PrintDetails
{
    void showAccount(Details customerDetails);
}
interface Searching
{
    boolean search(String ac_no,Details customerDetails);
}
interface ChangePin
{
    void changePin(Details customerDetails);
}
