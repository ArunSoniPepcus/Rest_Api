package com.pepcus.emp.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pepcus.emp.entity.EmpEntity;
import com.pepcus.emp.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository repo;
	
	public void addEmp(EmpEntity empData)
	{
		repo.save(empData);

	}
	public List<EmpEntity> getAllEmp(){
		return repo.findAll();
	}
	public EmpEntity getEmpById(int id) {
		Optional<EmpEntity> e = repo.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	public void deleteEMp(int id) {
		repo.deleteById(id);
	}

}
