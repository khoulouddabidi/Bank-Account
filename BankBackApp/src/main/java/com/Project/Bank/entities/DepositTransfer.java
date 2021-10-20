package com.Project.Bank.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class DepositTransfer  extends Operation{

	public DepositTransfer() {
		super();
		
	}

	public DepositTransfer(Date dateOperation, double amount) {
		super(dateOperation, amount);
		
	}
}
