package com.Banking;

public class SearchAccount implements Searching {
    @Override
    public boolean search(String ac_no, Details customerDetails)   //searching customer in bank record
    {
        return customerDetails.accno.equals(ac_no);
    }
}
