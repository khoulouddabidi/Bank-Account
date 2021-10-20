package com.Project.Bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Project.Bank.entities.Operation;
import com.Project.Bank.services.IBankService;

@RunWith(SpringRunner.class)
@SpringBootTest
class BankApplicationTests {

	@Autowired
	private IBankService bankService;

	@Before
	public void initTests() {
		

	}

	@Test
	public void testDeposit() {

		
		double amount = 200;
		bankService.deposit(amount);
		//select operations
		List<Operation> list = bankService.listOperation();
		assertTrue(list.size() == 1);
		Operation op = list.get(0);
		assertTrue(op.getAmount() == amount);
		assertTrue(op.getType_op().equals("D"));
		

	}

	@Test
	public void testWithdrawal() {
		double amount = 100;
		bankService.withdrawal(amount);
		//select operations
		List<Operation> list = bankService.listOperation();
		assertTrue(list.size() == 1);
		Operation op = list.get(0);
		assertTrue(op.getAmount() == amount);
		assertTrue(op.getType_op().equals("W"));

	}

	@Test
	public void testListOperation() {
		
		//add operation
		bankService.deposit(5000);
		bankService.withdrawal(500);
		bankService.withdrawal(500);
		//list all operations
		List<Operation> list = bankService.listOperation();
		assertEquals(3, list.size());

	}
	
}
