package com.Project.Bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Bank.entities.DepositTransfer;
import com.Project.Bank.entities.Operation;
import com.Project.Bank.entities.Withdrawal;
import com.Project.Bank.services.IBankService;
@CrossOrigin(origins = "*") 
@RestController
@RequestMapping(value = "/services")
public class ServiceBankController {

	@Autowired
	private IBankService bankService;
	
	
	
	
	// http://localhost:8080/services/deposit
	@RequestMapping(value = "/deposit", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> deposit(@RequestBody DepositTransfer operation) {
		try {
			double amount = operation.getAmount();
			bankService.deposit(amount);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	
	// http://localhost:8080/services/withdrawal
	@RequestMapping(value = "/withdrawal", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> withdrawal(@RequestBody Withdrawal operation) {
		try {
			double amount = operation.getAmount();
			bankService.withdrawal(amount);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/operations", method = RequestMethod.GET)
	public ResponseEntity<List<Operation>> listOperation(){
		
		List<Operation> operations=null;
		try {
			operations = bankService.listOperation();
		} catch (Exception e) {
			return new ResponseEntity<List<Operation>>(operations, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Operation>>(operations, HttpStatus.OK);
		
	}
	
	
	
}
