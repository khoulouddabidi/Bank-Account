package com.Project.Bank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Project.Bank.entities.Operation;



@Repository
public interface IOperationRepository extends JpaRepository<Operation, Long>{

	@Query(" From Operation o order by o.dateOperation desc")
	public List<Operation> listOperation();
	
	@Modifying
	@Query("delete from Operation")
	public void deleteOperation();
}
