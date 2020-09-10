package com.nanda.spring.belajar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nanda.spring.belajar.entity.Karyawan;
import com.nanda.spring.belajar.service.KaryawanService;

@Controller
public class KaryawanController {

	@Autowired
	private KaryawanService karyawanService;

	@GetMapping("/karyawan")
	public String list(Model model) {
		Page<Karyawan> page = karyawanService.listAllKaryawan();
		List<Karyawan> list = page.getContent();
		model.addAttribute("list_karyawan", list);
		return "karyawan/list-karyawan";
	}

	@GetMapping("/karyawan/create")
	public String create(Model model) {
		model.addAttribute("employee", new Karyawan());
		return "karyawan/create-karyawan";
	}

	@PostMapping("/karyawan/create")
	public String create(Model model, @ModelAttribute("employee") Karyawan employee) {
		karyawanService.save(employee);
		return "redirect:/karyawan";
	}

	@GetMapping("/karyawan/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long idKaryawan) {
		Karyawan karyawan = karyawanService.getKaryawan(idKaryawan);
		model.addAttribute("employee", karyawan);
		return "karyawan/edit-karyawan";
	}

	@PostMapping("/karyawan/edit")
	public String edit(Model model, @ModelAttribute("employee") Karyawan employee) {
		karyawanService.save(employee);
		return "redirect:/karyawan";
	}

	@GetMapping("/karyawan/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long idKaryawan) {
		Karyawan karyawan = karyawanService.getKaryawan(idKaryawan);
		karyawanService.delete(karyawan);
		return "redirect:/karyawan";
	}

}
