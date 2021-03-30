package com.cg.ndp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.ndp.dto.NeedyPeopleDto;
import com.cg.ndp.entity.NeedyPeopleEntity;
import com.cg.ndp.exception.DuplicateNeedyPersonException;
import com.cg.ndp.exception.NoSuchNeedyPeopleException;
import com.cg.ndp.model.NeedyPeopleModel;
import com.cg.ndp.repo.NeedyPeopleRepo;


public class NeedyPeopleServiceImpl implements INeedyPeopleService {

	@Autowired
	private NeedyPeopleRepo needyRepo;

	@Autowired
	private EMParser parser;

	@Override
	public boolean registerNeedyPerson(NeedyPeopleModel person) throws DuplicateNeedyPersonException {
		Boolean status = false;

		if (person != null) {
			if (needyRepo.existsById(person.getNeedyPersonId())) {
				throw new DuplicateNeedyPersonException("Person already Exists");
			}
			person = parser.parse(needyRepo.save(parser.parse(person)));
			status = true;

		}

		return status;
	}

	@Override
	public boolean login(NeedyPeopleDto person)throws NoSuchNeedyPeopleException {
		boolean status = false;
		Optional<NeedyPeopleEntity> dt=needyRepo.findById(person.getNeedyPersonId());
		if(dt.isPresent()) {
			if(dt.get().getNeedyPeoplePassword().equals(person.getNeedyPeoplePassword())){
				status = true;	
			}
		} else {
			throw new NoSuchNeedyPeopleException("Invalid password / user");
		}
		return status;
	}

	@Override
	public boolean requestForHelp(NeedyPeopleModel person) {
		// TODO Auto-generated method stub
		
		
		return false;
	}


	
}