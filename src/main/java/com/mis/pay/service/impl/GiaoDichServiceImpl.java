package com.mis.pay.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mis.pay.service.GiaoDichService;
import com.mis.pay.dao.GiaoDichRepo;
import com.mis.pay.model.GiaoDich;

@Service
public class GiaoDichServiceImpl implements GiaoDichService
{
	private GiaoDichRepo repo;
	
	@Autowired
	public GiaoDichServiceImpl(GiaoDichRepo repo) 
	{
		this.repo = repo;
	}

	@Override
	public List<GiaoDich> findAll() {
		return (List<GiaoDich>) repo.findAll();
	}

	@Override
	public Optional<GiaoDich> findById(Integer id) {
		return (Optional<GiaoDich>) repo.findById(id);
	}

	@Override
	public void save(GiaoDich gd) {
		repo.save(gd);
	}

	@Override
	public void remove(GiaoDich gd) {
		repo.delete(gd);
	}
}
