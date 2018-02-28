package com.hkschool.repository;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hkschool.models.PSEntity;

public interface PSJpaRepository extends PagingAndSortingRepository<PSEntity, Long> {

	PSEntity findBySchoolId(String schoolId);

	List<PSEntity> findBySchoolName(String schoolName);

}