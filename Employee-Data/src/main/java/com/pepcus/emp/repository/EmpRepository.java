package com.pepcus.emp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pepcus.emp.entity.*;
@Repository
public interface EmpRepository extends JpaRepository<EmpEntity,Integer>{


}
