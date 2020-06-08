package com.mis.pay.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nguoi_dung")
public class NguoiDung implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int manguoidung;
	private String tennguoidung;
	private String gioitinh;
	private String email;
	private String diachi;
	private String hinhanh;
	private String sdt;
	private String loai;
	private String trangthai;
	private int mataikhoan;
	
	public int getManguoidung() {
		return manguoidung;
	}
	public void setManguoidung(int manguoidung) {
		this.manguoidung = manguoidung;
	}
	public String getTennguoidung() {
		return tennguoidung;
	}
	public void setTennguoidung(String tennguoidung) {
		this.tennguoidung = tennguoidung;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public int getMataikhoan() {
		return mataikhoan;
	}
	public void setMataikhoanMM(int mataikhoanMM) {
		this.mataikhoan = mataikhoanMM;
	}
	@Override
	public String toString() {
		return "NguoiDung [manguoidung=" + manguoidung + ", tennguoidung=" + tennguoidung + ", gioitinh=" + gioitinh
				+ ", email=" + email + ", diachi=" + diachi + ", hinhanh=" + hinhanh + ", sdt=" + sdt + ", loai=" + loai
				+ ", trangthai=" + trangthai + ", mataikhoanMM=" + mataikhoan + "]";
	}
}
