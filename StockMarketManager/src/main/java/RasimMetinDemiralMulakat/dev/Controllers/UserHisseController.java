package RasimMetinDemiralMulakat.dev.Controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import RasimMetinDemiralMulakat.dev.Model.Adminaccount;
import RasimMetinDemiralMulakat.dev.Model.Adminhisse;
import RasimMetinDemiralMulakat.dev.Model.Userhisse;
import RasimMetinDemiralMulakat.dev.ProjectServices.AdminaccountService;
import RasimMetinDemiralMulakat.dev.ProjectServices.AdminhisseService;
import RasimMetinDemiralMulakat.dev.ProjectServices.UserhisseService;

@Controller
public class UserHisseController {

	@Autowired
	private UserhisseService service3;

	@RequestMapping("/NewStockPurchase")
	public String viewHomePage3(Model model2) {

		List<Userhisse> alimsatimlist = service3.listall(); // tablo ekrana ilk geldiğinde databaseden verileri alıp
															// ekrana yansıtmak için kullandım
		model2.addAttribute("alimsatimlist", alimsatimlist); // list hisse

		return "index3";

	}

	@RequestMapping("/newhisseAlim")
	public String showNewhissAlımFrom(Model model) {
		Userhisse userhisse = new Userhisse();

		Random rand = new Random(); // instance of random class
		int upperbound = 1000;
		int int_random = rand.nextInt(upperbound);
		userhisse.setTotalprice((float) int_random);

		model.addAttribute("userhisse", userhisse);
		return "new_hisse_alım";
	}

	@RequestMapping(value = "/savehisse", method = RequestMethod.POST)
	public String savehisse(@ModelAttribute("savehisse") Userhisse savehisse) {

		savehisse.setTotalprice((float) savehisse.getAmount() * (float) savehisse.getTotalprice());
		service3.savehisse(savehisse); // save service çağırıldı
		return "redirect:/NewStockPurchase"; // stock ekledikten sonra ana ekrana dönmek için ullandım

	}

	@RequestMapping("/deletehisse/{id}")
	public String deleteHisse(@PathVariable(name = "id") Long id) {

		service3.delete(id); // delete servisi çağırdım

		return "redirect:/NewStockPurchase"; // stock account ekledikten sonra sayfayı yenilemek için kullandım
	}

}
