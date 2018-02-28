package com.hkschool.repository;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hkschool.models.KGEntity;

public interface KGJpaRepository extends PagingAndSortingRepository<KGEntity, Long> {

	KGEntity findBySchoolId(String schoolId);

	List<KGEntity> findBySchoolName(String schoolName);

}