package com.cg.ndp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.ndp.dto.EmployeeDto;
import com.cg.ndp.entity.DonationDistributionStatus;
import com.cg.ndp.entity.DonationItemEntity;
import com.cg.ndp.entity.EmployeeEntity;
import com.cg.ndp.entity.NeedyPeopleEntity;
import com.cg.ndp.exception.DuplicateDonationException;
import com.cg.ndp.exception.DuplicateNeedyPersonException;
import com.cg.ndp.exception.NoSuchEmployeeException;
import com.cg.ndp.exception.NoSuchNeedyPeopleException;
import com.cg.ndp.model.AddressModel;
import com.cg.ndp.model.DonationDistributionModel;
import com.cg.ndp.model.NeedyPeopleModel;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {
	@Mock
	private IEmployeeService empRepo;

	@InjectMocks
	private EmployeeServiceImpl service;

	@BeforeEach
	void runBeforeAllTestCase() {
		service = new EmployeeServiceImpl(null, null, null, null);
	}

	@AfterEach
	void cleanAfterAllTestCase() {
		service = null;
	}

	@Test
	void testRemoveNeedyPerson() throws NoSuchNeedyPeopleException {
		AddressModel a1 = new AddressModel(10001, "Bangalore", "Karnataka", "714323", "MGRoad");
		NeedyPeopleModel person1 = new NeedyPeopleModel(1, "ravi", "8965432212", 89000, "Vyshu@123", a1);
		Mockito.when(empRepo.removeNeedyPerson(person1.getNeedyPersonId())).thenReturn(true);
		assertTrue(empRepo.removeNeedyPerson(person1.getNeedyPersonId()));

	}

	@Test
	void testLogin() throws NoSuchEmployeeException {
		EmployeeDto emp1 = new EmployeeDto(1, "src");
		Mockito.when(empRepo.login(emp1)).thenReturn(true);
		assertTrue(empRepo.login(emp1));

	}

	@Test
	void testaddNeedyPerson() throws DuplicateNeedyPersonException {
		AddressModel a1 = new AddressModel(10001, "Bangalore", "Karnataka", "714323", "MGRoad");
		NeedyPeopleModel person1 = new NeedyPeopleModel(1, "ravi", "8965432212", 89000, "Vyshu@123", a1);
		Mockito.when(empRepo.addNeedyPerson(person1)).thenReturn(true);
		assertTrue(empRepo.addNeedyPerson(person1));
	}

	@Test
	public void testfindNeedyById() throws NoSuchNeedyPeopleException {
		AddressModel a1 = new AddressModel(10001, "Bangalore", "Karnataka", "714323", "MGRoad");
		NeedyPeopleModel person1 = new NeedyPeopleModel(1, "ravi", "8965432212", 89000, "Vyshu@123", a1);
		NeedyPeopleModel expected = new NeedyPeopleModel(1, "ravi", "8965432212", 89000, "Vyshu@123", a1);
		Mockito.when(empRepo.findNeedyPeopleById(person1.getNeedyPersonId())).thenReturn(expected);
		NeedyPeopleModel actual = empRepo.findNeedyPeopleById(person1.getNeedyPersonId());
		assertEquals(expected, actual);
	}

	@Test
	public void testfindNeedyPeopleByName() throws NoSuchNeedyPeopleException {
		AddressModel a1 = new AddressModel(10001, "Bangalore", "Karnataka", "714323", "MGRoad");
		AddressModel a2 = new AddressModel(10002, "Bangalore", "Karnataka", "714323", "BridgeRoad");
		String name = "vaishu";
		List<NeedyPeopleModel> list = new ArrayList<>();
		NeedyPeopleModel[] testData = { new NeedyPeopleModel(1, "vaishu", "8965432212", 89000, "Vyshu@123", a1),
				new NeedyPeopleModel(2, "bhavitha", "9000865886", 97900, "Vyshu@123", a2) };
		for (NeedyPeopleModel p : testData) {
			list.add(p);
		}
		Mockito.when(empRepo.findNeedyPeopleByName(name)).thenReturn(list);

		List<NeedyPeopleModel> actual = empRepo.findNeedyPeopleByName(name);
		assertEquals(list, actual);

	}

	@Test
	public void testfindAllNeedyPeople() throws NoSuchNeedyPeopleException {
		AddressModel a1 = new AddressModel(10001, "Bangalore", "Karnataka", "714323", "MGRoad");
		AddressModel a2 = new AddressModel(10002, "Bangalore", "Karnataka", "714323", "BridgeRoad");
		List<NeedyPeopleModel> list = new ArrayList<>();
		NeedyPeopleModel[] testData = { new NeedyPeopleModel(1, "vaishu", "8965432212", 89000, "Vyshu@123", a1),
				new NeedyPeopleModel(2, "bhavitha", "9000865886", 97900, "Vyshu@123", a2) };
		for (NeedyPeopleModel p : testData) {
			list.add(p);
		}
		Mockito.when(empRepo.findAllNeedyPeople()).thenReturn(list);

		List<NeedyPeopleModel> actual = empRepo.findAllNeedyPeople();
		assertEquals(list, actual);

	}

	@Test
	public void testhelpNeedyPerson() throws DuplicateDonationException {
		AddressModel a1 = new AddressModel(10001, "Bangalore", "Karnataka", "714323", "MGRoad");
		String name = "vaishu";
		NeedyPeopleEntity model = new NeedyPeopleEntity(1, "vaishu", "89654334212", 89000.0, "Vyshu@112", a1);
		DonationItemEntity donat = null;
		EmployeeEntity emp = null;
		DonationDistributionStatus status = null;
		DonationDistributionModel testData = new DonationDistributionModel(1, 12.0, LocalDate.parse("2021-03-20"),
				LocalDate.parse("2021-03-21"), status, model, emp, donat);
		Mockito.when(empRepo.helpNeedyPerson(testData)).thenReturn(name);
		String actual = empRepo.helpNeedyPerson(testData);
		assertEquals(name, actual);

	}

}
