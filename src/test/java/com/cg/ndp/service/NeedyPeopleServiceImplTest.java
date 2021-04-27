package com.cg.ndp.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.ndp.dto.NeedyPeopleDto;

import com.cg.ndp.exception.DuplicateNeedyPersonException;
import com.cg.ndp.exception.NoSuchNeedyException;
import com.cg.ndp.model.AddressModel;
import com.cg.ndp.model.NeedyPeopleModel;
import com.cg.ndp.model.NeedyRequestModel;

@ExtendWith(MockitoExtension.class)
public class NeedyPeopleServiceImplTest {
	@Mock
	private INeedyPeopleService needypeopleRepo;

	@InjectMocks
	private NeedyPeopleServiceImpl service;

	@BeforeEach
	void runBeforeAllTestCase() {
		service = new NeedyPeopleServiceImpl();
	}

	@AfterEach
	void cleanAfterAllTestCase() {
		service = null;
	}

	@Test
	@DisplayName("registration")
	void testCreateDonor() throws DuplicateNeedyPersonException {
		AddressModel a1 = new AddressModel(10001, "chennai", "TamilNadu", "667762", "avadi");
		NeedyPeopleModel person = new NeedyPeopleModel(1001, "SRI AASHRITHA", "7330867459", 20000.0, "Sriaashritha#1",
				a1);
		Mockito.when(needypeopleRepo.registerNeedyPerson(person)).thenReturn(true);
		assertTrue(needypeopleRepo.registerNeedyPerson(person));
	}

	@Test
	@DisplayName("Login")
	void testLogin() throws NoSuchNeedyException {
		NeedyPeopleDto dto = new NeedyPeopleDto(1001, "Sriaashritha#1");
		Mockito.when(needypeopleRepo.login(dto)).thenReturn(true);
		assertTrue(needypeopleRepo.login(dto));

	}

	@Test
	@DisplayName("Request For Help")
	void testRequestForHelp() throws DuplicateNeedyPersonException {
		NeedyRequestModel dto = new NeedyRequestModel(1001, "request raise", "1234567890");
		Mockito.when(needypeopleRepo.requestForHelp(dto)).thenReturn(true);
		assertTrue(needypeopleRepo.requestForHelp(dto));

	}
}