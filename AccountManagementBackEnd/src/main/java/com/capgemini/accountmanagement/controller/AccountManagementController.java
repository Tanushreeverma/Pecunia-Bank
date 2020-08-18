package com.capgemini.accountmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.accountmanagement.dto.UpdateData;
import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.CustomerDetails;

import com.capgemini.accountmanagement.exception.UserDefinedException;
import com.capgemini.accountmanagement.service.AccountService;

/********************************************************************************
 * @author      Tanushree Verma
 * Description  This is the controller class, it is responsible to manage the
 *              flow of the application.
 * Created On   24-July-2020 
 ********************************************************************************/

@RestController
public class AccountManagementController {

	@Autowired
	AccountService accountService;

	String response;

	/********************************************************************************
	 * Method        addAccount 
	 * Description   to call the service function add account to perform the addition
	 *               of data returns Response
	 * returns       response as added  successfully if account is added 
	 * Created By    Tanushree Verma
	 * Created on    24-July-2020
	 **********************************************************************************/

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/account")
	public ResponseEntity<String> addAccount(@RequestBody CustomerDetails customerDetails) {
		boolean result = accountService.addAccount(customerDetails);
		if (result) {
			response = "{\"data\":\"Account added Sucessfully\"} ";
		}

		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	/**********************************************************************************
	 * Method        updateMobileNumber
	 * Description   to call the updateAccountMobileNumber to perform updation
	 *               of Mobile Number 
	 * returns       boolean response as Mobile number updated successfully if mobile
	 *               number is updated otherwise it will throw an exception
	 * Created By    Tanushree Verma
	 * Created on    24-July-2020
	 **********************************************************************************/

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updateMobile")
	public ResponseEntity<String> updateMobileNumber(@RequestBody UpdateData data) {
		boolean result = accountService.updateAccountMobileNumber(data.getMobileNumber(), data.getAccountNumber());
		if (result) {
			response = " {\"data\":\"Mobile Number Updated Sucessfully\"}";
		} else
			throw new UserDefinedException("Account Number is Invalid");

		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	/**********************************************************************************
	 * Method        deleteAccount 
	 * Description   to call the deleteAccount to perform deletion task
	 * returns       boolean response as Account deleted successfully if account is
	 *               deleted otherwise it will throw an exception
	 * Created By    Tanushree Verma 
	 * Created on    24-July-2020
	 **********************************************************************************/

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/account/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable long accountNumber) {
		boolean result = accountService.deleteAccount(accountNumber);
		if (result) {
			response = "{\"data\":\"Account deleted Sucessfully\"}";
		} 
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	/********************************************************************************
	 * Method       updateAccountAddress
	 * Description  to call updateAddress function to perform updation of address
	 * returns      boolean returns response as address updated successfully if 
	 *              address is updated 
	 * Created By   Tanushree Verma
	 * Created on   24-July-2020
	 **********************************************************************************/

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updateAddress")
	public ResponseEntity<String> updateAddress(@RequestBody UpdateData data) {
		boolean result = accountService.updateAccountAddress(data.getAccountNumber(), data.getAddress());
		if (result) {
			response = "{\"data\":\"Address updated Sucessfully\"}";
		} else
			throw new UserDefinedException("Account Number is Invalid");
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	/********************************************************************************
	 * Method        updateName
	 * Description   to call updateName function to perform updation of name
	 * returns       boolean returns response as Name updated successfully if name
	 *               is updated
	 * Created By    Tanushree Verma 
	 * Created on    24-July-2020
	 **********************************************************************************/

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updateName")
	public ResponseEntity<String> updateName(@RequestBody UpdateData data) {
		boolean result = accountService.updateName(data.getFirstName(), data.getLastName(), data.getAccountNumber());
		if (result) {
			response = "{\"data\":\"Name Updated Sucessfully\"}";
		} else
			throw new UserDefinedException("Account Number is Invalid");
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	/**********************************************************************************
	 * Method        getAllAccount 
	 * Description   it calls the allAccount to provide details of all account
	 * returns       boolean returns response as list of account whose status is active
	 * Created By    Tanushree Verma 
	 * Created on    24-July-2020
	 **********************************************************************************/

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/accounts")
	public ResponseEntity<List<AccountDetails>> getAllAccount() {
		List<AccountDetails> accountlist = accountService.getAllAccount();
		List<AccountDetails> accountlist1 = new ArrayList<AccountDetails>();
		for (AccountDetails accountDetails : accountlist) {
			if (accountDetails.getAccountStatus().equals("Close"))
				;
			else {
				accountlist1.add(accountDetails);
			}
		}
		return new ResponseEntity<List<AccountDetails>>(accountlist1, HttpStatus.OK);
	}

	/********************************************************************************
	 * Method        checkAccountExist 
	 * Description   To check account exists or not returns
	 * boolean       returns response as account doesn't exist if account is not present
	 *               in the database
	 * Created By    Tanushree Verma
	 * Created on    24-July-2020
	 **********************************************************************************/

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("accounts/{accountNumber}")
	public ResponseEntity<String> checkAccountExist(@PathVariable long accountNumber) {
		boolean result = accountService.checkAccountExist(accountNumber);
		if (result == false) {
			response = "{\"data\":\"Account doesn't exists\"}";

		} else {
			response = "{\"data\":\"\"}";
		}

		return new ResponseEntity<String>(response, HttpStatus.OK);

	}

	/********************************************************************************
	 * Method         getAccountDetails 
	 * Description    To get the account details 
	 * returns        account details according to the given account number        
	 * Created By     Tanushree Verma 
	 * Created on     24-July-2020
	 **********************************************************************************/

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("account/{accountNumber}")
	public ResponseEntity<AccountDetails> getAccountDetails(@PathVariable long accountNumber) {
		AccountDetails accountDetails = accountService.getAccountDetailsByAccountId(accountNumber);
		return new ResponseEntity<AccountDetails>(accountDetails, HttpStatus.OK);
	}

}
