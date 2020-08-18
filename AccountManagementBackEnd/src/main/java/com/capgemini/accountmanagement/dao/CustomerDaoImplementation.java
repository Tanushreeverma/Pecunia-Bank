package com.capgemini.accountmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.AddressDetails;
import com.capgemini.accountmanagement.entity.CustomerDetails;

/********************************************************************************
 * @author       Tanushree Verma 
 * Description   This Dao is for saving the account
 *               details,saving the customer details,fetch customer details, delete
 *               account,update the account details(name,contact number,address)
 * Created On    24-July-2020
 * 
 ********************************************************************************/
@Transactional
@Repository
@Service
public class CustomerDaoImplementation implements CustomerDao {

	@PersistenceContext
	EntityManager entityManager;

	/**********************************************************************************
	 * Method        addCustomer 
	 * Description   for saving the customer details 
	 * Created By   Tanushree Verma 
	 * Created on    24-July-2020
	 ***********************************************************************************/

	@Override
	public void addCustomer(CustomerDetails customerDetails) {
		entityManager.persist(customerDetails);
	}

	/**********************************************************************************
	 * Method        addAccount 
	 * Description   for saving the account details
	 * Created By    Tanushree Verma
	 * Created on    24-July-2020
	 ***********************************************************************************/

	@Override
	public void addAccount(AccountDetails account) {
		entityManager.persist(account);
	}

	/**********************************************************************************
	 * Method        deleteAccount 
	 * Description   To delete account,by changing the status from "Active" to "Close" 
	 * Created By    Tanushree Verma 
	 * Created on    24-July-2020
	 ***********************************************************************************/

	@Override
	public boolean deleteAccount(long accountNumber) {

		if (entityManager.contains(entityManager.find(AccountDetails.class, accountNumber))) {
			AccountDetails account = entityManager.find(AccountDetails.class, accountNumber);
			if (account.getAccountStatus().equals("Active")) {
				account.setAccountStatus("Close");
				account.setAccountInterest((float) 0.0);
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/**************************************************************************************
	 * Method         updateMobile 
	 * Description    To update the mobile number of the account holder
	 * Created By     Tanushree Verma
	 * Created on     24-July-2020
	 **************************************************************************************/

	@Override
	public boolean updateMobile(String mobileNumber, long accountNumber) {

		if (entityManager.contains(entityManager.find(AccountDetails.class, accountNumber))) {
			AccountDetails account = entityManager.find(AccountDetails.class, accountNumber);
			CustomerDetails customer = entityManager.find(CustomerDetails.class,
					account.getCustomerDetails().getCustomerId());
			customer.setContactNumber(mobileNumber);
			account.setCustomerDetails(customer);
			return true;
		}
		return false;
	}

	/**************************************************************************************
	 * Method        updateAddress 
	 * Description   To update the address of the account holder
	 * Created By    Tanushree Verma
	 * Created on    24-July-2020
	 *************************************************************************************/
	@Override
	public boolean updateAddress(long accountNumber, AddressDetails address) {

		if (entityManager.contains(entityManager.find(AccountDetails.class, accountNumber))) {
			AccountDetails account = entityManager.find(AccountDetails.class, accountNumber);
			CustomerDetails customer = entityManager.find(CustomerDetails.class,
					account.getCustomerDetails().getCustomerId());
			AddressDetails address1 = entityManager.find(AddressDetails.class,
					account.getCustomerDetails().getAddress().getAddressId());
			address1.setCity(address.getCity());
			address1.setState(address.getState());
			address1.setStreet(address.getStreet());
			address1.setZipCode(address.getZipCode());
			customer.setAddress(address1);
			account.setCustomerDetails(customer);
			return true;
		}
		return false;
	}

	/**************************************************************************************
	 * Method       updateName 
	 * Description  To update the name of the account holder
	 * Created By   Tanushree Verma  
	 * Created on   24-July-2020
	 **************************************************************************************/

	@Override
	public boolean updateName(String fname, String lname, long accountNumber) {

		if (entityManager.contains(entityManager.find(AccountDetails.class, accountNumber))) {
			AccountDetails account = entityManager.find(AccountDetails.class, accountNumber);
			CustomerDetails customer = entityManager.find(CustomerDetails.class,
					account.getCustomerDetails().getCustomerId());
			customer.setCustomerFirstName(fname);
			customer.setCustomerLastName(lname);
			account.setAccountHolderName(fname + " " + lname);
			account.setCustomerDetails(customer);
			return true;
		}
		return false;
	}

}
