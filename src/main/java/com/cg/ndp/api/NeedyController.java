package com.cg.ndp.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/needy")
public class NeedyController {
	
//	@Autowired
//	private INeedyPeopleService needyService;
//	
//	@PostMapping("/addneedypeople")
//	public ResponseEntity<Boolean> registerNeedyPerson(@RequestBody NeedyPeopleModel person) throws DuplicateNeedyPersonException {		
//		return new ResponseEntity<Boolean>(needyService.registerNeedyPerson(person),HttpStatus.OK);
//	}
//	
//	@PostMapping("/login")
//	public ResponseEntity<Boolean> login(@RequestBody NeedyPeopleDto employee) throws NoSuchNeedyPeopleException {		
//		return new ResponseEntity<Boolean>(needyService.login(employee),HttpStatus.OK);
//	}
}