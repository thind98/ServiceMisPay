package com.mis.pay.service;

import java.util.List;
import java.util.Optional;

import com.mis.pay.model.NguoiDung;

public interface NguoiDungService {
	List<NguoiDung> findAll();
    Optional<NguoiDung> findById(Integer id);
    void save(NguoiDung user);
    void remove(NguoiDung user);
}
