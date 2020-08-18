package com.capgemini.accountmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.BranchDetails;

/********************************************************************************
 * @author       Tanushree Verma
 * Description   This Dao is for updating account
 *               balance,checking whether the the account exists or not, for getting
 *               Account Details by the account number,for finding the branch,for
 *               getting the list of all accounts 
 * Created On    24-July-2020
 ********************************************************************************/

@Transactional
@Repository
@Service
public class AccountDaoImplementation implements AccountDao {

	@Autowired
	EntityManager entityManager;



	/********************************************************************************
	 * Method            checkAccountExist 
	 * Description       for checking whether the account exists or not
	 * returns boolean   returns true if account exists otherwise returns false if 
	 *                   account does not exists 
	 * Created By        Tanushree Verma                  
	 * Created on        24-July-2020
	 **********************************************************************************/

	@Override
	public boolean checkAccountExist(long accountNumber) {
		return entityManager.contains(entityManager.find(AccountDetails.class, accountNumber));
	}

	/**********************************************************************************
	 * Method        findAccountDetails 
	 * Description   for fetching the account details of the given account number
	 * returns       account details by account number 
	 * Created By    Tanushree Verma 
	 * Created on    23-July-2020
	 ***********************************************************************************/

	@Override
	public AccountDetails findAccountDetails(long accountNumber) {
		return entityManager.find(AccountDetails.class, accountNumber);
	}

	/**********************************************************************************
	 * Method       findBranch 
	 * Description  for fetching the branch details of the given branch Id
	 * returns      branch details by branch Id 
	 * Created By  Tanushree Verma
	 * Created on   24-July-2020
	 ***********************************************************************************/

	@Override
	public BranchDetails findBranch(int branchId) {

		return entityManager.find(BranchDetails.class, branchId);
	}

	/**********************************************************************************
	 * Method        getAllAccount 
	 * Description   for getting the list of accounts with details of all the accounts
	 * returns       List account list 
	 * Created By    Tanushree Verma
	 * Created on    24-July-2020
	 ***********************************************************************************/

	@Override
	public List<AccountDetails> getAllAccount() {
		String sqlQuery = "SELECT account FROM AccountDetails account";
		TypedQuery<AccountDetails> query = entityManager.createQuery(sqlQuery, AccountDetails.class);
		List<AccountDetails> accountList = query.getResultList();
		return accountList;
	}

	/**********************************************************************************
	 * Method        getAccountDetailsByAccountId 
	 * Description   for finding the account by account number 
	 * returns       List account details by account number 
	 * Created By    Tanushree Verma
	 * Created on    24-July-2020
	 ***********************************************************************************/

	@Override
	public AccountDetails getAccountDetailsByAccountId(long accountNumber) {
		return entityManager.find(AccountDetails.class, accountNumber);
	}
}
