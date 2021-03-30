package com.cg.ndp.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.cg.ndp.entity.AddressEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class NeedyPeopleModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private int needyPersonId;

	@NotEmpty(message = "name cannot be empty")
	@NotNull(message = "name cannot be omitted")
	private String needyPersonName;

	@Pattern(regexp = "[1-9][0-9]{9}", message = "mobile number is expected to be 10 digits and should not start with 0")
	@NotNull(message = "Phone number cannot be omitted")
	private String phone;

	@Max(value = 100000, message = "familyIncome cannot be more than 1 lakh")
	private double familyIncome;

	@JsonIgnore
	@Pattern(regexp = "(?=.\\d)(?=.[a-z])(?=.*[A-Z]).{8,}", message = "Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters\" required")
	private String needyPeoplePassword;

	@NotEmpty(message = "Address Id cannot be empty")
	@NotNull(message = "Address Id cannot be omitted")
	private AddressEntity address;

	public NeedyPeopleModel() {

	}

	public NeedyPeopleModel(int needyPersonId,
			@NotEmpty(message = "name cannot be empty") @NotNull(message = "name cannot be omitted") String needyPersonName,
			@Pattern(regexp = "[1-9][0-9]{9}", message = "mobile number is expected to be 10 digits and should not start with 0") @NotNull(message = "Phone number cannot be omitted") String phone,
			@Max(value = 100000, message = "familyIncome cannot be more than 1 lakh") double familyIncome,
			@Pattern(regexp = "(?=.\\d)(?=.[a-z])(?=.*[A-Z]).{8,}", message = "Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters\" required") String needyPeoplePassword,
			@NotEmpty(message = "Address Id cannot be empty") @NotNull(message = "Address Id cannot be omitted") AddressEntity address) {
		super();
		this.needyPersonId = needyPersonId;
		this.needyPersonName = needyPersonName;
		this.phone = phone;
		this.familyIncome = familyIncome;
		this.needyPeoplePassword = needyPeoplePassword;
		this.address = address;
	}

	public int getNeedyPersonId() {
		return needyPersonId;
	}

	public void setNeedyPersonId(int needyPersonId) {
		this.needyPersonId = needyPersonId;
	}

	public String getNeedyPersonName() {
		return needyPersonName;
	}

	public void setNeedyPersonName(String needyPersonName) {
		this.needyPersonName = needyPersonName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getFamilyIncome() {
		return familyIncome;
	}

	public void setFamilyIncome(double familyIncome) {
		this.familyIncome = familyIncome;
	}

	public String getNeedyPeoplePassword() {
		return needyPeoplePassword;
	}

	public void setNeedyPeoplePassword(String needyPeoplePassword) {
		this.needyPeoplePassword = needyPeoplePassword;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "NeedyPeopleModel [needyPersonId=" + needyPersonId + ", needyPersonName=" + needyPersonName + ", phone="
				+ phone + ", familyIncome=" + familyIncome + ", needyPeoplePassword=" + needyPeoplePassword
				+ ", address=" + address + "]";
	}

}