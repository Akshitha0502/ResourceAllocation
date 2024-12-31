package in.company.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.company.entity.Applicant;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Integer>{
	
}
