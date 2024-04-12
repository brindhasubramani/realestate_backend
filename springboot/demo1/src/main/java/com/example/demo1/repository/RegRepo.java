package com.example.demo1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo1.model.Reg;
public interface RegRepo extends JpaRepository<Reg,Integer>{
    @Query("SELECT s FROM Reg s WHERE s.custName = :custName")
    Reg findCustByName(@RequestParam("custName") String custName);
    
}

