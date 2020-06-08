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

import com.mis.pay.service.GiaoDichService;
import com.mis.pay.model.GiaoDich;

public class GiaoDichController 
{
	private GiaoDichService repo;
	
	@Autowired
	public GiaoDichController(GiaoDichService repo)
	{
		this.repo = repo;
	}
	//get
	@GetMapping(path="/mptrans",produces={"application/json"})
	public ResponseEntity<List<GiaoDich>> findAllacc() {
        List<GiaoDich> acc = repo.findAll();
        if (acc.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(acc, HttpStatus.OK);
    }
	@GetMapping(path="/mptran/{magiaodich}",produces={"application/json"})
	public ResponseEntity<GiaoDich> getaccById(
            @PathVariable("magiaodich") Integer magiaodich) {
        Optional<GiaoDich> acc = repo.findById(magiaodich);

        if (!acc.isPresent()) {
            return new ResponseEntity<>(acc.get(),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(acc.get(), HttpStatus.OK);
    }
	
	//post
	@PostMapping(path="/mptran",consumes={"application/json"})
	public ResponseEntity<GiaoDich> createClub(@RequestBody GiaoDich gd, UriComponentsBuilder builder) 
	{
        repo.save(gd);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/mptran/{magiaodich}")
                .buildAndExpand(gd.getMagiaodich()).toUri());
        return new ResponseEntity<>(gd, HttpStatus.CREATED);
    }
	
	//put
	@PutMapping(value = "/mptran/{magiaodich}")
	public ResponseEntity<GiaoDich> updateClub(@PathVariable("magiaodich") Integer magiaodich, @RequestBody GiaoDich acc) 
	{
        Optional<GiaoDich> currentacc = repo.findById(magiaodich);

        if (!currentacc.isPresent()) 
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        currentacc.get().setMagiaodich(acc.getMagiaodich());
        currentacc.get().setTaikhoannhan(acc.getTaikhoannhan());
        currentacc.get().setThoigiangiaodich(acc.getThoigiangiaodich());
        currentacc.get().setNoidung(acc.getNoidung());

        repo.save(currentacc.get());
        return new ResponseEntity<>(currentacc.get(), HttpStatus.OK);
    }
	
	//delete
	@DeleteMapping(value = "/mptran/{magiaodich}")
    public ResponseEntity<GiaoDich> deleteacc(@PathVariable("magiaodich") Integer magiaodich) 
	{
        Optional<GiaoDich> acc = repo.findById(magiaodich);
        if (!acc.isPresent()) 
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repo.remove(acc.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
