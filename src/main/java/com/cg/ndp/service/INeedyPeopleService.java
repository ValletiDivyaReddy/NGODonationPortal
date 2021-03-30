package com.cg.ndp.service;

import com.cg.ndp.dto.NeedyPeopleDto;
import com.cg.ndp.exception.DuplicateNeedyPersonException;
import com.cg.ndp.exception.NoSuchNeedyPeopleException;
import com.cg.ndp.model.NeedyPeopleModel;

public interface INeedyPeopleService {
	public boolean registerNeedyPerson(NeedyPeopleModel person) throws DuplicateNeedyPersonException;
	public boolean requestForHelp(NeedyPeopleModel person);
	boolean login(NeedyPeopleDto person) throws NoSuchNeedyPeopleException;

	
}