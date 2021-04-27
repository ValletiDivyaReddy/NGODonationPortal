package com.cg.ndp.service;

import java.util.List;

import com.cg.ndp.dto.NeedyPeopleDto;
import com.cg.ndp.exception.DuplicateNeedyPersonException;
import com.cg.ndp.exception.NoSuchNeedyException;
import com.cg.ndp.model.NeedyPeopleModel;
import com.cg.ndp.model.NeedyRequestModel;

public interface INeedyPeopleService {

	public boolean registerNeedyPerson(NeedyPeopleModel person) throws DuplicateNeedyPersonException;

	public boolean login(NeedyPeopleDto person) throws NoSuchNeedyException;

	public boolean requestForHelp(NeedyRequestModel person) throws DuplicateNeedyPersonException;
	
	public List<NeedyRequestModel> findAllRequests() throws NoSuchNeedyException;
	
	public boolean signOut(NeedyPeopleDto person) throws NoSuchNeedyException;
	

}
