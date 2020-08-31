package com.nanda.spring.belajar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "karyawan")
public class Karyawan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 20, unique = true, nullable = false)
	private Long id;

	@Column(name = "namakaryawan", length = 250)
	private String namakaryawan;

	@Column(name = "alamat", length = 250)
	private String alamat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamakaryawan() {
		return namakaryawan;
	}

	public void setNamakaryawan(String namakaryawan) {
		this.namakaryawan = namakaryawan;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

}
