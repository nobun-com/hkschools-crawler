package com.hkschool.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.hkschool.models.SSEntity;

public interface SSJpaRepository extends PagingAndSortingRepository<SSEntity, Long> {

	SSEntity findBySchoolId(String schoolId);

	@Query(value = "select * from secondary_school s where s.school_name = :schoolName limit 1", nativeQuery = true)
	SSEntity findBySchoolName(@Param(value = "schoolName") String schoolName);

	@Query(value = "select * from secondary_school s where s.tel like :tel limit 1", nativeQuery = true)
	SSEntity findByTel(@Param(value = "tel") String tel);

}