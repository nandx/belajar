package com.nanda.spring.belajar.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nanda.spring.belajar.entity.Karyawan;

//ini bagian query
@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, Long> {

	@Query("SELECT emp FROM Karyawan emp WHERE emp.namakaryawan LIKE :p_nama ")
	public Page<Karyawan> searchNamaKaryawan(@Param("p_nama") String nama, Pageable pageable);

	@Query(value = "SELECT namakaryawan FROM karyawan", nativeQuery = true)
	public List<String> listNamaKaryawan();

}
