package com.mis.pay.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.mis.pay.model.TaiKhoan;
import com.mis.pay.service.TaiKhoanService;

public class TaiKhoanController 
{
	private TaiKhoanService repo;
	
	@Autowired
	public TaiKhoanController(TaiKhoanService repo) 
	{
		this.repo = repo;
	}
	
	//get
	@GetMapping(path="/mpaccs",produces={"application/json"})
	public ResponseEntity<List<TaiKhoan>> findAllacc() {
        List<TaiKhoan> acc = repo.findAll();
        if (acc.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(acc, HttpStatus.OK);
    }
	@GetMapping(path="/mpacc/{mataikhoan}",produces={"application/json"})
	public ResponseEntity<TaiKhoan> getaccById(
            @PathVariable("mataikhoan") Integer mataikhoan) {
        Optional<TaiKhoan> acc = repo.findById(mataikhoan);

        if (!acc.isPresent()) {
            return new ResponseEntity<>(acc.get(),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(acc.get(), HttpStatus.OK);
    }
	
	//post
	@PostMapping(path="/mpacc",consumes={"application/json"})
	public ResponseEntity<TaiKhoan> createClub(@RequestBody TaiKhoan acc, UriComponentsBuilder builder) 
	{
        repo.save(acc);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/mpacc/{mataikhoan}")
                .buildAndExpand(acc.getMataikhoan()).toUri());
        return new ResponseEntity<>(acc, HttpStatus.CREATED);
    }
	
	//put
	@PutMapping(value = "/mpacc/{mataikhoan}")
	public ResponseEntity<TaiKhoan> updateClub(@PathVariable("mataikhoan") Integer mataikhoan, @RequestBody TaiKhoan acc) 
	{
        Optional<TaiKhoan> currentacc = repo.findById(mataikhoan);

        if (!currentacc.isPresent()) 
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        currentacc.get().setMataikhoan(acc.getMataikhoan());
        currentacc.get().setTaikhoan(acc.getTaikhoan());
        currentacc.get().setMatkhau(acc.getMatkhau());
        currentacc.get().setSotaikhoan(acc.getSotaikhoan());
        currentacc.get().setSodu(acc.getSodu());

        repo.save(currentacc.get());
        return new ResponseEntity<>(currentacc.get(), HttpStatus.OK);
    }
	
	//delete
	@DeleteMapping(value = "/mpacc/{mataikhoan}")
    public ResponseEntity<TaiKhoan> deleteacc(@PathVariable("mataikhoan") Integer mataikhoan) 
	{
        Optional<TaiKhoan> acc = repo.findById(mataikhoan);
        if (!acc.isPresent()) 
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repo.remove(acc.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
