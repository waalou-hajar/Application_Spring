package org.sid;

import java.util.Date;
import java.util.List;

import org.sid.dao.PatientRepository;
import org.sid.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppSpringApplication implements CommandLineRunner {
	@Autowired
	PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(AppSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*patientRepository.save(new Patient(null,"Hajar",new Date(),false,7));	
		patientRepository.save(new Patient(null,"Imane",new Date(),false,6));	
		patientRepository.save(new Patient(null,"Amale",new Date(),true,9));
		patientRepository.save(new Patient(null,"hassan",new Date(),false,10));	*/

		
		System.out.println("******* traitement 1 ************");
		patientRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
			
	}

}
