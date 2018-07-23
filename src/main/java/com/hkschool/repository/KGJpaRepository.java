package com.hkschool.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.hkschool.models.KGEntity;

public interface KGJpaRepository extends PagingAndSortingRepository<KGEntity, Long> {

	@Query(value = "select * from kindergarten_school s where s.school_id = :schoolId limit 1", nativeQuery = true)
	KGEntity findBySchoolId(@Param(value = "schoolId") String schoolId);

	@Query(value = "select * from kindergarten_school s where s.school_name = :schoolName limit 1", nativeQuery = true)
	KGEntity findBySchoolName(@Param(value = "schoolName") String schoolName);

	@Query(value = "select * from kindergarten_school s where s.tel like :tel limit 1", nativeQuery = true)
	KGEntity findByTel(@Param(value = "tel") String tel);

}