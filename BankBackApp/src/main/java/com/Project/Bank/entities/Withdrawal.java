package com.Project.Bank.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;


@Entity
public class Withdrawal  extends Operation{

	public Withdrawal(Date dateOperation, double amount) {
		super(dateOperation, amount);
		
	}

	public Withdrawal() {
		super();
		
	}

	
	
}
