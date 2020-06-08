package com.mis.pay.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mis.pay.dao.NguoiDungRepo;
import com.mis.pay.model.NguoiDung;
import com.mis.pay.service.NguoiDungService;

public class NguoiDungServiceImpl implements NguoiDungService
{

	private NguoiDungRepo repo;
	
	@Autowired
	public NguoiDungServiceImpl(NguoiDungRepo repo) 
	{
		this.repo = repo;
	}
	@Override
	public List<NguoiDung> findAll() 
	{
		return (List<NguoiDung>) repo.findAll();
	}

	@Override
	public Optional<NguoiDung> findById(Integer id) 
	{
		return (Optional<NguoiDung>) repo.findById(id);
	}

	@Override
	public void save(NguoiDung user) 
	{
		repo.save(user);
	}

	@Override
	public void remove(NguoiDung user) 
	{
		repo.delete(user);
	}

}
