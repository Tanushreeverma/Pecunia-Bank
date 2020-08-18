package com.capgemini.accountmanagement.dao;

import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.AddressDetails;
import com.capgemini.accountmanagement.entity.CustomerDetails;

public interface CustomerDao {

	public void addCustomer(CustomerDetails customerDetails);

	public boolean deleteAccount(long accountNumber);

	public boolean updateMobile(String mobileNumber, long accountNumber);

	public boolean updateAddress(long accountNumber, AddressDetails address);

	public boolean updateName(String fname, String lname, long accountNumber);

	public void addAccount(AccountDetails account);

}
