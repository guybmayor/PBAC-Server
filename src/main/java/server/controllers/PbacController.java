package server.controllers;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import pbac.base.ActingUser;
import pbac.base.ActionType;
import pbac.cases.JsonCaseStudy;
import pbac.provenance.Provenance;
import pbac.provenance.Transaction;
import server.services.PbacService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PbacController {
	
	@Autowired
	PbacService service;

	@GetMapping(value = "/case")
	@ResponseBody
	Set<String> readCasesNames() {
		return this.service.findAllName();
	}
	
	@PostMapping(value = "/init")
	@ResponseBody
	boolean initAll() {
		return this.service.initAll();
	}
	
	@RequestMapping(value = "/{caseName}/action-type", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<?> readActionTypes(@PathVariable String caseName) {
		List<ActionType> types = this.service.readAllActionTypes(caseName);
		if (types == null) {
			return ResponseEntity.badRequest().build();
		} else {
			return ResponseEntity.ok(types);
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	ActingUser createUser() {
		return this.service.createUser();
	}
	
	@RequestMapping(value = "/{caseName}/request", method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<?> processRequest (@PathVariable String caseName,
			@RequestBody RequestWrapper req) {
		
		Transaction trans = this.service.processRequest(caseName, req.getUserId(), req.getActionTypeName(), req.getObjects());
		if (trans == null) {
			return ResponseEntity.badRequest().build();
		} else {
			return ResponseEntity.ok(trans);
		}
	}
	
	@RequestMapping(value = "/{caseName}/provenance/last", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<?> getLastProvenanceData (@PathVariable String caseName) {
		
		Provenance prov= this.service.getLastProvenanceData(caseName);
		if (prov == null) {
			return ResponseEntity.badRequest().build();
		} else {
			return ResponseEntity.ok(prov);
		}
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> submit(
	 MultipartHttpServletRequest request) {
		 try {
			 Iterator<String> itr = request.getFileNames();
			 MultipartFile file = request.getFile(itr.next());
		        
			 JsonCaseStudy cse = new JsonCaseStudy(new String(file.getBytes()));
			 this.service.addCase(cse);
			 System.out.println("ok");
			 return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
