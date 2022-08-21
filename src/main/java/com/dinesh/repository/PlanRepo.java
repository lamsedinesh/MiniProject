package com.dinesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dinesh.entity.Plan;

public interface PlanRepo  extends JpaRepository<Plan, Integer>{

}
