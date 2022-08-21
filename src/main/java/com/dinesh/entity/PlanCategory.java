package com.dinesh.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PLAN_CATEGORY")
@Data
public class PlanCategory {
	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;

	@Column(name = "CATEGORY_NAME")
	private String caterygoryName;

	@Column(name = "ACTIVE_SW")
	private String activeSw;

	@Column(name = "CREATE_DATE")
	private String createdBy;
	@Column(name = "UPDATE_DATE")
	private String updatedBy;

	@Column(name = "CREATED_BY", updatable = false)
	@CreationTimestamp
	private LocalDate createDate;

	@Column(name = "UPDATED_BY", insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;

	public PlanCategory() {
		super();
	}

	public PlanCategory(Integer categoryId, String caterygoryName, String activeSw, String createdBy, String updatedBy,
			LocalDate createDate, LocalDate updateDate) {
		super();
		this.categoryId = categoryId;
		this.caterygoryName = caterygoryName;
		this.activeSw = activeSw;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCaterygoryName() {
		return caterygoryName;
	}

	public void setCaterygoryName(String caterygoryName) {
		this.caterygoryName = caterygoryName;
	}

	public String getActiveSw() {
		return activeSw;
	}

	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

}
