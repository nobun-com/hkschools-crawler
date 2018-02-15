package com.hkschool.repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hkschool.models.SSEntity;

public interface SSJpaRepository extends PagingAndSortingRepository<SSEntity, Long> {

	SSEntity findBySchoolId(String schoolId);

}