package com.dinesh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.entity.Plan;
import com.dinesh.service.PlanService;
import com.dinesh.service.PlanServiceImpl;

@RestController
public class PlanRestController {
	@Autowired
	private PlanService planService;

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories() {
		Map<Integer, String> categories = planService.getPlanCategories();
		return new ResponseEntity<>(categories, HttpStatus.OK);

	}

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
		String respondeMsg = "";
		boolean isSaved = planService.savePlan(plan);
		if (isSaved) {
			respondeMsg = "plan saved";
		} else {
			respondeMsg = "plan not saved";
		}
		return new ResponseEntity<>(respondeMsg, HttpStatus.CREATED);

	}

	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plan() {
		List<Plan> allPlan = planService.getAllPlan();
		return new ResponseEntity<>(allPlan, HttpStatus.OK);

	}

	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId) {
		Plan plan = planService.getPlanById(planId);
		return new ResponseEntity<>(plan, HttpStatus.OK);

	}

	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {
		boolean isUpdated = planService.updatePlan(plan);
		String msg = "";
		if(isUpdated) {
			msg = "plan updated";
		} else {
			msg = "plan not  updated";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
		boolean isDeleted = planService.deletePlanById(planId);
		String msg = "";
		if(isDeleted){
			msg = "Plan Deleted";
		} else {
			msg = "Plan not Deleted";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(Integer planId, String Status) {
		boolean isStatusChanged = planService.planStatusChange(planId, Status);
		String msg = "";
		if (isStatusChanged) {
			msg = "status changed";
		} else {
			msg = "status not changed";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
