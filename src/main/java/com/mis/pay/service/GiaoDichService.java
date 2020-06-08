package com.mis.pay.service;

import java.util.List;
import java.util.Optional;

import com.mis.pay.model.GiaoDich;

public interface GiaoDichService {
	List<GiaoDich> findAll();
    Optional<GiaoDich> findById(Integer id);
    void save(GiaoDich gd);
    void remove(GiaoDich gd);
}
