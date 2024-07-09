package hu.temetkezes.demo;

import hu.temetkezes.demo.models.*;
import hu.temetkezes.demo.repository.*;
//import hu.temetkezes.demo.services.UserService;
import hu.temetkezes.demo.services.FuneralServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	OfficeRepository officeRepository;
    @Autowired
    private CompanyRepository companyRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FuneralServiceRepository funeralServiceRepository;

	@Autowired
	private ContactRepository contactRepository;

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
	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			officeSeeder();
		};
	}

	public void officeSeeder(){
		String tel = "Telefon";
		String mobil = "Mobil";
		String email = "Email";
		String officemanager = "Iroda Vezető";
		String halottszal = "Halottszállítás";

		if (contactRepository.count() == 0){

			ArrayList<Contact> contacts = new ArrayList<>();
			//0
			contacts.add(new Contact(tel,"+3614136800","aevumdem"));
			//1
			contacts.add(new Contact(tel,"+3614301390","aevumbecsi"));
			//2
			contacts.add(new Contact(tel, "+3619190884","aevumarpad"));
			//3
			contacts.add(new Contact(tel, "+3612370240","aevumpap"));
			//4
			contacts.add(new Contact(email,"info@aveum.hu","aevumdem"));
			//5
			contacts.add(new Contact(email,"becsiut@aveum.hu","aevumbecsi"));
			//6
			contacts.add(new Contact(email,"arpadut@aveum.hu","aevumarpad"));
			//7
			contacts.add(new Contact(email,"papkarolyutca@aveum.hu","aevumpap"));
			//8
			contacts.add(new Contact(mobil, "+36703121383","aevumdeb"));
			//9
			contacts.add(new Contact(mobil, "+36305767216","aevumbecsi"));
			//10
			contacts.add(new Contact(mobil, "+36306645758","aevumarpad"));
			//11
			contacts.add(new Contact(mobil, "+36302535258","aevumpap"));
			//12
			contacts.add(new Contact(officemanager, "Tóth-Vass Réka","aevumdem"));
			//13
			contacts.add(new Contact(officemanager, "Wéber Szandra","aevumbecsi"));
			//14
			contacts.add(new Contact(officemanager,"Ostorházy Barbara","aveumarpad"));
			//15
			contacts.add(new Contact(officemanager,"Reményi Árpád","aveumpap"));
			//16
			contacts.add(new Contact(tel, "+3619190170","szomiz"));
			//17
			contacts.add(new Contact(mobil, "+36308471915","szomiz"));
			//18
			contacts.add(new Contact(tel,"+3619190171","szompest"));
			//19
			contacts.add(new Contact(mobil, "+36303137920","szompest"));
			//20
			contacts.add(new Contact(tel, "+3619190886","lelek"));
			//21
			contacts.add(new Contact(mobil,"+36302032300","lelek"));
			//22
			contacts.add(new Contact(tel,"+3619190172","szomtok"));
			//23
			contacts.add(new Contact(mobil,"+36309651783","szomtok"));
			//24
			contacts.add(new Contact(tel,"+3619190173","szomsziv"));
			//25
			contacts.add(new Contact(mobil,"+36305767206","szomsziv"));
			//26
			contacts.add(new Contact(email, "budapest@temetkezes.hu","szomiz"));
			//27
			contacts.add(new Contact(email, "budapest@temetkezes.hu","szompest"));
			//28
			contacts.add(new Contact(email, "budapest@temetkezes.hu","lelek"));
			//29
			contacts.add(new Contact(email, "budapest@temetkezes.hu","szomtok"));
			//30
			contacts.add(new Contact(email, "budapest@temetkezes.hu","szomsziv"));
			//31
			contacts.add(new Contact(tel,"+3617969561","gyaszbu"));
			//32
			contacts.add(new Contact(mobil,"+36308798970","gyaszbu"));
			//33
			contacts.add(new Contact(email,"info@gyaszhuszar.hu","gyaszbu"));
			//34
			contacts.add(new Contact(tel,"+3617202236","gyaszlen"));
			//35
			contacts.add(new Contact(mobil,"+36306335677","gyaszlen"));
			//36
			contacts.add(new Contact(email,"info@gyaszhuszar.hu","gyaszlen"));
			//37
			contacts.add(new Contact(mobil, "+36309476637","szomdeb"));
			//38
			contacts.add(new Contact(tel, "+3652871328","szomdeb"));
			//39
			contacts.add(new Contact(email,"debrecen@temetkezes.hu","szomdeb"));
			//40
			contacts.add(new Contact(tel,"+3632431544","rexsal"));
			//41
			contacts.add(new Contact(mobil,"+36309552137","rexsal"));
			//42
			contacts.add(new Contact(halottszal,"+36309552138","rexsal"));
			//43
			contacts.add(new Contact(email,"info@rexhumanum.hu","rexsal"));
			//44
			contacts.add(new Contact(officemanager,"Szilágyi Barnabás","rexsal"));
			//45
			contacts.add(new Contact(tel, "+3642781227","szomnyir"));
			//46
			contacts.add(new Contact(mobil, "+36309932110","szomnyir"));
			//47
			contacts.add(new Contact(email, "nyiregyhaza@temetkezes.hu","szomnyir"));
			//48
			contacts.add(new Contact(email, "bekescsaba@temetkezes.hu","bekes"));
			//49
			contacts.add(new Contact(tel,"+3666748088","bekes"));
			//50
			contacts.add(new Contact(mobil,"+36300846462","bekes"));

			contactRepository.saveAll(contacts);
		}


		if ( companyRepository.count() == 0){
			ArrayList<Company> companies = new ArrayList<>();
			companies.add(new Company("Szomorúfűz Temetkezés","szomfuz"));
			companies.add(new Company("Aevum Temetkezés","aevum"));
			companyRepository.saveAll(companies);
		}

		if (officeRepository.count() == 0) {
			ArrayList<Office> offices = new ArrayList<>();
			offices.add(new Office(
					"Aevum Temetkezés - Dembinszky",
					"aevumdem",
					"Magyarország, 1071 Budapest, Dembinszky utca 44.",
					47.50755608897227,
					19.082259008592498,
					"Magyarország",
					"1071",
					"Budapest",
					"Budapest",
					"Dembinszky utca 44.",
					"hu-bu",
					companyRepository.findAll().get(1),
					"https://aevumtemetkezes.hu",

					)
			);
			offices.add(new Office(
					"Aevum Temtkezés - Árpád",
					"aevumarpad",
					"Magyarország, 1042 Budapest, Árpád út 88.",
					47.56108163559133,
					19.09223152381951,
					"Magyarország",
					"1042",
					"Budapest",
					"Budapest",
					"Árpád út 88.",
					"hu-bu",
					companyRepository.findAll().stream().filter(company -> company.getShortName().equals("aevum")).toList().getFirst(),
					"https://aevumtemetkezes.hu",
					contactRepository.findAll().stream().filter(company ->
						company.getOfficeShortCode().equals("aevumarpad")
					).toList()
			));
			offices.add(new Office(
					"Szomorúfűz Temetkezés - Izabella utca",
					"szomiz",
					"Magyarország, 1064 Budapest, Izabella utca 65.",
					47.50884478894911,
					19.066047925940623,
					"Magyarország",
					"1064",
					"Budapest",
					"Budapest",
					"Izabella utca 65.",
					"hu-bu",
					companyRepository.findAll().get(1),
					"https://www.budapest-temetkezes.hu/"
					));
			offices.add(new Office(
					"Szomorúfűz Temetkezés - Pesti út",
					"szompest",
					"Magyarország, Budapest 1173, Pesti út 41/A.",
					47.48312983311757,
					19.238884639430985,
					"Magyarország",
					"1173",
					"Budapest",
					"Budapest",
					"Pesti út 41/A.",
					"hu-bu",
					companyRepository.findAll().stream().filter(company -> company.getShortName().equals("szomfuz")).toList().getFirst(),
					"https://www.budapest-temetkezes.hu"
			));
			offices.add(new Office(
					"Gyászhuszár Temetkezés - Lenhossék",
					"gyaszlen",
					"Magyarország, Budapest 1096, Lenhossék utca 33.",
					47.48072524137717,
					19.080378810594798,
					"Magyarország",
					"1096",
					"Budapest",
					"Budapest",
					"Lenhossék utca 33.",
					"hu-bu",
					companyRepository.findAll().get(1),
					"https://www.gyaszhuszar.hu"
			));
			offices.add(new Office(
					"Gyászhuszár Temetkezés - Budai",
					"gyaszbu",
					"Magyarország, Budapest 1114, Villányi út 6.",
					47.477960838544284,
					19.04509812593893,
					"Magyarország",
					"1114",
					"Budapest",
					"Budapest",
					"Villanyi út 6.",
					"hu-bu",
					companyRepository.findAll().get(1),
					"https://www.gyaszhuszar.hu"

			));
			offices.add(new Office(
					"Szomorúfűz Temetkezés - Ernő",
					"szomer",
					"Magyarország, Budapest 1096, Ernő u. 30-34.",
					47.47958894467054,
					19.085216554775098,
					"Magyarország",
					"1096",
					"Budapest",
					"Budapest",
					"Ernő u. 30-34.",
					"hu-bu",
					companyRepository.findAll().get(1),
					"https://www.budapest-temetkezes.hu"
			));
			offices.add(new Office(
					"Lélekhajó Temetkezés",
					"lelek",
					"Magyarország, Budapest 1123, Nagyenyed u. 1.",
					47.498757248209564,
					 19.02339759688433,
					"Magyarország",
					"1123",
					"Budapest",
					"Budapest",
					"Nagyenyed u. 1",
					"hu-bu",
					companyRepository.findAll().get(0),
					"https://www.budapest-temetkezes.hu"

			));

			offices.add(new Office(
					"Szomorúfűz Temetkezés - Thököly",
					"szomtok",
					"Magyarország, Budapest 1147, Thököly út 167.",
					47.518008662227416,
					19.110125808598365,
					"Magyarország",
					"1147",
					"Budapest",
					"Budapest",
					"Thököly út 167.",
					"hu-bu",
					companyRepository.findAll().get(1),
					"https://www.budapest-temetkezes.hu"

			));
			offices.add(new Office(
					"Szomorúfűz Temetkézés - Szivacs",
					"szomsziv",
					"Magyarország, Budapest 1204, Szivacs utca 5.",
					47.44273647035911,
					19.112461183609113,
					"Magyarország",
					"1042",
					"Budapest",
					"Budapest",
					"Szivacs utca 5.",
					"hu-bu",
					companyRepository.findAll().get(1),
					"https://www.budapest-temetkezes.hu/"

			));
			offices.add(new Office(
					"Aevum - Pap Károly",
					"aevumpap",
					"Magyarország, Budapest 1139, Pap Károly u. 5.",
					47.53233069175092,
					19.07150345292552,
					"Magyarország",
					"1139",
					"Budapest",
					"Budapest",
					"Pap Károly u. 5.",
					"hu-bu",
					companyRepository.findAll().get(1),
					"https://aevumtemetkezes.hu"

			));
			offices.add(new Office(
					"Aevum Temetkezés - Bécsi",
					"aevumbecsi",
					"Magyarország, Budapest 1032, Bécsi út 143.",
					47.53656095256181,
					19.03342072594215,
					"Magyarország",
					"1032",
					"Budapest",
					"Budapest",
					"Bécsi út 143.",
					"hu-bu",
					companyRepository.findAll().get(1),
					"https://aevumtemetkezes.hu"

			));
			offices.add(new Office(
					"Szomorúfűz Temetkezés - Debrecen",
					"szomdeb",
					"Magyarország, Debrecen 4029, Csapó u. 53.",
					47.53354311350078,
					21.631736710597696,
					"Magyarország",
					"4029",
					"Hajdú-Bihar",
					"Debrecen",
					"Csapó u. 53",
					"hu-de",
					companyRepository.findAll().get(1),
					"https://debrecen.temetkezes.hu"

			));
			offices.add(new Office(
					"Rex-Humánum - Salgótarján",
					"rexsal",
					"Magyarország, Salgótarján 3100, Füleki út 12.",
					48.11014806271663,
					19.811604520154262,
					"Magyarország",
					"3100",
					"Nógrád",
					"Salgótarján",
					"Füleki út 12.",
					"hu-no",
					companyRepository.findAll().get(1),
					"https://www.rexhumanum.hu"
			));
			offices.add(new Office(
					"Szomorúfűz Temetkezés - Nyíregyháza",
					"szomnyir",
					"Magyarország, Nyíregyháza 4400, Dózsa György u. 70.",
					47.96327969938218,
					21.720807950572443,
					"Magyarország",
					"4400",
					"Szabolcs-Szatmár-Bereg",
					"Nyíregyháza",
					"Dózsa György u. 70.",
					"hu-ny",
					companyRepository.findAll().get(1),
					"https://nyiregyhaza.temetkezes.hu"
			));
			offices.add(new Office(
					"Békéscsaba Temetkezés",
					"bekes",
					"Magyarország, Békéscsaba 5600, Munkácsy utca 9.",
					46.67829646726883,
					21.096902959533715,
					"Magyarország",
					"5600",
					"Békés",
					"Békéscsaba",
					"Munkácsy utca 9.",
					"hu-bc",
					companyRepository.findAll().get(1),
					"https://www.bekestemetkezes.hu"
			));

			officeRepository.saveAll(offices);
		}


		if (userRepository.count() == 0 ){
			User user = new User();
			user.setName("Spring Blog");
			user.setUsername("admin");
			user.setEmail("test@test.com");
			user.setPassword(new BCryptPasswordEncoder().encode("Aevum123789!"));
			user.setRole("SUPER_ADMIN");
			user.setBanned(false);
			user.setConfirmEmail(true);
			user.setActive(true);
			userRepository.save(user);
		}
		if (funeralServiceRepository.count() == 0 ) {
			ArrayList<FuneralService> funeralServices = new ArrayList<>();
			funeralServices.add(new FuneralService("Hamvasztás urnakiadás", "hamvurn", ""));
			funeralServices.add(new FuneralService("Hamvak szórása", "hamvszor", ""));
			funeralServices.add(new FuneralService("Hamvasztásos temetés", "hamvtem", ""));
			funeralServices.add(new FuneralService("Hajós temetés", "hajtem", ""));
			funeralServices.add(new FuneralService("Koporsós temetés", "koptem", ""));
			funeralServices.add(new FuneralService("Halottszállítás", "halszal", ""));
			funeralServices.add(new FuneralService("Nemzetközi temetés", "nemtem", ""));
			funeralServiceRepository.saveAll(funeralServices);
		}


	}
}
