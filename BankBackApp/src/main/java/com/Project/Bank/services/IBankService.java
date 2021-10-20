package com.Project.Bank.services;

import java.util.List;

import com.Project.Bank.entities.Operation;


public interface IBankService {
	public void deposit(double amount);
	public void withdrawal(double amount);
	public List<Operation> listOperation();
}
