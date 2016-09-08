package co.za.Reverside.asignment;

import co.za.Reverside.asignment.Domain.User;
import co.za.Reverside.asignment.Services.service.impl.UserDefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ZeroSolutionAppApplication {
	@Autowired
	private UserDefaultService userDefaultService;

	public static void main(String[] args) {
		SpringApplication.run(ZeroSolutionAppApplication.class, args);
	}
//	@PostConstruct
//	public void save()
//	{
//		User user =new User();
//		user.setCellnumber("0790346842");
//		user.setEmail("mlu@gmail.com");
//		user.setFirstName("Mlungisi");
//		user.setLastName("Mhlongo");
//		user.setPassword("07272");
//		user.setGender("Male");
//
//		System.out.println("successfully registered");
//		userDefaultService.save(user);
//
//		//System.out.println("");
//	}
}
