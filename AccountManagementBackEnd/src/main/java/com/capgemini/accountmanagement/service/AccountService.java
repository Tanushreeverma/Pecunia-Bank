package com.capgemini.accountmanagement.service;

import java.util.List;

import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.AddressDetails;
import com.capgemini.accountmanagement.entity.CustomerDetails;

public interface AccountService {

	public boolean addAccount(CustomerDetails customerDetails);

	public boolean deleteAccount(long accountNumber);

	public boolean updateAccountAddress(long accountNumber, AddressDetails address);

	public boolean updateAccountMobileNumber(String mobileNumber, long accountNumber);

	public boolean updateName(String fname, String lname, long accountNumber);

	public List<AccountDetails> getAllAccount();

	public boolean checkAccountExist(long accountNumber);

	public AccountDetails getAccountDetailsByAccountId(long accountNumber);

}
