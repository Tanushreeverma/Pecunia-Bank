package com.capgemini.accountmanagement.dao;

import java.util.List;

import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.BranchDetails;

public interface AccountDao {

	public boolean checkAccountExist(long accountNumber);

	public AccountDetails findAccountDetails(long accountNumber);

	public BranchDetails findBranch(int branchid);

	public List<AccountDetails> getAllAccount();

	public AccountDetails getAccountDetailsByAccountId(long accountNumber);

}
