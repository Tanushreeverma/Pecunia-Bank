package com.capgemini.accountmanagement.dto;

import com.capgemini.accountmanagement.entity.AddressDetails;

/********************************************************************************
 * @author       Tanushree Verma 
 * Description   This class is used as DTO,i.e,data transfer object 
 * Created On    24-July-2020        
 ********************************************************************************/

public class UpdateData {

	String mobileNumber;
	long accountNumber;
	AddressDetails address;
	String firstName;
	String lastName;

	public UpdateData(long accountNumber, String firstName, String lastName) {
		super();
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public UpdateData(String mobileNumber, long accountNumber) {
		super();
		this.mobileNumber = mobileNumber;
		this.accountNumber = accountNumber;
	}

	public UpdateData(long accountNumber, AddressDetails address) {
		super();
		this.accountNumber = accountNumber;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UpdateData() {
		super();
	}

	public AddressDetails getAddress() {
		return address;
	}

	public void setAddress(AddressDetails address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

}
