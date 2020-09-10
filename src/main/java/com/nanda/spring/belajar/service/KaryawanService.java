package com.nanda.spring.belajar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nanda.spring.belajar.entity.Karyawan;
import com.nanda.spring.belajar.repository.KaryawanRepository;

@Service
public class KaryawanService {

	@Autowired
	private KaryawanRepository karyawanRepository;

	public Page<Karyawan> listAllKaryawan() {
		Pageable pageable = PageRequest.of(0, 1000);
		Page<Karyawan> page = karyawanRepository.findAll(pageable);
		return page;
	}

	public Page<Karyawan> searchKaryawan(String namakaryawan) {
		namakaryawan = namakaryawan != null && !namakaryawan.isEmpty() ? "%" + namakaryawan + "%" : "%";
		System.out.println("service nama karyawan : " + namakaryawan);
		Pageable pageable = PageRequest.of(0, 1000);
		Page<Karyawan> page = karyawanRepository.searchNamaKaryawan(namakaryawan, pageable);
		return page;
	}

	public Karyawan getKaryawan(Long id) {
		Karyawan karyawan = karyawanRepository.findById(id).get();
		return karyawan;
	}

	public List<String> listNamaKaryawan() {
		return karyawanRepository.listNamaKaryawan();
	}

	public void save(Karyawan karyawan) {
		karyawanRepository.save(karyawan);
	}

	public void delete(Karyawan karyawan) {
		karyawanRepository.delete(karyawan);
	}

}
