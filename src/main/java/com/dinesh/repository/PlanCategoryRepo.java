package com.dinesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dinesh.entity.PlanCategory;
@Repository
public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Integer> {

}
