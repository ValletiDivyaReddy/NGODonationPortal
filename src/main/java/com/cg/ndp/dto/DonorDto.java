package com.cg.ndp.dto;

public class DonorDto {
	
	private int donorId;
	private String donorPassword;
	public DonorDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DonorDto(int donorId, String donorPassword) {
		super();
		this.donorId = donorId;
		this.donorPassword = donorPassword;
	}
	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	public String getDonorPassword() {
		return donorPassword;
	}
	public void setDonorPassword(String donorPassword) {
		this.donorPassword = donorPassword;
	}
	@Override
	public String toString() {
		return String.format("DonorDto [donorId=%s, donorPassword=%s]", donorId, donorPassword);
	}
	
	
	

}
