package com.skillio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillio.model.AccountDetailsDTO;
import com.skillio.model.User;
import com.skillio.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService us;
	
	@PostMapping("/add-user")
	public User addUser(@RequestBody User user) {
		return us.addUser(user);
	}
	
	@PutMapping("/deposite")
	public AccountDetailsDTO deposite(@RequestParam("accno") int accno, 
									  @RequestParam("aadhaar") int aadhaar, 
									  @RequestParam("amount") int amount) {
		
		return us.deposite(accno, aadhaar, amount);
	}
	
	@PutMapping("/withdraw")
	public AccountDetailsDTO withdraw(@RequestParam("accno") int accno, 
									  @RequestParam("aadhaar") int aadhaar, 
									  @RequestParam("amount") int amount) {
		
		return us.withdraw(accno, aadhaar, amount);
	}
	
	@PutMapping("/transfer")
	public AccountDetailsDTO transfer(@RequestParam("accnofrom") int accnofrom, 
									  @RequestParam("aadhaarfrom") int aadhaarfrom, 
									  @RequestParam("amount") int amount,
									  @RequestParam("accno") int accno, 
									  @RequestParam("aadhaar") int aadhaar) {
		
		return us.transfer(accnofrom,aadhaarfrom,amount,accno, aadhaar);
	}
	
	
	
	
	
	@GetMapping("/users")
	public List<AccountDetailsDTO> allUsers() {
		return us.allUsers();
	}
	
	@GetMapping("/user/{accno}")
	public AccountDetailsDTO findUser(@PathVariable("accno") int accno) {
		return us.findUser(accno);
	}
	
}
