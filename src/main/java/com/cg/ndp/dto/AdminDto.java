package com.cg.ndp.dto;

public class AdminDto {
	
	private int adminId;
	private String adminPassword;
	
	public AdminDto() {
		super();
		// default constructor;
	}

	public AdminDto(int adminId, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminPassword = adminPassword;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return String.format("AdminDto [adminId=%s, adminPassword=%s]", adminId, adminPassword);
	}
	
	

	
	

}
