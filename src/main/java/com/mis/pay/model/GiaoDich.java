package com.mis.pay.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "giao_dich")
public class GiaoDich implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int magiaodich;
	private int taikhoannhan;
	private String thoigiangiaodich;
	private String noidung;
	public int getMagiaodich() {
		return magiaodich;
	}
	public void setMagiaodich(int magiaodich) {
		this.magiaodich = magiaodich;
	}
	public int getTaikhoannhan() {
		return taikhoannhan;
	}
	public void setTaikhoannhan(int taikhoannhan) {
		this.taikhoannhan = taikhoannhan;
	}
	public String getThoigiangiaodich() {
		return thoigiangiaodich;
	}
	public void setThoigiangiaodich(String thoigiangiaodich) {
		this.thoigiangiaodich = thoigiangiaodich;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	@Override
	public String toString() {
		return "GiaoDich [magiaodich=" + magiaodich + ", taikhoannhan=" + taikhoannhan + ", thoigiangiaodich="
				+ thoigiangiaodich + ", noidung=" + noidung + "]";
	}
		
}
