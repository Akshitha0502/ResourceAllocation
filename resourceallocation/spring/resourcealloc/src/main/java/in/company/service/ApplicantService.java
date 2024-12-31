package in.company.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.company.entity.Applicant;
import in.company.entity.SelectedApplicants;
import in.company.repo.ApplicantRepository;
import in.company.repo.SelectedApplicantsRepository;

@Service
public class ApplicantService {
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	@Autowired
	private SelectedApplicantsRepository sarepo;
	public Applicant addApplicant(Applicant applicant ) 
	{
		applicantRepository.save(applicant);
		sarepo.deleteAll();
		List<String> selectedList=findMatchingCandidate();
		SelectedApplicants s1=new SelectedApplicants(1,selectedList.get(0));
		SelectedApplicants s2=new SelectedApplicants(2,selectedList.get(1));
		sarepo.save(s1);
		sarepo.save(s2);
		return applicant;
	}
	
	public List<Applicant> getAllApplicants(){
		return (List<Applicant>) applicantRepository.findAll();
	}
	
	public void deleteById(Integer id) {
		applicantRepository.deleteById(id);
	}
	
public List<String> findMatchingCandidate()
	{
		List<String> result=new ArrayList<String>();
		
		List<Applicant> clist=getAllApplicants();
		
		Optional<String> microserviceApplicants=
				clist
				.stream()
				.filter(applicant->applicant.getSkills().toLowerCase().contains("java")
						&&applicant.getSkills().toLowerCase().contains("redis")
						&&applicant.getSkills().toLowerCase().contains("javascript"))
				.map(applicant->applicant.getName())
				.reduce((ans,name)->ans+", "+name);
		
		Optional<String> cloudApplicants=
				clist
				.stream()
				.filter(applicant->applicant.getExperience()<10
						&&applicant.getSkills().toLowerCase().contains("mysql")
						&&applicant.getSkills().toLowerCase().contains("docker")
						&&applicant.getSkills().toLowerCase().contains("spring")
						&&applicant.getSkills().toLowerCase().contains("react"))
				.map(applicant->applicant.getName())
				.reduce((ans,name)->ans+", "+name);
		
		result.add(microserviceApplicants.orElse("")); //convert Optional type to String type
		result.add(cloudApplicants.orElse(""));
		return result;
	}
}
