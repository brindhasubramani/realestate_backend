package com.example.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo1.model.Reg;
import com.example.demo1.repository.RegRepo;
@Service
public class RegService {
    @Autowired
    RegRepo mr;
    public Reg create (Reg mm)
    {
        return mr.save(mm);
    }
    public List<Reg> getAll()
    {
        return mr.findAll();
    }
    public Reg getMe(int id)
    {
        return mr.findById(id).orElse(null);
    }
    public boolean updateDetails(int id,Reg mm)
        {
            if(this.getMe(id)==null)
            {
                return false;
            }
            try{
                mr.save(mm);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
public boolean deleteProduct(int id)
        {
            if(this.getMe(id) == null)
            {
                return false;
            }
            mr.deleteById(id);
            return true;
        }
        public List<Reg> sort(String field){
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return mr.findAll(sort);
    }
    public List<Reg> getsort(int pageNumber,int pageSize,String field){
        return mr.findAll(PageRequest.of(pageNumber, pageSize)
        .withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
  
    }
    public List<Reg> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber, pageSize);
        return mr.findAll(page).getContent();
    }
    public Reg findCustByName(String custName) {
        return mr.findCustByName(custName);
    }

}
