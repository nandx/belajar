package com.nanda.spring.belajar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nanda.spring.belajar.entity.Karyawan;
import com.nanda.spring.belajar.service.KaryawanService;

@RestController
public class KaryawanRestController {

	@Autowired
	private KaryawanService karyawanService;

	@RequestMapping(value = "/rest/karyawan", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Karyawan>> restKaryawan() {
		Page<Karyawan> page = karyawanService.listAllKaryawan();
		List<Karyawan> list = page.getContent();
		return new ResponseEntity<List<Karyawan>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/karyawan/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Karyawan>> search(@RequestParam(name = "keyword", required = false) String paramnama) {
		Page<Karyawan> page = karyawanService.searchKaryawan(paramnama);
		List<Karyawan> list = page.getContent();
		return new ResponseEntity<List<Karyawan>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/karyawan/listnama", method = RequestMethod.GET)
	public ResponseEntity<List<String>> listnama() {
		List<String> list = karyawanService.listNamaKaryawan();
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}

}
