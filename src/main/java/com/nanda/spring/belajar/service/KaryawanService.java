package com.nanda.spring.belajar.service;

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

	public void saveApaAja(Karyawan karyawan) {
		karyawanRepository.save(karyawan);
	}

	public Karyawan getKaryawan(Long id) {
		Karyawan karyawan = karyawanRepository.findById(id).get();
		return karyawan;
	}

}
