package in.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="applicanttab")
public class Applicant {
	
	@Id
	@Column(name="aid")
	Integer id;
	
	@Column(name="aname")
	String name;
	
	@Column(name="aexp")
	Integer experience;
	
	@Column(name="askills")
	String skills;
}
