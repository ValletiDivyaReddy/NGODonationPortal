package com.cg.ndp.model;

import java.time.LocalDate;

import com.cg.ndp.entity.DonationDistributionStatus;
import com.cg.ndp.entity.DonationItemEntity;
import com.cg.ndp.entity.EmployeeEntity;
import com.cg.ndp.entity.NeedyPeopleEntity;

public class DonationDistributionModel {

	private int distributionId;

	private double amountDistributed;

	private LocalDate dateOfDistribution;

	private LocalDate approvalOrRejectedDate;

	private DonationDistributionStatus status;

	private NeedyPeopleEntity person;

	private EmployeeEntity distributedBy;

	private DonationItemEntity item;

	public DonationDistributionModel() {
		super();
	}

	public DonationDistributionModel(int distributionId, double amountDistributed, LocalDate dateOfDistribution,
			LocalDate approvalOrRejectedDate, DonationDistributionStatus status, NeedyPeopleEntity person,
			EmployeeEntity distributedBy, DonationItemEntity item) {
		super();
		this.distributionId = distributionId;
		this.amountDistributed = amountDistributed;
		this.dateOfDistribution = dateOfDistribution;
		this.approvalOrRejectedDate = approvalOrRejectedDate;
		this.status = status;
		this.person = person;
		this.distributedBy = distributedBy;
		this.item = item;
	}

	public int getDistributionId() {
		return distributionId;
	}

	public void setDistributionId(int distributionId) {
		this.distributionId = distributionId;
	}

	public double getAmountDistributed() {
		return amountDistributed;
	}

	public void setAmountDistributed(double amountDistributed) {
		this.amountDistributed = amountDistributed;
	}

	public LocalDate getDateOfDistribution() {
		return dateOfDistribution;
	}

	public void setDateOfDistribution(LocalDate dateOfDistribution) {
		this.dateOfDistribution = dateOfDistribution;
	}

	public LocalDate getApprovalOrRejectedDate() {
		return approvalOrRejectedDate;
	}

	public void setApprovalOrRejectedDate(LocalDate approvalOrRejectedDate) {
		this.approvalOrRejectedDate = approvalOrRejectedDate;
	}

	public DonationDistributionStatus getStatus() {
		return status;
	}

	public void setStatus(DonationDistributionStatus status) {
		this.status = status;
	}

	public NeedyPeopleEntity getPerson() {
		return person;
	}

	public void setPerson(NeedyPeopleEntity person) {
		this.person = person;
	}

	public EmployeeEntity getDistributedBy() {
		return distributedBy;
	}

	public void setDistributedBy(EmployeeEntity distributedBy) {
		this.distributedBy = distributedBy;
	}

	public DonationItemEntity getItem() {
		return item;
	}

	public void setItem(DonationItemEntity item) {
		this.item = item;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amountDistributed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((approvalOrRejectedDate == null) ? 0 : approvalOrRejectedDate.hashCode());
		result = prime * result + ((dateOfDistribution == null) ? 0 : dateOfDistribution.hashCode());
		result = prime * result + ((distributedBy == null) ? 0 : distributedBy.hashCode());
		result = prime * result + distributionId;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonationDistributionModel other = (DonationDistributionModel) obj;
		if (Double.doubleToLongBits(amountDistributed) != Double.doubleToLongBits(other.amountDistributed))
			return false;
		if (approvalOrRejectedDate == null) {
			if (other.approvalOrRejectedDate != null)
				return false;
		} else if (!approvalOrRejectedDate.equals(other.approvalOrRejectedDate))
			return false;
		if (dateOfDistribution == null) {
			if (other.dateOfDistribution != null)
				return false;
		} else if (!dateOfDistribution.equals(other.dateOfDistribution))
			return false;
		if (distributedBy == null) {
			if (other.distributedBy != null)
				return false;
		} else if (!distributedBy.equals(other.distributedBy))
			return false;
		if (distributionId != other.distributionId)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DonationDistributionModel [distributionId=" + distributionId + ", amountDistributed="
				+ amountDistributed + ", dateOfDistribution=" + dateOfDistribution + ", approvalOrRejectedDate="
				+ approvalOrRejectedDate + ", status=" + status + ", person=" + person + ", distributedBy="
				+ distributedBy + ", item=" + item + "]";
	}

}
