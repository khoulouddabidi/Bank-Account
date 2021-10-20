package com.Project.Bank.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Operation  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private Long numero;
	private Date dateOperation;
	private double amount;
	@Column(name = "type_op")
	private String type_op;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType_op() {
		return type_op;
	}
	public void setType_op(String type_op) {
		this.type_op = type_op;
	}
	
	
	
	
	public Operation() {
		super();
		
	}
	
	public Operation(Date dateOperation, double amount) {
		super();
		
		this.dateOperation = dateOperation;
		this.amount = amount;
	}


	
	
	
	

}
