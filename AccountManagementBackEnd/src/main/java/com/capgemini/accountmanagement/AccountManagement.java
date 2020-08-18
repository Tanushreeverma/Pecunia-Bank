package com.capgemini.accountmanagement;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.accountmanagement.dao.DaoService;
import com.capgemini.accountmanagement.entity.AccountDetails;
import com.capgemini.accountmanagement.entity.AddressDetails;
import com.capgemini.accountmanagement.entity.BranchDetails;
import com.capgemini.accountmanagement.entity.CustomerDetails;
import com.capgemini.accountmanagement.service.AccountService;

@SpringBootApplication
public class AccountManagement implements CommandLineRunner {

	@Autowired
	DaoService daoService;

	@Autowired
	AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(AccountManagement.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Branch details
		BranchDetails branchDetails1 = new BranchDetails();
		AddressDetails address1 = new AddressDetails();
		address1.setStreet("UNI MALL,LPU");
		address1.setCity("PHAGWARA");
		address1.setState("PUNJAB");
		address1.setZipCode("144401");
		branchDetails1.setBranchName("LPU PECUNIA");
		branchDetails1.setBranchIFSC("PUNB033950");
		branchDetails1.setPhoneNumber("2201");
		branchDetails1.setAddress(address1);

		BranchDetails branchDetails2 = new BranchDetails();
		AddressDetails address2 = new AddressDetails();
		address2.setStreet("RAJA PARK");
		address2.setCity("KANPUR");
		address2.setState("UP");
		address2.setZipCode("815520");
		branchDetails2.setBranchName("KANPUR PECUNIA");
		branchDetails2.setBranchIFSC("PUNB033951");
		branchDetails2.setPhoneNumber("2202");
		branchDetails2.setAddress(address2);

		BranchDetails branchDetails3 = new BranchDetails();
		AddressDetails address3 = new AddressDetails();
		address3.setStreet("GHANTA GHAR");
		address3.setCity("JAIPUR");
		address3.setState("RAJASTHAN");
		address3.setZipCode("808124");
		branchDetails3.setBranchName("JAIPUR PECUNIA");
		branchDetails3.setBranchIFSC("PUNB033952");
		branchDetails3.setPhoneNumber("2203");
		branchDetails3.setAddress(address3);

		BranchDetails branchDetails4 = new BranchDetails();
		AddressDetails address4 = new AddressDetails();
		address4.setStreet("GANGJALA");
		address4.setCity("SAHARSA");
		address4.setState("BIHAR");
		address4.setZipCode("852201");
		branchDetails4.setBranchName("SAHARSA PECUNIA");
		branchDetails4.setBranchIFSC("PUNB033953");
		branchDetails4.setPhoneNumber("2204");
		branchDetails4.setAddress(address4);

		BranchDetails branchDetails5 = new BranchDetails();
		AddressDetails address5 = new AddressDetails();
		address5.setStreet("RAJIV CHOWK");
		address5.setCity("NEW DELHI");
		address5.setState("NEW DELHI");
		address5.setZipCode("141101");
		branchDetails5.setBranchName("DELHI PECUNIA");
		branchDetails5.setBranchIFSC("PUNB033954");
		branchDetails5.setPhoneNumber("2205");
		branchDetails5.setAddress(address5);

		daoService.insertBranchDetails(branchDetails1);
		daoService.insertBranchDetails(branchDetails2);
		daoService.insertBranchDetails(branchDetails3);
		daoService.insertBranchDetails(branchDetails4);
		daoService.insertBranchDetails(branchDetails5);

		// Account 1
		AccountDetails accountDetails1 = new AccountDetails();
		AddressDetails customer1Address = new AddressDetails();
		CustomerDetails customerDetails1 = new CustomerDetails();

		customerDetails1.setCustomerFirstName("Vaishali");
		customerDetails1.setCustomerLastName("Tiwari");
		customerDetails1.setDOB("07/07/1998");
		customerDetails1.setAge("21");
		customerDetails1.setGender("Female");
		customerDetails1.setContactNumber("9815406012");
		customerDetails1.setPanNumber("QSWED2034M");
		customerDetails1.setAdhaarNumber("365074519856");
		customerDetails1.setAccountType("Current");
		customerDetails1.setOpeningBalance(25000);
		customerDetails1.setBranchId(branchDetails1.getBranchId());
		customer1Address.setStreet("127/211 W-2 Juhi Kalan");
		customer1Address.setState("UP");
		customer1Address.setCity("Kanpur");
		customer1Address.setZipCode("208027");
		customerDetails1.setAddress(customer1Address);
		accountDetails1.setCustomerDetails(customerDetails1);
		accountDetails1.setAccountHolderName("Vaishali Tiwari");
		accountDetails1.setAccountStatus("Active");
		accountDetails1.setAccountBalance(25000);
		customerDetails1.setCreditScore(750);
		accountDetails1.setAccountInterest(3);
		accountDetails1.setOpeningDate(LocalDateTime.now());
		accountDetails1.setBranchdetails(branchDetails1);

		// Account 2

		AccountDetails accountDetails2 = new AccountDetails();
		AddressDetails customer2Address = new AddressDetails();
		CustomerDetails customerDetails2 = new CustomerDetails();

		accountDetails2.setAccountHolderName("Ashish Singh");
		accountDetails2.setAccountInterest((float) 3.5);
		customerDetails2.setCreditScore(90);
		accountDetails2.setAccountBalance(12000);
		accountDetails2.setAccountStatus("Active");
		accountDetails2.setBranchdetails(branchDetails1);
		accountDetails2.setOpeningDate(LocalDateTime.now());
		customerDetails2.setBranchId(branchDetails1.getBranchId());
		customerDetails2.setOpeningBalance(12000);
		customerDetails2.setAccountType("Savings");
		customerDetails2.setAdhaarNumber("748585553330");
		customerDetails2.setContactNumber("9041459865");
		customerDetails2.setPanNumber("RTYUO8502L");
		customerDetails2.setDOB("06/02/1998");
		customerDetails2.setCustomerFirstName("Ashish");
		customerDetails2.setCustomerLastName("Singh");
		customerDetails2.setAge("22");
		customerDetails2.setGender("Male");
		customer2Address.setStreet("58,Govindpura");
		customer2Address.setState("New Delhi");
		customer2Address.setCity("New Delhi");
		customer2Address.setZipCode("110011");
		customerDetails2.setAddress(customer2Address);
		accountDetails2.setCustomerDetails(customerDetails2);

		// Account 3
		AccountDetails accountDetails3 = new AccountDetails();
		AddressDetails customer3Address = new AddressDetails();
		CustomerDetails customerDetails3 = new CustomerDetails();

		accountDetails3.setAccountHolderName("Vishal Tiwari");
		accountDetails3.setAccountInterest((float) 3.5);
		customerDetails3.setCreditScore(500);
		accountDetails3.setAccountBalance(6000);
		accountDetails3.setAccountStatus("Active");
		accountDetails3.setBranchdetails(branchDetails2);
		accountDetails3.setOpeningDate(LocalDateTime.now());

		customerDetails3.setBranchId(branchDetails2.getBranchId());
		customerDetails3.setOpeningBalance(6000);
		customerDetails3.setAccountType("Savings");
		customerDetails3.setAdhaarNumber("965222226000");
		customerDetails3.setContactNumber("7007820982");
		customerDetails3.setPanNumber("AATRE4747P");
		customerDetails3.setDOB("23/10/1994");
		customerDetails3.setCustomerFirstName("Vishal");
		customerDetails3.setCustomerLastName("Tiwari");
		customerDetails3.setAge("26");
		customerDetails3.setGender("Male");
		customer3Address.setStreet("718,Collector Ganj");
		customer3Address.setState("UP");
		customer3Address.setCity("Unnao");
		customer3Address.setZipCode("209801");
		customerDetails3.setAddress(customer3Address);
		accountDetails3.setCustomerDetails(customerDetails3);

//Account 4

		AccountDetails accountDetails4 = new AccountDetails();
		AddressDetails customer4Address = new AddressDetails();
		CustomerDetails customerDetails4 = new CustomerDetails();

		accountDetails4.setAccountHolderName("Mradula Shukla");
		accountDetails4.setAccountInterest(3);
		customerDetails4.setCreditScore(170);
		accountDetails4.setAccountBalance(8500);
		accountDetails4.setAccountStatus("Active");
		accountDetails4.setBranchdetails(branchDetails2);
		accountDetails4.setOpeningDate(LocalDateTime.now());
		customerDetails4.setBranchId(branchDetails2.getBranchId());
		customerDetails4.setOpeningBalance(8500);
		customerDetails4.setAccountType("Current");
		customerDetails4.setAdhaarNumber("985445692345");
		customerDetails4.setContactNumber("8004255984");
		customerDetails4.setPanNumber("YTRFV6064L");
		customerDetails4.setDOB("21/06/1994");
		customerDetails4.setCustomerFirstName("Mradula");
		customerDetails4.setCustomerLastName("Shukla");
		customerDetails4.setAge("44");
		customerDetails4.setGender("Female");
		customer4Address.setStreet("126,Sector-11");
		customer4Address.setState("Gujrat");
		customer4Address.setCity("Gandhi Nagar");
		customer4Address.setZipCode("362011");
		customerDetails4.setAddress(customer4Address);
		accountDetails4.setCustomerDetails(customerDetails4);
		customerDetails4.setAddress(customer4Address);
		accountDetails4.setCustomerDetails(customerDetails4);

		// Account5
		AccountDetails accountDetails5 = new AccountDetails();
		AddressDetails customer5Address = new AddressDetails();
		CustomerDetails customerDetails5 = new CustomerDetails();

		accountDetails5.setAccountHolderName("Anushkaa Awasthi");
		accountDetails5.setAccountInterest(3);
		customerDetails5.setCreditScore(700);
		accountDetails5.setAccountBalance(9700);
		accountDetails5.setAccountStatus("Active");
		accountDetails5.setBranchdetails(branchDetails3);
		customerDetails5.setBranchId(branchDetails3.getBranchId());
		customerDetails5.setOpeningBalance(9700);
		customerDetails5.setAccountType("Current");
		customerDetails5.setAdhaarNumber("745854642545");
		customerDetails5.setContactNumber("8317016118");
		customerDetails5.setPanNumber("QCFRE8506F");
		customerDetails5.setDOB("06/04/1989");
		customerDetails5.setCustomerFirstName("Anushkaa");
		customerDetails5.setCustomerLastName("Awasthi");
		customerDetails5.setAge("31");
		customerDetails5.setGender("Female");
		customer5Address.setStreet("2-9-2,Arihant Majestiv Towers");
		customer5Address.setState("Tamil Nadu");
		customer5Address.setCity("Chennai");
		customer5Address.setZipCode("600107");
		accountDetails5.setOpeningDate(LocalDateTime.now());
		customerDetails5.setAddress(customer5Address);
		accountDetails5.setCustomerDetails(customerDetails5);
		customerDetails5.setAddress(customer5Address);
		accountDetails5.setCustomerDetails(customerDetails5);

		// Account6

		AccountDetails accountDetails6 = new AccountDetails();
		AddressDetails customer6Address = new AddressDetails();
		CustomerDetails customerDetails6 = new CustomerDetails();
		accountDetails6.setAccountHolderName("Prabhjot");
		accountDetails6.setAccountInterest(3);
		customerDetails6.setCreditScore(250);
		accountDetails6.setAccountBalance(5000);
		accountDetails6.setAccountStatus("Active");
		accountDetails6.setBranchdetails(branchDetails3);
		customerDetails6.setOpeningBalance(5000);
		customerDetails6.setAccountType("Current");
		customerDetails6.setAdhaarNumber("965645652421");
		customerDetails6.setContactNumber("8968117732");
		customerDetails6.setPanNumber("TYRFD5067P");
		customerDetails6.setDOB("05/03/1997");
		customerDetails6.setCustomerFirstName("Prabhjot");
		customerDetails6.setCustomerLastName("Kaur");
		customerDetails6.setAge("23");
		accountDetails6.setOpeningDate(LocalDateTime.now());
		customerDetails6.setGender("Female");
		customer6Address.setStreet("900,Bhagat Singh Nagar Model House");
		customer6Address.setState("Punjab");
		customer6Address.setCity("Jalandhar");
		customer6Address.setZipCode("144003");
		customerDetails6.setAddress(customer6Address);
		accountDetails6.setCustomerDetails(customerDetails6);
		customerDetails6.setAddress(customer6Address);
		accountDetails6.setCustomerDetails(customerDetails6);
		customerDetails6.setBranchId(branchDetails3.getBranchId());

		// Account 7
		AccountDetails accountDetails7 = new AccountDetails();
		AddressDetails customer7Address = new AddressDetails();
		CustomerDetails customerDetails7 = new CustomerDetails();
		accountDetails7.setAccountHolderName("Rahul Bajaj");
		accountDetails7.setAccountInterest((float) 3.5);
		customerDetails7.setCreditScore(200);
		accountDetails7.setAccountBalance(7500);
		accountDetails7.setAccountStatus("Active");
		accountDetails7.setBranchdetails(branchDetails3);
		customerDetails7.setOpeningBalance(7500);
		customerDetails7.setBranchId(branchDetails3.getBranchId());
		customerDetails7.setAccountType("Savings");
		customerDetails7.setAdhaarNumber("754685982115");
		customerDetails7.setContactNumber("9415546297");
		customerDetails7.setPanNumber("ASWED0099D");
		customerDetails7.setDOB("04/12/1978");
		customerDetails7.setCustomerFirstName("Rahul");
		customerDetails7.setCustomerLastName("Bajaj");
		customerDetails7.setAge("42");
		customerDetails7.setGender("Male");
		accountDetails7.setOpeningDate(LocalDateTime.now());
		customer7Address.setStreet("101 Circular Rd, Bemloi");
		customer7Address.setState("Himachal Pradesh");
		customer7Address.setCity("Shimla");
		customer7Address.setZipCode("171001");
		customerDetails7.setAddress(customer7Address);
		accountDetails7.setCustomerDetails(customerDetails7);
		customerDetails7.setAddress(customer7Address);
		accountDetails7.setCustomerDetails(customerDetails7);

		// Account 8

		AccountDetails accountDetails8 = new AccountDetails();
		AddressDetails customer8Address = new AddressDetails();
		CustomerDetails customerDetails8 = new CustomerDetails();
		accountDetails8.setAccountHolderName("Amardeep Singh");
		accountDetails8.setAccountInterest((float) 3);
		accountDetails8.setAccountBalance(590);
		accountDetails8.setAccountStatus("Active");
		accountDetails8.setOpeningDate(LocalDateTime.now());
		accountDetails8.setBranchdetails(branchDetails3);
		customerDetails8.setOpeningBalance(9000);
		customerDetails8.setAccountType("Current");
		customerDetails8.setAdhaarNumber("482955428768");
		customerDetails8.setContactNumber("8840864659");
		customerDetails8.setPanNumber("PYGTF0267P");
		customerDetails8.setDOB("03/05/1990");
		customerDetails8.setCustomerFirstName("Amardeep");
		customerDetails8.setCustomerLastName("Singh");
		customerDetails8.setAge("30");
		customerDetails8.setCreditScore(300);
		customerDetails8.setBranchId(branchDetails3.getBranchId());
		customerDetails8.setGender("Male");
		customer8Address.setStreet("Gujela, Ghatampur");
		customer8Address.setState("Uttar Pradesh");
		customer8Address.setCity("Kanpur");
		customer8Address.setZipCode("209206");
		customerDetails8.setAddress(customer8Address);
		accountDetails8.setCustomerDetails(customerDetails8);
		customerDetails8.setAddress(customer8Address);
		accountDetails8.setCustomerDetails(customerDetails8);

		// Account 9

		AccountDetails accountDetails9 = new AccountDetails();
		AddressDetails customer9Address = new AddressDetails();
		CustomerDetails customerDetails9 = new CustomerDetails();
		accountDetails9.setAccountHolderName("Satyam Sinha");
		accountDetails9.setAccountInterest((float) 3.5);
		customerDetails9.setCreditScore(160);
		accountDetails9.setAccountBalance(20000);
		accountDetails9.setAccountStatus("Active");
		accountDetails9.setOpeningDate(LocalDateTime.now());
		accountDetails9.setBranchdetails(branchDetails2);
		customerDetails9.setOpeningBalance(20000);
		customerDetails9.setAccountType("Savings");
		customerDetails9.setAdhaarNumber("698523456528");
		customerDetails9.setContactNumber("9973060640");
		customerDetails9.setPanNumber("BSTUM8165M");
		customerDetails9.setDOB("02/04/1984");
		customerDetails9.setCustomerFirstName("Satyam");
		customerDetails9.setCustomerLastName("Sinha");
		customerDetails9.setAge("36");
		customerDetails9.setGender("Male");
		customerDetails9.setBranchId(branchDetails2.getBranchId());
		customer9Address.setStreet("East off Bustand, Gangjala");
		customer9Address.setState("Bihar");
		customer9Address.setCity("Saharasa");
		customer9Address.setZipCode("855201");
		customerDetails9.setAddress(customer9Address);
		accountDetails9.setCustomerDetails(customerDetails9);
		customerDetails9.setAddress(customer9Address);
		accountDetails9.setCustomerDetails(customerDetails9);

		// Account 10

		AccountDetails accountDetails10 = new AccountDetails();
		AddressDetails customer10Address = new AddressDetails();
		CustomerDetails customerDetails10 = new CustomerDetails();
		accountDetails10.setAccountHolderName("Pranav Kapoor");
		accountDetails10.setAccountInterest((float) 3.5);
		customerDetails10.setCreditScore(450);
		accountDetails10.setAccountBalance(5600);
		accountDetails10.setAccountStatus("Active");
		accountDetails10.setOpeningDate(LocalDateTime.now());
		accountDetails10.setBranchdetails(branchDetails5);
		customerDetails10.setOpeningBalance(5600);
		customerDetails10.setAccountType("Savings");
		customerDetails10.setAdhaarNumber("529811148262");
		customerDetails10.setContactNumber("9115513073");
		customerDetails10.setPanNumber("APMUT4815B");
		customerDetails10.setDOB("03/10/1992");
		customerDetails10.setCustomerFirstName("Pranav");
		customerDetails10.setCustomerLastName("Kapoor");
		customerDetails10.setAge("28");
		customerDetails10.setGender("Male");
		customerDetails10.setBranchId(branchDetails5.getBranchId());
		customer10Address.setStreet("Near Ashram Marg, Jawahar Circle");
		customer10Address.setState("Rajasthan");
		customer10Address.setCity("Jaipur");
		customer10Address.setZipCode("302015");
		customerDetails10.setAddress(customer10Address);
		accountDetails10.setCustomerDetails(customerDetails10);
		customerDetails10.setAddress(customer10Address);
		accountDetails10.setCustomerDetails(customerDetails10);

		// Account 11

		AccountDetails accountDetails11 = new AccountDetails();
		AddressDetails customer11Address = new AddressDetails();
		CustomerDetails customerDetails11 = new CustomerDetails();
		accountDetails11.setAccountHolderName("Abhay Sonkhla");
		accountDetails11.setAccountInterest((float) 3.5);
		customerDetails11.setCreditScore(700);
		accountDetails11.setAccountBalance(7000);
		accountDetails11.setAccountStatus("Active");
		accountDetails11.setOpeningDate(LocalDateTime.now());
		accountDetails11.setBranchdetails(branchDetails4);
		customerDetails11.setOpeningBalance(7000);
		customerDetails11.setAccountType("Savings");
		customerDetails11.setAdhaarNumber("444422227878");
		customerDetails11.setContactNumber("9882522687");
		customerDetails11.setPanNumber("AHSGI7857F");
		customerDetails11.setDOB("19/05/1998");
		customerDetails11.setCustomerFirstName("Abhay");
		customerDetails11.setCustomerLastName("Sonkhla");
		customerDetails11.setAge("21");
		customerDetails11.setGender("Male");
		customerDetails11.setBranchId(branchDetails4.getBranchId());
		customer11Address.setStreet("529,PWD Colony Near Lohna Estate");
		customer11Address.setState("Himachal Pardesh");
		customer11Address.setCity("Palampur");
		customer11Address.setZipCode("170091");
		customerDetails11.setAddress(customer11Address);
		accountDetails11.setCustomerDetails(customerDetails11);

//      Account 12

		AccountDetails accountDetails12 = new AccountDetails();
		AddressDetails customer12Address = new AddressDetails();
		CustomerDetails customerDetails12 = new CustomerDetails();
		accountDetails12.setAccountHolderName("Sujey Singh");
		accountDetails12.setAccountInterest((float) 3);
		customerDetails12.setCreditScore(718);
		accountDetails12.setAccountBalance(500);
		accountDetails12.setAccountStatus("Active");
		accountDetails12.setOpeningDate(LocalDateTime.now());
		accountDetails12.setBranchdetails(branchDetails4);
		customerDetails12.setOpeningBalance(5000);
		customerDetails12.setAccountType("Current");
		customerDetails12.setAdhaarNumber("7899812376262");
		customerDetails12.setContactNumber("7389881849");
		customerDetails12.setPanNumber("PJKLQ7567D");
		customerDetails12.setDOB("19/09/1997");
		customerDetails12.setCustomerFirstName("Sujey");
		customerDetails12.setCustomerLastName("Singh");
		customerDetails12.setAge("22");
		customerDetails12.setGender("Male");
		customerDetails12.setBranchId(branchDetails4.getBranchId());
		customer12Address.setStreet("423,Ghai Nagar Colony");
		customer12Address.setState("Madhya Pardesh");
		customer12Address.setCity("Bhopal");
		customer12Address.setZipCode("140038");
		customerDetails12.setAddress(customer12Address);
		accountDetails12.setCustomerDetails(customerDetails12);

		// Account 13

		AccountDetails accountDetails13 = new AccountDetails();
		AddressDetails customer13Address = new AddressDetails();
		CustomerDetails customerDetails13 = new CustomerDetails();
		accountDetails13.setAccountHolderName("Dripti Sinha");
		accountDetails13.setAccountInterest((float) 3.5);
		customerDetails13.setCreditScore(800);
		accountDetails13.setAccountBalance(8000);
		accountDetails13.setAccountStatus("Active");
		accountDetails13.setOpeningDate(LocalDateTime.now());
		accountDetails13.setBranchdetails(branchDetails4);
		customerDetails13.setOpeningBalance(8000);
		customerDetails13.setAccountType("Savings");
		customerDetails13.setAdhaarNumber("451378689911");
		customerDetails13.setContactNumber("9814098995");
		customerDetails13.setPanNumber("KILAK6501W");
		customerDetails13.setDOB("23/06/1998");
		customerDetails13.setCustomerFirstName("Dripti");
		customerDetails13.setCustomerLastName("Sinha");
		customerDetails13.setAge("21");
		customerDetails13.setGender("Female");
		customerDetails13.setBranchId(branchDetails4.getBranchId());
		customer13Address.setStreet("989,G.T.B Nagar Road");
		customer13Address.setState("Punjab");
		customer13Address.setCity("Jalandhar");
		customer13Address.setZipCode("140001");
		customerDetails13.setAddress(customer13Address);
		accountDetails13.setCustomerDetails(customerDetails13);

		// Account 14

		AccountDetails accountDetails14 = new AccountDetails();
		AddressDetails customer14Address = new AddressDetails();
		CustomerDetails customerDetails14 = new CustomerDetails();
		accountDetails14.setAccountHolderName("Renu Huria");
		accountDetails14.setAccountInterest((float) 3);
		customerDetails14.setCreditScore(100);
		accountDetails14.setAccountBalance(8500);
		accountDetails14.setAccountStatus("Active");
		accountDetails14.setOpeningDate(LocalDateTime.now());
		accountDetails14.setBranchdetails(branchDetails2);

		customerDetails14.setOpeningBalance(8500);
		customerDetails14.setAccountType("Current");
		customerDetails14.setAdhaarNumber("542300996677");
		customerDetails14.setContactNumber("7896541326");
		customerDetails14.setPanNumber("POJSH5765J");
		customerDetails14.setDOB("03/06/1998");
		customerDetails14.setCustomerFirstName("Renu");
		customerDetails14.setCustomerLastName("Huria");
		customerDetails14.setAge("21");
		customerDetails14.setGender("Female");
		customerDetails14.setBranchId(branchDetails2.getBranchId());
		customer14Address.setStreet("514,New Kartar Colony Model Town");
		customer14Address.setState("Punjab");
		customer14Address.setCity("Jalandhar");
		customer14Address.setZipCode("140008");
		customerDetails14.setAddress(customer14Address);
		accountDetails14.setCustomerDetails(customerDetails14);

		// Account 15

		AccountDetails accountDetails15 = new AccountDetails();
		AddressDetails customer15Address = new AddressDetails();
		CustomerDetails customerDetails15 = new CustomerDetails();
		accountDetails15.setAccountHolderName("Manoj Kumar Meena");
		accountDetails15.setAccountInterest((float) 3.5);
		customerDetails15.setCreditScore(900);
		accountDetails15.setAccountBalance(5000);
		accountDetails15.setAccountStatus("Active");
		accountDetails15.setOpeningDate(LocalDateTime.now());
		accountDetails15.setBranchdetails(branchDetails1);

		customerDetails15.setOpeningBalance(5000);
		customerDetails15.setAccountType("Savings");
		customerDetails15.setAdhaarNumber("514198236151");
		customerDetails15.setContactNumber("8146409991");
		customerDetails15.setPanNumber("AHKLG7605J");
		customerDetails15.setDOB("05/05/1998");
		customerDetails15.setCustomerFirstName("Manoj Kumar");
		customerDetails15.setCustomerLastName("Meena");
		customerDetails15.setAge("21");
		customerDetails15.setGender("Male");
		customerDetails15.setBranchId(branchDetails1.getBranchId());
		customer15Address.setStreet("152,Zinc Colony Hurda");
		customer15Address.setState("Rajasthan");
		customer15Address.setCity("Bhilwara");
		customer15Address.setZipCode("311002");
		customerDetails15.setAddress(customer15Address);
		accountDetails15.setCustomerDetails(customerDetails15);

		// Account 16

		AccountDetails accountDetails16 = new AccountDetails();
		AddressDetails customer16Address = new AddressDetails();
		CustomerDetails customerDetails16 = new CustomerDetails();
		accountDetails16.setAccountHolderName("Anjali Singh");
		accountDetails16.setAccountInterest((float) 3.5);
		customerDetails16.setCreditScore(800);
		accountDetails16.setAccountBalance(7500);
		accountDetails16.setAccountStatus("Active");
		accountDetails16.setOpeningDate(LocalDateTime.now());
		accountDetails16.setBranchdetails(branchDetails5);

		customerDetails16.setOpeningBalance(7500);
		customerDetails16.setAccountType("Savings");
		customerDetails16.setAdhaarNumber("666787689142");
		customerDetails16.setContactNumber("8210123908");
		customerDetails16.setPanNumber("TVBGA8376Y");
		customerDetails16.setDOB("23/06/1997");
		customerDetails16.setCustomerFirstName("Anjali");
		customerDetails16.setCustomerLastName("Singh");
		customerDetails16.setAge("22");
		customerDetails16.setGender("Female");
		customerDetails16.setBranchId(branchDetails5.getBranchId());
		customer16Address.setStreet("55,Shastri Market Road");
		customer16Address.setState("Bihar");
		customer16Address.setCity("Dhanbaad");
		customer16Address.setZipCode("100451");
		customerDetails16.setAddress(customer16Address);
		accountDetails16.setCustomerDetails(customerDetails16);

		// Account 17

		AccountDetails accountDetails17 = new AccountDetails();
		AddressDetails customer17Address = new AddressDetails();
		CustomerDetails customerDetails17 = new CustomerDetails();
		accountDetails17.setAccountHolderName("Ayush Chaudhary");
		accountDetails17.setAccountInterest((float) 3);
		customerDetails17.setCreditScore(450);
		accountDetails17.setAccountBalance(6000);
		accountDetails17.setAccountStatus("Active");
		accountDetails17.setOpeningDate(LocalDateTime.now());
		accountDetails17.setBranchdetails(branchDetails4);

		customerDetails17.setOpeningBalance(6000);
		customerDetails17.setAccountType("Current");
		customerDetails17.setAdhaarNumber("891881718181");
		customerDetails17.setContactNumber("9557102414");
		customerDetails17.setPanNumber("TREHA8786Y");
		customerDetails17.setDOB("06/06/1997");
		customerDetails17.setCustomerFirstName("Ayush");
		customerDetails17.setCustomerLastName("Chaudhary");
		customerDetails17.setAge("22");
		customerDetails17.setGender("Male");
		customerDetails17.setBranchId(branchDetails4.getBranchId());
		customer17Address.setStreet("613,Austin Town Market");
		customer17Address.setState("Uttar Pradesht");
		customer17Address.setCity("Meerut");
		customer17Address.setZipCode("144001");
		customerDetails17.setAddress(customer17Address);
		accountDetails17.setCustomerDetails(customerDetails17);

		// Account 18

		AccountDetails accountDetails18 = new AccountDetails();
		AddressDetails customer18Address = new AddressDetails();
		CustomerDetails customerDetails18 = new CustomerDetails();
		accountDetails18.setAccountHolderName("Praveen Chaturvedi");
		accountDetails18.setAccountInterest((float) 3.5);
		customerDetails18.setCreditScore(780);
		accountDetails18.setAccountBalance(60000);
		accountDetails18.setAccountStatus("Active");
		accountDetails18.setOpeningDate(LocalDateTime.now());
		accountDetails18.setBranchdetails(branchDetails5);

		customerDetails18.setOpeningBalance(60000);
		customerDetails18.setAccountType("Savings");
		customerDetails18.setAdhaarNumber("819817852020");
		customerDetails18.setContactNumber("8004285698");
		customerDetails18.setPanNumber("HWTUY3440L");
		customerDetails18.setDOB("21/08/1958");
		customerDetails18.setCustomerFirstName("Praveen");
		customerDetails18.setCustomerLastName("Chaturvedi");
		customerDetails18.setAge("52");
		customerDetails18.setGender("Male");
		customerDetails18.setBranchId(branchDetails5.getBranchId());
		customer18Address.setStreet("6-1-2 Shivaji Building");
		customer18Address.setState("Karnataka");
		customer18Address.setCity("Banglore");
		customer18Address.setZipCode("462310");
		customerDetails18.setAddress(customer18Address);
		accountDetails18.setCustomerDetails(customerDetails18);

		// Account 19

		AccountDetails accountDetails19 = new AccountDetails();
		AddressDetails customer19Address = new AddressDetails();
		CustomerDetails customerDetails19 = new CustomerDetails();
		accountDetails19.setAccountHolderName("Subhadra Yadav");
		accountDetails19.setAccountInterest((float) 3.5);
		customerDetails19.setCreditScore(900);
		accountDetails19.setAccountBalance(8000);
		accountDetails19.setAccountStatus("Active");
		accountDetails19.setOpeningDate(LocalDateTime.now());
		accountDetails19.setBranchdetails(branchDetails1);

		customerDetails19.setOpeningBalance(8000);
		customerDetails19.setAccountType("Savings");
		customerDetails19.setAdhaarNumber("202952031900");
		customerDetails19.setContactNumber("9458585698");
		customerDetails19.setPanNumber("WQASD0909I");
		customerDetails19.setDOB("01/12/1990");
		customerDetails19.setCustomerFirstName("Subhadra");
		customerDetails19.setCustomerLastName("Yadav");
		customerDetails19.setAge("30");
		customerDetails19.setGender("Female");
		customerDetails19.setBranchId(branchDetails1.getBranchId());
		customer19Address.setStreet("128,456 Mitali Nagar");
		customer19Address.setState("Uttar Pradesh");
		customer19Address.setCity("Mathura");
		customer19Address.setZipCode("206085");
		customerDetails19.setAddress(customer19Address);
		accountDetails19.setCustomerDetails(customerDetails19);

		// Account 20

		AccountDetails accountDetails20 = new AccountDetails();
		AddressDetails customer20Address = new AddressDetails();
		CustomerDetails customerDetails20 = new CustomerDetails();
		accountDetails20.setAccountHolderName("Abhimanyu Singh");
		accountDetails20.setAccountInterest((float) 3);
		customerDetails20.setCreditScore(790);
		accountDetails20.setAccountBalance(16000);
		accountDetails20.setAccountStatus("Active");
		accountDetails20.setOpeningDate(LocalDateTime.now());
		accountDetails20.setBranchdetails(branchDetails5);

		customerDetails20.setOpeningBalance(16000);
		customerDetails20.setAccountType("Current");
		customerDetails20.setAdhaarNumber("346052031900");
		customerDetails20.setContactNumber("9839800008");
		customerDetails20.setPanNumber("BHGVF3080K");
		customerDetails20.setDOB("14/11/1993");
		customerDetails20.setCustomerFirstName("Abhimanyu");
		customerDetails20.setCustomerLastName("Singh");
		customerDetails20.setAge("27");
		customerDetails20.setGender("Male");
		customerDetails20.setBranchId(branchDetails5.getBranchId());
		customer20Address.setStreet("09,Agrasen Marg");
		customer20Address.setState("Uttar Pradesh");
		customer20Address.setCity("Kanpur");
		customer20Address.setZipCode("208068");
		customerDetails20.setAddress(customer20Address);
		accountDetails20.setCustomerDetails(customerDetails20);

		daoService.insertAccountDetails(accountDetails1);
		daoService.insertAccountDetails(accountDetails2);
		daoService.insertAccountDetails(accountDetails3);
		daoService.insertAccountDetails(accountDetails4);
		daoService.insertAccountDetails(accountDetails5);
		daoService.insertAccountDetails(accountDetails6);
		daoService.insertAccountDetails(accountDetails7);
		daoService.insertAccountDetails(accountDetails8);
		daoService.insertAccountDetails(accountDetails9);
		daoService.insertAccountDetails(accountDetails10);
		daoService.insertAccountDetails(accountDetails11);
		daoService.insertAccountDetails(accountDetails12);
		daoService.insertAccountDetails(accountDetails13);
		daoService.insertAccountDetails(accountDetails14);
		daoService.insertAccountDetails(accountDetails15);
		daoService.insertAccountDetails(accountDetails16);
		daoService.insertAccountDetails(accountDetails17);
		daoService.insertAccountDetails(accountDetails18);
		daoService.insertAccountDetails(accountDetails19);
		daoService.insertAccountDetails(accountDetails20);

	}
}
