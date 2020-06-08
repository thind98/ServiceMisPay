package com.mis.pay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mis.pay.model.NguoiDung;

public interface NguoiDungRepo extends JpaRepository<NguoiDung, Integer>
{

}
