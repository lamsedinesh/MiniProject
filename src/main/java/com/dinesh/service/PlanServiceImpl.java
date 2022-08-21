package com.dinesh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinesh.entity.Plan;
import com.dinesh.entity.PlanCategory;
import com.dinesh.repository.PlanCategoryRepo;
import com.dinesh.repository.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepo planRepo;

	@Autowired
	private PlanCategoryRepo planCategory;

	@Override
	public Map<Integer, String> getPlanCategories() {
		List<PlanCategory> categories = planCategory.findAll();

		Map<Integer, String> categoryMap = new HashMap<>();
		categories.forEach(category -> {
			categoryMap.put(category.getCategoryId(), category.getCaterygoryName());
		});
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan saved = planRepo.save(plan);

		/*
		 * FIRST WAY if(saved.getPlanId()!=null) { return true; }else { return false; }
		 */ // NOTE:: Fresher write this code

		// SECOND WAY
		// return saved.getPlanId()!=null ? true:false; NOTE:: 1year experience person
		// write this code

		// THIRD WAY
		return saved.getPlanId() != null; // NOTE:: 3years experience person write this code

	}

	@Override
	public List<Plan> getAllPlan() {
		return planRepo.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> findById = planRepo.findById(planId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		planRepo.save(plan); // (upsert)
		return plan.getPlanId() != null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		boolean status = false;
		try {
			planRepo.deleteById(planId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId, String Status) {
		Optional<Plan> findById = planRepo.findById(planId);
		if (findById.isPresent()) {
			Plan plan = findById.get();
			plan.setActiveSw(Status);
			planRepo.save(plan);
			return true;
		}

		return false;
	}

}
