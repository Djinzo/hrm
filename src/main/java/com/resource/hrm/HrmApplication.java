package com.resource.hrm;

import com.resource.hrm.entity.Discipline;
import com.resource.hrm.entity.Employee;
import com.resource.hrm.repository.DisciplineRepository;
import com.resource.hrm.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class HrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmApplication.class, args);
	}


	@Bean
	CommandLineRunner start(EmployeeRepository employerRepository, DisciplineRepository disciplineRepository){
		return args -> {
			//adding some date to test
			employerRepository.save(Employee.builder().name("bourich").afterName("oumayma").acitve(true).address("this si a test address").cin("ab123456").blackListe(false).diplom("licance pro").email("test@gmail.com").phoneNumber("0680454776").post("ing").salary(100000.0).build());
			employerRepository.save(Employee.builder().name("bourich1").afterName("oumayma1").acitve(true).address("this si a test address").cin("ab123456").blackListe(false).diplom("licance pro").email("test@gmail.com").phoneNumber("0680454776").post("ing").salary(100000.0).build());
			employerRepository.save(Employee.builder().name("bourich2").afterName("oumayma2").acitve(true).address("this si a test address").cin("ab123456").blackListe(false).diplom("licance pro").email("test@gmail.com").phoneNumber("0680454776").post("ing").salary(100000.0).build());


			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(1L)).build());
			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(1L)).build());
			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(1L)).build());

			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(2L)).build());
			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(2L)).build());


			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(3L)).build());
			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(3L)).build());
			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(3L)).build());
			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(3L)).build());
		};
	}
}
