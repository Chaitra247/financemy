package com.financialorgratingsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financialorgratingsystem.entity.Organization;
import com.financialorgratingsystem.entity.User;
import com.financialorgratingsystem.exception.OrganizationIdNotFoundException;
import com.financialorgratingsystem.exception.UserNotFoundException;
import com.financialorgratingsystem.repository.OrganizationRepo;
import com.financialorgratingsystem.service.OrganizationService;
import com.financialorgratingsystem.service.UserService;

@RestController
@RequestMapping("/api/org")
public class OrganizationController {
	@Autowired
	  OrganizationService organizationService;

//	 http://localhost:8088/api/org/add
		@PostMapping("/add")
		public ResponseEntity<Organization> insertOrganization(@RequestBody Organization org) {
			Organization org1 = organizationService.addOrganization(org);
			if (org1 == null) {
				return new ResponseEntity("Sorry! Organization not added!", HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<Organization>(org, HttpStatus.OK);
		}

//		http://localhost:8088/api/org/update
	@PutMapping("/update")
	public ResponseEntity<Organization> updateOrganization(@RequestBody Organization o) {
		Organization org = organizationService.updateOrganization(o);
		if (o == null) {
			return new ResponseEntity("Sorry! update failed!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Organization>(o, HttpStatus.OK);
	}
	
//		http://localhost:8088/api/org/get/1
	@GetMapping("get/{organizationId}")

	public ResponseEntity<Organization> getOrganizationByOrganizationId(@PathVariable("organizationId") int organizationId)throws OrganizationIdNotFoundException {
	Organization oId = organizationService.getOrganizationByOrganizationId(organizationId);
	Organization organization= organizationService.getOrganizationByOrganizationId(organizationId);
	if(organization==null) {
	throw new OrganizationIdNotFoundException();
}
	return new ResponseEntity <Organization>(organization, HttpStatus.OK);
	}
	
//   http://localhost:8088/api/org/allorg
	 @GetMapping("/allorg")

	 public List<Organization> getAllOrganization()
	 {
	 return organizationService.getAllOrganization();
	 }
   
}
