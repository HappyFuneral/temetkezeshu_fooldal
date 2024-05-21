package hu.temetkezes.demo;

import hu.temetkezes.demo.models.Company;
import hu.temetkezes.demo.models.Office;
import hu.temetkezes.demo.models.Role;
import hu.temetkezes.demo.models.User;
import hu.temetkezes.demo.repository.CompanyRepository;
import hu.temetkezes.demo.repository.OfficeRepository;
//import hu.temetkezes.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
/*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
*/
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	OfficeRepository officeRepository;
    @Autowired
    private CompanyRepository companyRepository;


	/*
	@Bean
	public CommandLineRunner setupDefaultUser(UserService service) {
		return args -> {
			service.save(new User(
					"user", //username
					"user", //password
					Arrays.asList(new Role("USER"), new Role("ACTUATOR")),//roles
					true//Active
			));
		};
	}

	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean("officeRepository")
	CommandLineRunner commandLineRunner(){
		return args -> {
			officeSeeder();
		};
	}

	public void officeSeeder(){
		if ( companyRepository.count() == 0){
			ArrayList<Company> companies = new ArrayList<>();
			companies.add(new Company("Szomorúfűz Temetkezés","szomfuz"));
			companies.add(new Company("Aevum Temetkezés","aevum"));
			companyRepository.saveAll(companies);
		}
		if (officeRepository.count() == 0) {
			ArrayList<Office> offices = new ArrayList<>();
			offices.add(new Office(
					"Aevum Dembi",
					"Magyarország, Budapest 1071, Dembinszky utca 44",
					47.50755608897227,
					19.082259008592498,
					"Magyarország",
					"1071",
					"Pest",
					"Budapest",
					"Dembinszky utca 44",
					"hu-bu",
					companyRepository.findAll().get(1)					)
			);
			offices.add(new Office(
					"Aevum Izabella",
					"Magyarország, Budapest 1064, Izabella utca 65",
					47.50884478894911,
					19.066047925940623,
					"Magyarország",
					"1064",
					"Pest",
					"Budapest",
					"Izabella utca 65",
					"hu-bu",
					companyRepository.findAll().get(1)
			));
			offices.add(new Office(
					"Aevum Pesti",
					"Magyarország, Budapest 1173, Pesti út 41/A",
					47.48312983311757,
					19.238884639430985,
					"Magyarország",
					"1173",
					"Pest",
					"Budapest",
					"Pesti út 41/A",
					"hu-bu",
					companyRepository.findAll().get(1)
			));
			offices.add(new Office(
					"Aevum Lenhossék",
					"Magyarország, Budapest 1096, Lenhossék utca 33.",
					47.48072524137717,
					19.080378810594798,
					"Magyarország",
					"1096",
					"Pest",
					"Budapest",
					"Lenhossék utca 33.",
					"hu-bu",
					companyRepository.findAll().get(1)
			));
			offices.add(new Office(
					"Aevum Villányi",
					"Magyarország,Budapest 1114, Villányi út 6.",
					47.477960838544284,
					19.04509812593893,
					"Magyarország",
					"1114",
					"Pest",
					"Budapest",
					"Villanyi út 6.",
					"hu-bu",
					companyRepository.findAll().get(1)
			));
			offices.add(new Office(
					"Aevum Ernő",
					"Magyarország,Budapest 1096, Ernő u. 30-34",
					47.47958894467054,
					19.085216554775098,
					"Magyarország",
					"1096",
					"Pest",
					"Budapest",
					"Ernő u. 30-34.",
					"hu-bu",
					companyRepository.findAll().get(1)
			));
			offices.add(new Office(
					"Szomorúfűz Temetkezés Budai",
					"Magyarország,Budapest 1123, Nagyenyed u. 1.",
					47.498757248209564,
					19.02339759688433,
					"Magyarország",
					"1123",
					"Pest",
					"Budapest",
					"Nagyenyed u. 1",
					"hu-bu",
					companyRepository.findAll().get(0)

			));
			offices.add(new Office(
					"Aevum Nagyenyed",
					"Magyarország,Budapest 1123, Nagyenyed u. 1.",
					47.498757248209564,
					19.02339759688433,
					"Magyarország",
					"1123",
					"Pest",
					"Budapest",
					"Nagyenyed u. 1",
					"hu-bu",
					companyRepository.findAll().get(1)

			));
			offices.add(new Office(
					"Aevum Thököly",
					"Magyarország,Budapest 1147, Thököly út 167.",
					47.518008662227416,
					19.110125808598365,
					"Magyarország",
					"1147",
					"Pest",
					"Budapest",
					"Thököly út 167.",
					"hu-bu",
					companyRepository.findAll().get(1)

			));
			offices.add(new Office(
					"Aevum Szivacs",
					"Magyarország,Budapest 1204, Szivacs utca 5.",
					47.44273647035911,
					19.112461183609113,
					"Magyarország",
					"1042",
					"Pest",
					"Budapest",
					"Szivacs utca 5.",
					"hu-bu",
					companyRepository.findAll().get(1)

			));
			offices.add(new Office(
					"Aevum Pap Károly",
					"Magyarország,Budapest 1139, Pap Károly u. 5.",
					47.53233069175092,
					19.07150345292552,
					"Magyarország",
					"1139",
					"Pest",
					"Budapest",
					"Pap Károly u. 5.",
					"hu-bu",
					companyRepository.findAll().get(1)

			));
			offices.add(new Office(
					"Aevum Bécsi",
					"Magyarország,Budapest 1032, Bécsi út 143.",
					47.53656095256181,
					19.03342072594215,
					"Magyarország",
					"1032",
					"Pest",
					"Budapest",
					"Bécsi út 143.",
					"hu-bu",
					companyRepository.findAll().get(1)

			));
			offices.add(new Office(
					"Aevum Debrecen Csapó",
					"Magyarország,Debrecen 4029, Csapó u. 53.",
					47.53354311350078,
					21.631736710597696,
					"Magyarország",
					"4029",
					"Hajdú-Bihar",
					"Debrecen",
					"Csapó u. 53",
					"hu-de",
					companyRepository.findAll().get(1)

			));
			offices.add(new Office(
					"Aevum Salgótarján füleki",
					"Magyarország, Salgótarján 3100, Füleki út 12.",
					48.11014806271663,
					19.811604520154262,
					"Magyarország",
					"3100",
					"Nógrád",
					"Salgótarján",
					"Füleki út 12.",
					"hu-no",
					companyRepository.findAll().get(1)
			));
			offices.add(new Office(
					"Szomorúfűz Nyíregyháza Dózsa",
					"Magyarország, Nyíregyháza 4400, Dózsa György u. 70.",
					47.96327969938218,
					21.720807950572443,
					"Magyarország",
					"4400",
					"Szabolcs-Szatmár-Bereg",
					"Nyíregyháza",
					"Dózsa György u. 70.",
					"hu-ny",
					companyRepository.findAll().get(1)
			));
			offices.add(new Office(
					"Aevum Békéscsaba Munkácsy",
					"Magyarország, Békéscsaba 5600, Munkácsy utca 9.",
					46.67829646726883,
					21.096902959533715,
					"Magyarország",
					"5600",
					"Békés",
					"Békéscsaba",
					"Munkácsy utca 9.",
					"hu-bc",
					companyRepository.findAll().get(1)
			));
			officeRepository.saveAll(offices);
		}
	}
}
