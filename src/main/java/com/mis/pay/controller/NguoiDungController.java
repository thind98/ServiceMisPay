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

import com.mis.pay.model.NguoiDung;
import com.mis.pay.service.NguoiDungService;

public class NguoiDungController {
private NguoiDungService repo;
	
	@Autowired
	public NguoiDungController(NguoiDungService repo) 
	{
		this.repo = repo;
	}
	
	//get
	@GetMapping(path="/mpusers",produces={"application/json"})
	public ResponseEntity<List<NguoiDung>> findAllUser() {
        List<NguoiDung> user = repo.findAll();
        if (user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
	@GetMapping(path="/mpuser/{manguoidung}",produces={"application/json"})
	public ResponseEntity<NguoiDung> getUserById(
            @PathVariable("manguoidung") Integer manguoidung) {
        Optional<NguoiDung> user = repo.findById(manguoidung);

        if (!user.isPresent()) {
            return new ResponseEntity<>(user.get(),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }
	
	//post
	@PostMapping(path="/mpuser",consumes={"application/json"})
	public ResponseEntity<NguoiDung> createClub(@RequestBody NguoiDung user, UriComponentsBuilder builder) 
	{
        repo.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/mpuser/{manguoidung}")
                .buildAndExpand(user.getManguoidung()).toUri());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
	
	//put
	@PutMapping(value = "/mpuser/{manguoidung}")
	public ResponseEntity<NguoiDung> updateClub(@PathVariable("manguoidung") Integer manguoidung, @RequestBody NguoiDung user) 
	{
        Optional<NguoiDung> currentUser = repo.findById(manguoidung);

        if (!currentUser.isPresent()) 
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        currentUser.get().setManguoidung(user.getManguoidung());
        currentUser.get().setTennguoidung(user.getTennguoidung());
        currentUser.get().setGioitinh(user.getGioitinh());
        currentUser.get().setEmail(user.getEmail());
        currentUser.get().setDiachi(user.getDiachi());
        currentUser.get().setHinhanh(user.getHinhanh());
        currentUser.get().setSdt(user.getSdt());
        currentUser.get().setLoai(user.getLoai());
        currentUser.get().setTrangthai(user.getTrangthai());
        currentUser.get().setMataikhoanMM(user.getMataikhoan());

        repo.save(currentUser.get());
        return new ResponseEntity<>(currentUser.get(), HttpStatus.OK);
    }
	
	//delete
	@DeleteMapping(value = "/mpuser/{manguoidung}")
    public ResponseEntity<NguoiDung> deleteUser(@PathVariable("manguoidung") Integer manguoidung) 
	{
        Optional<NguoiDung> user = repo.findById(manguoidung);
        if (!user.isPresent()) 
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repo.remove(user.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
