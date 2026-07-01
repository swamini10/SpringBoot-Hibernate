package com.skillio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillio.model.AccountDetailsDTO;
import com.skillio.model.User;
import com.skillio.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository ur;

	public User addUser(User user) {
		
		Random rand = new Random();
        


		boolean notUniqueAccNo = true;

		while(notUniqueAccNo) {
			int accountNo = rand.nextInt(10000);
			Optional<User> availableUser =  ur.findByAccNo(accountNo);
			
			if(!availableUser.isPresent()) {
				user.setAccNo(accountNo);
				notUniqueAccNo = false;
			}
		}
		
		user.setBalance(0);
		
		return ur.save(user);
	}

	public AccountDetailsDTO deposite(int accno, int aadhaar, int amount) {	
		Optional<User> user = ur.findByAccNo(accno);

		if(user.isPresent()) {
			
			User myData = user.get();
			String myName = myData.getFirstname() + " " + myData.getLastname();
			if(myData.getAadhar() == aadhaar) {
				
				int myBalance = myData.getBalance() + amount;
				myData.setBalance(myBalance);

				//myData.setBalance(myData.getBalance() + amount);
								
				ur.save(myData);
				
				AccountDetailsDTO add = new AccountDetailsDTO();
				
				add.setAccNo(accno);
				add.setName(myName);
				add.setBalance(myBalance);

				return add;
				
			} else {
				throw new RuntimeException("Account Number Or Aadhaar Number is not valid");
			}
		}else {
			throw new RuntimeException("User not found");
		}
		
	}

	public List<AccountDetailsDTO> allUsers() {
		
		List<AccountDetailsDTO> adds = new ArrayList<AccountDetailsDTO>();
		
		List<User> allUsers = ur.findAll();
		
		for(User user: allUsers) {
			AccountDetailsDTO add = new AccountDetailsDTO();
			add.setName(user.getFirstname() + " " + user.getLastname());
			add.setAccNo(user.getAccNo());
			add.setBalance(user.getBalance());
			adds.add(add);
		}
		
		return adds;	
	}

	public AccountDetailsDTO findUser(int accno) {
		
		AccountDetailsDTO add = new AccountDetailsDTO();
		
		Optional<User> u = ur.findByAccNo(accno);

		if(u.isPresent()) {
			add.setName(u.get().getFirstname() + " " + u.get().getLastname());
			add.setAccNo(u.get().getAccNo());
			add.setBalance(u.get().getBalance());
			return add;
		} else {
			throw new RuntimeException("User not found");
		}
	}

	public AccountDetailsDTO withdraw(int accno, int aadhaar, int amount) {
		// TODO Auto-generated method stub
		
		Optional<User> user = ur.findByAccNo(accno);

		if(user.isPresent()) {
			
			User myData = user.get();
			String myName = myData.getFirstname() + " " + myData.getLastname();
			if(myData.getAadhar() == aadhaar) {
				if(amount <= 0 || amount > myData.getBalance()) {		
					throw new RuntimeException("Please enter valid amount");
				}

				int myBalance = myData.getBalance() - amount;
				myData.setBalance(myBalance);

				//myData.setBalance(myData.getBalance() - amount);
								
				ur.save(myData);
				System.out.println(myData);
				AccountDetailsDTO add = new AccountDetailsDTO();
				
				add.setAccNo(accno);
				add.setName(myName);
				add.setBalance(myBalance);

				return add;
				
			} else {
				throw new RuntimeException("Account Number Or Aadhaar Number is not valid");
			}
		}else {
			throw new RuntimeException("User not found");
		}
	}

	public AccountDetailsDTO transfer(int accnofrom, int aadhaarfrom, int amount, int accno, int aadhaar) {
		// TODO Auto-generated method stub
		
		Optional<User> user = ur.findByAccNo(accnofrom);
		Optional<User> user2 = ur.findByAccNo(accno);
		if(user.isPresent() && user2.isPresent()) {
			
			User myData = user.get();
			User myData1 = user2.get();
			String myName = myData.getFirstname() + " " + myData.getLastname();
			String myName1 = myData1.getFirstname() + " " + myData.getLastname();
			if(myData.getAadhar() == aadhaarfrom && myData1.getAadhar() == aadhaar) {
				
				if(amount <= 0 || amount > myData.getBalance()) {
					throw new RuntimeException("Please enter valid amount");
				}
				
				int myBalance = myData.getBalance() - amount;
				myData.setBalance(myBalance);
				ur.save(myData1);
				ur.save(myData);
			
				System.out.println(myData);
				AccountDetailsDTO add = new AccountDetailsDTO();
				
				add.setAccNo(accnofrom);
				add.setName(myName);
				add.setBalance(myBalance);
					
				int updatedBalance = myData1.getBalance() + amount;
				myData1.setBalance(updatedBalance);
				
				
				return add;
				
			} else {
				throw new RuntimeException("Account Number Or Aadhaar Number is not valid");
			}
		}else {
			throw new RuntimeException("User not found");
		}
	}

	

}
