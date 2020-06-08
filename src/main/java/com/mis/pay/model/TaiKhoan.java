package com.mis.pay.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tai_khoan")
public class TaiKhoan implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mataikhoan;
	private String taikhoan;
	private String matkhau;
	private String sotaikhoan;
	private int sodu;
	public int getMataikhoan() {
		return mataikhoan;
	}
	public void setMataikhoan(int mataikhoan) {
		this.mataikhoan = mataikhoan;
	}
	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	
	public String getSotaikhoan() {
		return sotaikhoan;
	}
	public void setSotaikhoan(String sotaikhoan) {
		this.sotaikhoan = sotaikhoan;
	}
	public int getSodu() {
		return sodu;
	}
	public void setSodu(int sodu) {
		this.sodu = sodu;
	}
	@Override
	public String toString() {
		return "TaiKhoan [mataikhoan=" + mataikhoan + ", taikhoan=" + taikhoan + ", matkhau=" + matkhau
				+ ", sotaikhoan=" + sotaikhoan + ", sodu=" + sodu + "]";
	}
	
}
