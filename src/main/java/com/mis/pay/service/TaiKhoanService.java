package com.mis.pay.service;

import java.util.List;
import java.util.Optional;

import com.mis.pay.model.TaiKhoan;

public interface TaiKhoanService {
	List<TaiKhoan> findAll();
    Optional<TaiKhoan> findById(Integer id);
    void save(TaiKhoan tk);
    void remove(TaiKhoan tk);
}
