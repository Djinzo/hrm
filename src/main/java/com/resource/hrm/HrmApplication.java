package com.resource.hrm;

import com.resource.hrm.entity.Absance;
import com.resource.hrm.entity.AbsanceType;
import com.resource.hrm.entity.Discipline;
import com.resource.hrm.entity.Employee;
import com.resource.hrm.repository.AbsanceRepository;
import com.resource.hrm.repository.AbsanceTypeRepository;
import com.resource.hrm.repository.DisciplineRepository;
import com.resource.hrm.repository.EmployeeRepository;
import com.resource.hrm.service.AbsanceTypeService.AbsanceTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class HrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmApplication.class, args);
	}


	@Bean
	CommandLineRunner start(EmployeeRepository employerRepository, DisciplineRepository disciplineRepository, AbsanceTypeRepository absanceTypeRepository, AbsanceRepository absanceRepository){
		return args -> {
			//adding some date to test
			employerRepository.save(Employee.builder().name("bourich").afterName("oumayma").acitve(true).address("this si a test address").cin("ab123456").blackListe(false).diplom("licance pro").email("test@gmail.com").phoneNumber("0680454776").post("ing").salary(100000.0).color((int)(Math.random() * 0x1000000)).build());
			employerRepository.save(Employee.builder().name("bourich1").afterName("oumayma1").acitve(true).address("this si a test address").cin("ab123456").blackListe(false).diplom("licance pro").email("test@gmail.com").phoneNumber("0680454776").post("ing").salary(100000.0).color((int)(Math.random() * 0x1000000)).build());
			employerRepository.save(Employee.builder().name("bourich2").afterName("oumayma2").acitve(true).address("this si a test address").cin("ab123456").blackListe(false).diplom("licance pro").email("test@gmail.com").phoneNumber("0680454776").post("ing").salary(100000.0).color((int)(Math.random() * 0x1000000)).build());


			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(1L)).build());
			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(1L)).build());
			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(1L)).build());

			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(2L)).build());
			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(2L)).build());


			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(3L)).build());
			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(3L)).build());
			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(3L)).build());
			disciplineRepository.save(Discipline.builder().avertissment("test").dateAvvert(new Date()).employer(employerRepository.getEmployeeByUid(3L)).build());

			absanceTypeRepository.save(AbsanceType.builder().type("just absnet").build());
			absanceTypeRepository.save(AbsanceType.builder().type("absent with a reason").build());
			absanceTypeRepository.save(AbsanceType.builder().type("absent with no reason").build());

			long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24 * 2;
			Date today = new Date();
			Date nextDay = new Date(today.getTime() + MILLIS_IN_A_DAY);
			absanceRepository.save(Absance.builder().note("nothing special").absanceType(absanceTypeRepository.getById(1L)).employer(employerRepository.getEmployeeByUid(1L)).startDate(today).endDate(nextDay).build());

		};
	}
}
