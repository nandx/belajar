package com.nanda.spring.belajar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nanda.spring.belajar.entity.Karyawan;

//ini bagian query
@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, Long> {

}
