package com.mis.pay.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mis.pay.dao.TaiKhoanRepo;
import com.mis.pay.model.TaiKhoan;
import com.mis.pay.service.TaiKhoanService;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService{

	private TaiKhoanRepo repo;
	
	@Autowired
	public TaiKhoanServiceImpl(TaiKhoanRepo repo) 
	{
		this.repo = repo;
	}

	@Override
	public List<TaiKhoan> findAll() {
		return (List<TaiKhoan>) repo.findAll();
	}

	@Override
	public Optional<TaiKhoan> findById(Integer id) {
		return (Optional<TaiKhoan>) repo.findById(id);
	}

	@Override
	public void save(TaiKhoan tk) {
		repo.save(tk);
	}

	@Override
	public void remove(TaiKhoan tk) {
		repo.delete(tk);
	}
	

}
