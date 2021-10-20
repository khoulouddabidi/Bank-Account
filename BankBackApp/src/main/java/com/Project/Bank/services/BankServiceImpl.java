package com.Project.Bank.services;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Bank.entities.DepositTransfer;
import com.Project.Bank.entities.Operation;
import com.Project.Bank.entities.Withdrawal;
import com.Project.Bank.repositories.IOperationRepository;

@Service
@Transactional
public class BankServiceImpl implements IBankService {

	@Autowired
	private IOperationRepository operationRepository;

	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		DepositTransfer depositTransfer = new DepositTransfer(new Date(), amount);
		operationRepository.save(depositTransfer);
		
	}

	@Override
	public void withdrawal(double amount) {
		Withdrawal withdrawal = new Withdrawal(new Date(), amount);
		operationRepository.save(withdrawal);		
	}

	@Override
	public List<Operation> listOperation() {
		return operationRepository.listOperation();
	}

	

}
