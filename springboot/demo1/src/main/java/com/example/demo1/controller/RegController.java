package com.example.demo1.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.model.Reg;
import com.example.demo1.service.RegService;


@RestController
public class RegController {
    @Autowired
    RegService ms;
    @PostMapping("api/product")
    public ResponseEntity<Reg>addelements(@RequestBody Reg m)
    {
        Reg mm=ms.create(m);
        return new ResponseEntity<>(mm,HttpStatus.CREATED);
    }
    @GetMapping("/api/products")
    public ResponseEntity<List<Reg>> showinfo()
    {
        return new ResponseEntity<>(ms.getAll(),HttpStatus.OK);
    }
    @GetMapping("/api/product/{productId}")
    public ResponseEntity<Reg> getById(@PathVariable Integer productId)
    {
        Reg obj=ms.getMe(productId);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @PutMapping("/api/product/{productId}")
    public ResponseEntity<Reg> putMethodName(@PathVariable("productId") int id, @RequestBody Reg m) {
        if(ms.updateDetails(id,m) == true)
        {
            return new ResponseEntity<>(m,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/api/product/{productId}")
    public ResponseEntity<Boolean> delete(@PathVariable("productId") int id)
    {
        if(ms.deleteProduct(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/api/product/sortBy/{field}")
    public List<Reg> g(@PathVariable String field)
    {
        return ms.sort(field);
    }
    @GetMapping("/api/product/{offset}/{pagesize}/{field}")
    public List<Reg> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        return ms.getsort(offset,pagesize,field);
    }
    @GetMapping("/api/product/{offset}/{pagesize}")
    public List<Reg> get(@PathVariable int offset,@PathVariable int pagesize)
    {
        return ms.page(pagesize, offset);
    }
    @GetMapping("/query/{custName}")
    public ResponseEntity<Reg> findCustByName(@PathVariable String custName) 
    {
        Reg sh = ms.findCustByName(custName);
        try{
            return new ResponseEntity<>(sh,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(sh,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
