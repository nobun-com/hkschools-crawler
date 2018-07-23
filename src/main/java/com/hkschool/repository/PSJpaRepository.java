package com.hkschool.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.hkschool.models.PSEntity;

public interface PSJpaRepository extends PagingAndSortingRepository<PSEntity, Long> {

	@Query(value = "select * from primary_school p where p.school_id = :schoolId limit 1", nativeQuery = true)
	PSEntity findBySchoolId(@Param(value = "schoolId") String schoolId);

	@Query(value = "select * from primary_school p where p.school_name = :schoolName limit 1", nativeQuery = true)
	PSEntity findBySchoolName(@Param(value = "schoolName") String schoolName);

	@Query(value = "select * from primary_school p where p.tel like :tel limit 1", nativeQuery = true)
	PSEntity findByTel(@Param(value = "tel") String tel);

}