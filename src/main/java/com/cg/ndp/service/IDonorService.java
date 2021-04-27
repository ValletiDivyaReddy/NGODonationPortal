package com.cg.ndp.service;

import java.util.List;

import com.cg.ndp.dto.DonorDto;
import com.cg.ndp.exception.DuplicateDonorException;
import com.cg.ndp.exception.NoSuchDonorException;
import com.cg.ndp.model.DonationModel;
import com.cg.ndp.model.DonorModel;

public interface IDonorService {
	
	public DonorModel add(DonorModel donor) throws DuplicateDonorException;

	public List<DonationModel> getAllDonations(int donorId) throws NoSuchDonorException;

	public DonorModel modifyPassword(DonorModel donorModel, int donorId) throws NoSuchDonorException;

	DonorModel getById(int donorId) throws NoSuchDonorException;

	public Boolean login(DonorDto employee) throws NoSuchDonorException;
	
	public List<DonorModel> findAllDonors();


}
