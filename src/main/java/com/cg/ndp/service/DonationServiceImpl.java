package com.cg.ndp.service;

import javax.transaction.Transactional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ndp.model.DonationModel;
import com.cg.ndp.model.DonorModel;
import com.cg.ndp.repo.DonationRepo;

@Service
public class DonationServiceImpl implements IDonationService {
	@Autowired
	private DonationRepo donationRepo;
	@Autowired
	private EMParser parser;

	
	public DonationServiceImpl(DonationRepo donationRepo, EMParser parser) {
		super();
		this.donationRepo = donationRepo;
		this.parser = new EMParser();
	}
	
	

	public DonationRepo getDonationRepo() {
		return donationRepo;
	}



	public void setDonationRepo(DonationRepo donationRepo) {
		this.donationRepo = donationRepo;
	}



	public EMParser getParser() {
		return parser;
	}



	public void setParser(EMParser parser) {
		this.parser = parser;
	}



	@Transactional
	@Override
	public DonationModel add(DonationModel donationModel) {
		return parser.parse(donationRepo.save(parser.parse(donationModel)));

	}

	@Override
	public void sendThankYouMailToDonator(DonorModel donorModel) {
		
	}

}