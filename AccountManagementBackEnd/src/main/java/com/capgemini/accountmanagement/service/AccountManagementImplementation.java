package com.capgemini.accountmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.accountmanagement.dao.AccountDao;
import com.capgemini.accountmanagement.dao.CustomerDao;
import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.AddressDetails;
import com.capgemini.accountmanagement.entity.CustomerDetails;
import com.capgemini.accountmanagement.exception.UserDefinedException;

/********************************************************************************
 * @author        Tanushree Verma 
 * Description    This is a service class performing services such as adding 
 *                account,deleting account,calling other functions to perform
 *                services 
 * Created On     25-July-2020
 * 
 ********************************************************************************/

@Service
public class AccountManagementImplementation implements AccountService {

	@Autowired
	AccountDao accountDao;

	@Autowired
	CustomerDao customerDao;

	/********************************************************************************
	 * Method         addAccount 
	 * Description    for adding the details in account according to the details given
	 *                by customer 
	 * returns        boolean as true if all the details are added successfully
	 *                else returns false 
	 * Created By     Tanushree Verma
	 * Created on     25-July-2020
	 **********************************************************************************/

	@Override
	public boolean addAccount(CustomerDetails customerDetails) {

		customerDao.addCustomer(customerDetails);
		AccountDetails account = new AccountDetails();
		account.setAccountBalance(customerDetails.getOpeningBalance());
		account.setAccountHolderName(
				customerDetails.getCustomerFirstName() + " " + customerDetails.getCustomerLastName());
		if (customerDetails.getAccountType().equals("Savings"))
			account.setAccountInterest((float) 3.5);
		else if (customerDetails.getAccountType().equals("Current"))
			account.setAccountInterest((float) 3.0);
		account.setAccountStatus("Active");
		account.setOpeningDate(LocalDateTime.now());
		account.setBranchdetails(accountDao.findBranch(customerDetails.getBranchId()));// which branch customer want to
																						// open an account..
		account.setCustomerDetails(customerDetails);
		customerDao.addAccount(account);// add account to data base.
		System.out.println("Account added successfully");
		return true;

	}

	@Override
	public boolean deleteAccount(long accountNumber) {
		return customerDao.deleteAccount(accountNumber);
	}

	@Override
	public boolean updateAccountAddress(long accountNumber, AddressDetails address) {
		return customerDao.updateAddress(accountNumber, address);
	}

	@Override
	public boolean updateAccountMobileNumber(String mobileNumber, long accountNumber) {
		return customerDao.updateMobile(mobileNumber, accountNumber);
	}

	@Override
	public boolean updateName(String fname, String lname, long accountNumber) {

		return customerDao.updateName(fname, lname, accountNumber);
	}

	@Override
	public List<AccountDetails> getAllAccount() {

		return accountDao.getAllAccount();
	}

	@Override
	public boolean checkAccountExist(long accountNumber) {

		return accountDao.checkAccountExist(accountNumber);
	}

	/********************************************************************************
	 * Method          getAccountDetailsById 
	 * Description     for fetching the account details according to the account
	 *                 number 
	 * returns         boolean as true accountDetails if account exist otherwise
	 *  			   gives an exception 
	 * Created By      Tanushree Verma 
	 * Created on      25-July-2020
	 **********************************************************************************/

	@Override
	public AccountDetails getAccountDetailsByAccountId(long accountNumber) throws UserDefinedException {
		AccountDetails accountDetails = accountDao.getAccountDetailsByAccountId(accountNumber);
		if (accountDetails == null)

			throw new UserDefinedException("{\"data\":\"Account doesn't exists\"}");
		else
			return accountDetails;
	}

}
