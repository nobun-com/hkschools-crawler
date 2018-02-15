package com.hkschool.repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hkschool.models.PSEntity;

public interface PSJpaRepository extends PagingAndSortingRepository<PSEntity, Long> {

	PSEntity findBySchoolId(String schoolId);

}