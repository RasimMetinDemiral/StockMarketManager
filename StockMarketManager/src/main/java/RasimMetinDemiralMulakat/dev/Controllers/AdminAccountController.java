package RasimMetinDemiralMulakat.dev.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import RasimMetinDemiralMulakat.dev.Model.Adminaccount;
import RasimMetinDemiralMulakat.dev.ProjectServices.AdminaccountService;


@Controller
public class AdminAccountController {

	
	
	@Autowired
	private AdminaccountService service;
	
	@RequestMapping("/") // localhosta girip ana projeyi çağırırken kullan
	public String viewHomePage(Model model) {
		
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		List<Adminaccount> listUsers = service.listall(); // tablo ekrana ilk geldiğinde databaseden verileri alıp // ekrana yansıtmak için kullandım
		
		for (Adminaccount user : listUsers) 
		{ 
			
			user.setPassword(encoder.encode(user.getPassword())); // oluştruduğum yeni hesaptaki şifreleri ekrana kriptolayarak yazdırmak için kullandım	
		}

		model.addAttribute("listUsers", listUsers); // list product
  
		return "index"; // index.html dosyası dönüyor ve ekrana listede bulunan değerler geliyor

	}

	
	// new account oluştrumak iiçin gerekli servis
	@RequestMapping("/new")
	public String showNewAcoountFrom(Model model) {
		Adminaccount users = new Adminaccount();
		model.addAttribute("users", users);
		return "new_account";
		
		
	}

	// oluşturulan new accountu kaydetmek ve ekrana geri dönmek için kullandım
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveAccount(@ModelAttribute("users") Adminaccount users) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // şifreyi kriptolayarak database e kaydettim
		users.setPassword(encoder.encode(users.getPassword()));
		users.setEnabled(true); // enable değerini true döndürüyorum 
		
		service.save(users); // save service çağırıldı
		return "redirect:/"; // user ekledikten sonra ana ekrana dönmek için ullandım
	}

	// edit işlemi çin çağırılan servis
	@RequestMapping("/edit/{user_id}")
	public ModelAndView showEditAcoountFrom(@PathVariable(name = "user_id") Long user_id) {
		ModelAndView mav = new ModelAndView("edit_account");
		Adminaccount users = service.get(user_id);
		mav.addObject("users", users);
		return mav;
	}

	@RequestMapping("/delete/{user_id}")
	public String deleteAccount(@PathVariable(name = "user_id") Long user_id) {

		service.delete(user_id); // delete servisi çağırdım

		return "redirect:/"; // account ekledikten sonra sayfayı yenilemek için kullandım
	}

	
	
	
	
	
	
	
}
