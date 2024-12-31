package in.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.company.entity.Applicant;
import in.company.service.ApplicantService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/applicants")
public class ApplicantController {
	@Autowired
	private ApplicantService applicantService;
	
	@GetMapping
	public List<Applicant> getAllApplicants(){
		return applicantService.getAllApplicants();
	}
	
	@PostMapping
	public void addCandidate(@RequestBody Applicant applicant)
	{
		applicantService.addApplicant(applicant);
	}
	
	@DeleteMapping("/{id}")
	public void deleteApplicant(@PathVariable Integer id)
	{
		applicantService.deleteById(id);
	}
	
}
