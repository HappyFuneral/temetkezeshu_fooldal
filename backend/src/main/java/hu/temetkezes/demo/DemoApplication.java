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
			companySeeder();
			funeralserviceSeeder();
			contactSeeder();
			officeSeeder();
		};
	}

	public void funeralserviceSeeder(){
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

	public void contactSeeder(){
		if (contactRepository.count() == 0){
			String tel = "Telefon";
			String mobil = "Mobil";
			String email = "Email";
			String officemanager = "Iroda Vezető";
			String halottszal = "Halottszállítás";

			String p = "phone";
			String e = "email";


			ArrayList<Contact> contacts = new ArrayList<>();
			//0
			contacts.add(new Contact(tel,"+3614136800","aevumdem",p));
			//1
			contacts.add(new Contact(tel,"+3614301390","aevumbecsi",p));
			//2
			contacts.add(new Contact(tel, "+3619190884","aevumarpad",p));
			//3
			contacts.add(new Contact(tel, "+3612370240","aevumpap",p));
			//4
			contacts.add(new Contact(email,"info@aveum.hu","aevumdem",e));
			//5
			contacts.add(new Contact(email,"becsiut@aveum.hu","aevumbecsi",e));
			//6
			contacts.add(new Contact(email,"arpadut@aveum.hu","aevumarpad",e));
			//7
			contacts.add(new Contact(email,"papkarolyutca@aveum.hu","aevumpap",e));
			//8
			contacts.add(new Contact(mobil, "+36703121383","aevumdem",p));
			//9
			contacts.add(new Contact(mobil, "+36305767216","aevumbecsi",p));
			//10
			contacts.add(new Contact(mobil, "+36306645758","aevumarpad",p));
			//11
			contacts.add(new Contact(mobil, "+36302535258","aevumpap",p));
			//12
			contacts.add(new Contact(officemanager, "Tóth-Vass Réka","aevumdem"));
			//13
			contacts.add(new Contact(officemanager, "Wéber Szandra","aevumbecsi"));
			//14
			contacts.add(new Contact(officemanager,"Ostorházy Barbara","aevumarpad"));
			//15
			contacts.add(new Contact(officemanager,"Reményi Árpád","aevumpap"));
			//16
			contacts.add(new Contact(tel, "+3619190170","szomiz",p));
			//17
			contacts.add(new Contact(mobil, "+36308471915","szomiz",p));
			//18
			contacts.add(new Contact(tel,"+3619190171","szompest",p));
			//19
			contacts.add(new Contact(mobil, "+36303137920","szompest",p));
			//20
			contacts.add(new Contact(tel, "+3619190886","lelek",p));
			//21
			contacts.add(new Contact(mobil,"+36302032300","lelek",p));
			//22
			contacts.add(new Contact(tel,"+3619190172","szomtok",p));
			//23
			contacts.add(new Contact(mobil,"+36309651783","szomtok",p));
			//24
			contacts.add(new Contact(tel,"+3619190173","szomsziv",p));
			//25
			contacts.add(new Contact(mobil,"+36305767206","szomsziv",p));
			//26
			contacts.add(new Contact(email, "budapest@temetkezes.hu","szomiz",e));
			//27
			contacts.add(new Contact(email, "budapest@temetkezes.hu","szompest",e));
			//28
			contacts.add(new Contact(email, "budapest@temetkezes.hu","lelek",e));
			//29
			contacts.add(new Contact(email, "budapest@temetkezes.hu","szomtok",e));
			//30
			contacts.add(new Contact(email, "budapest@temetkezes.hu","szomsziv",e));
			//31
			contacts.add(new Contact(tel,"+3617969561","gyaszbu",p));
			//32
			contacts.add(new Contact(mobil,"+36308798970","gyaszbu",p));
			//33
			contacts.add(new Contact(email,"info@gyaszhuszar.hu","gyaszbu",e));
			//34
			contacts.add(new Contact(tel,"+3617202236","gyaszlen",p));
			//35
			contacts.add(new Contact(mobil,"+36306335677","gyaszlen",p));
			//36
			contacts.add(new Contact(email,"info@gyaszhuszar.hu","gyaszlen",e));
			//37
			contacts.add(new Contact(mobil, "+36309476637","szomdeb",p));
			//38
			contacts.add(new Contact(tel, "+3652871328","szomdeb",p));
			//39
			contacts.add(new Contact(email,"debrecen@temetkezes.hu","szomdeb",e));
			//40
			contacts.add(new Contact(tel,"+3632431544","rexsal",p));
			//41
			contacts.add(new Contact(mobil,"+36309552137","rexsal",p));
			//42
			contacts.add(new Contact(halottszal,"+36309552138","rexsal",p));
			//43
			contacts.add(new Contact(email,"info@rexhumanum.hu","rexsal",e));
			//44
			contacts.add(new Contact(officemanager,"Szilágyi Barnabás","rexsal"));
			//45
			contacts.add(new Contact(tel, "+3642781227","szomnyir",p));
			//46
			contacts.add(new Contact(mobil, "+36309932110","szomnyir",p));
			//47
			contacts.add(new Contact(email, "nyiregyhaza@temetkezes.hu","szomnyir",e));
			//48
			contacts.add(new Contact(email, "bekescsaba@temetkezes.hu","bekes",e));
			//49
			contacts.add(new Contact(tel,"+3666748088","bekes",p));
			//50
			contacts.add(new Contact(mobil,"+36300846462","bekes",p));

			contactRepository.saveAll(contacts);
		}
	}

	public void companySeeder(){
		if ( companyRepository.count() == 0){
			ArrayList<Company> companies = new ArrayList<>();
			companies.add(new Company("Szomorúfűz Temetkezés","szomfuz"));
			companies.add(new Company("Aevum Temetkezés","aevum"));
			companies.add(new Company("Gyászhuszár Temetkezés","gyaszhusz"));
			companies.add(new Company("Rex-Humánum Temetkezés","rex"));
			companies.add(new Company("Békés Temetkezés","bekes"));

			companyRepository.saveAll(companies);
		}
	}

	public void officeSeeder(){

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
					companyRepository.findAll().stream().filter(
							company -> company.getShortName().equals("aevum")
					).toList().getFirst(),
					"https://aevumtemetkezes.hu",
					contactRepository.findAll().stream().filter(contact ->
							contact.getOfficeShortCode().equals("aevumdem")
					).toList()
			));
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
					companyRepository.findAll().stream().filter(
							company -> company.getShortName().equals("aevum")
					).toList(
					).getFirst(),
					"https://aevumtemetkezes.hu",
					contactRepository.findAll().stream().filter(contact ->
						contact.getOfficeShortCode().equals("aevumarpad")
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
					companyRepository.findAll().stream().filter(
							company -> company.getShortName().equals("szomfuz")
					).toList(
					).getFirst(),
					"https://www.budapest-temetkezes.hu/",
					contactRepository.findAll().stream().filter(contact ->
							contact.getOfficeShortCode().equals("szomiz")
					).toList()
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
					companyRepository.findAll()
							.stream().filter(company -> company.getShortName().equals("szomfuz")).toList().getFirst(),
					"https://www.budapest-temetkezes.hu",
					contactRepository.findAll().stream().filter(contact ->
							contact.getOfficeShortCode().equals("szompest")
					).toList()

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
					companyRepository.findAll().stream().filter(
							company -> company.getShortName().equals("gyaszhusz")
					).toList().getFirst(),					"https://www.gyaszhuszar.hu",
					contactRepository.findAll().stream().filter(contact ->
							contact.getOfficeShortCode().equals("gyaszlen")
					).toList()
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
					companyRepository.findAll().stream().filter(
							company -> company.getShortName().equals("gyaszhusz")
					).toList().getFirst(),
					"https://www.gyaszhuszar.hu",
					contactRepository.findAll().stream().filter(contact ->
							contact.getOfficeShortCode().equals("gyaszbu")
					).toList()

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
					companyRepository.findAll().stream().filter(
							company -> company.getShortName().equals("szomfuz")
					).toList().getFirst(),
					"https://www.budapest-temetkezes.hu",
					contactRepository.findAll().stream().filter(contact ->
							contact.getOfficeShortCode().equals("szomer")
					).toList()
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
					companyRepository.findAll().stream().filter(
							company -> company.getShortName().equals("szomfuz")
					).toList().getFirst(),
					"https://lelekhajotemetkezes.hu",
					contactRepository.findAll().stream().filter(contact ->
							contact.getOfficeShortCode().equals("lelek")
					).toList()

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
					companyRepository.findAll().stream().filter(
							company -> company.getShortName().equals("szomfuz")
					).toList().getFirst(),
					"https://www.budapest-temetkezes.hu",
					contactRepository.findAll().stream().filter(contact ->
							contact.getOfficeShortCode().equals("szomtok")
					).toList()
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
					companyRepository.findAll().stream().filter(
							company -> company.getShortName().equals("szomfuz")
					).toList().getFirst(),
					"https://www.budapest-temetkezes.hu/",
					contactRepository.findAll().stream().filter(contact ->
							contact.getOfficeShortCode().equals("szomsziv")
					).toList()
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
					companyRepository.findAll().stream().filter(
							company -> company.getShortName().equals("aevum")
					).toList(
					).getFirst(),
					"https://aevumtemetkezes.hu",
					contactRepository.findAll().stream().filter(contact ->
							contact.getOfficeShortCode().equals("aevumpap")
					).toList()
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
					companyRepository.findAll().stream().filter(
							company -> company.getShortName().equals("aevum")
					).toList(
					).getFirst(),
					"https://aevumtemetkezes.hu",
					contactRepository.findAll().stream().filter(contact ->
							contact.getOfficeShortCode().equals("aevumbecsi")
					).toList()

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
					companyRepository.findAll().stream().filter(
							company -> company.getShortName().equals("szomfuz")
					).toList(
					).getFirst(),
					"https://debrecen.temetkezes.hu",
					contactRepository.findAll().stream().filter(contact ->
							contact.getOfficeShortCode().equals("szomdeb")
					).toList()

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
					companyRepository.findAll().stream().filter(
							company -> company.getShortName().equals("rex")
					).toList().getFirst(),
					"https://www.rexhumanum.hu",
					contactRepository.findAll().stream().filter(contact ->
							contact.getOfficeShortCode().equals("rexsal")
					).toList()
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
					companyRepository.findAll().stream().filter(
							company -> company.getShortName().equals("szomfuz")
					).toList(
					).getFirst(),
					"https://nyiregyhaza.temetkezes.hu",
					contactRepository.findAll().stream().filter(contact ->
							contact.getOfficeShortCode().equals("szomnyir")
					).toList()
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
					companyRepository.findAll().stream().filter(
							company -> company.getShortName().equals("bekes")
					).toList().getFirst(),
					"https://www.bekestemetkezes.hu",
					contactRepository.findAll().stream().filter(contact ->
							contact.getOfficeShortCode().equals("bekes")
					).toList()
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



	}
}
