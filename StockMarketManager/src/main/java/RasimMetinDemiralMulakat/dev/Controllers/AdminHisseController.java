package RasimMetinDemiralMulakat.dev.Controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import RasimMetinDemiralMulakat.dev.Model.Adminhisse;
import RasimMetinDemiralMulakat.dev.ProjectServices.AdminhisseService;


@Controller

public class AdminHisseController {
	@Autowired
	private AdminhisseService service2;
	
	//admin hisse servisleri
	
	@RequestMapping("/list") 
	public String viewHomePage1(Model model1) {
		
		List<Adminhisse> listHisse= service2.listall(); // tablo ekrana ilk geldiğinde databaseden verileri alıp ekrana yansıtmak için kullandım
		model1.addAttribute("listHisse",listHisse); // list hisse
		
		return "index2"; // index2.html dosyası dönüyor ve ekrana listede bulunan değerler geliyor
			
	
	}
	
	// new hsse oluştrumak iiçin gerekli servis
		@RequestMapping("/newStock")
		public String showNewStockFrom(Model model) {
			Adminhisse adminhisse = new Adminhisse();
			Random rand = new Random(); // instance of random class
			int upperbound = 1000;
			int int_random = rand.nextInt(upperbound);
			adminhisse.setPrice((float)int_random);

			adminhisse.setDate(LocalDateTime.now()); // anlık datetime ı almak için kullandım new sstocck ekranına geldiğimizde default olarak değer gelsin diye
			model.addAttribute("adminhisse", adminhisse);
			return "new_hisse";
		}
	
	 
	
	
	// new account oluştrumak iiçin gerekli servis
	@RequestMapping(value = "/saveStock", method = RequestMethod.POST)
	public String saveStock(@ModelAttribute("adminhisse") Adminhisse adminhisse) {
        
		adminhisse.setDate(LocalDateTime.now());
		service2.saveStock(adminhisse); // save service çağırıldı

		return "redirect:/list"; // stock ekledikten sonra ana ekrana dönmek için ullandım
	}
	
	
	// edit işlemi çin çağırılan servis
		@RequestMapping("/editstock/{id}")
		public ModelAndView showEditStockFrom(@PathVariable(name = "id") Long id) {
			ModelAndView mav = new ModelAndView("edit_stock");
			Adminhisse adminhisse = service2.get(id);
			mav.addObject("adminhisse", adminhisse);
			return mav;
		}
	
		@RequestMapping("/deletestock/{id}")
		public String deleteStock(@PathVariable(name = "id") Long id) {

			service2.delete(id); // delete servisi çağırdım

			return "redirect:/list"; // stock account ekledikten sonra sayfayı yenilemek için kullandım
		}

}
