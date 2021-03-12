package RasimMetinDemiralMulakat.dev.ProjectServices;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RasimMetinDemiralMulakat.dev.Model.Adminaccount;
import RasimMetinDemiralMulakat.dev.Repositories.AdminaccountRespository;



@Service
public class AdminaccountService {
	
	@Autowired
	private AdminaccountRespository repo;
	
	
	public List<Adminaccount> listall(){
		
		return repo.findAll();
	}
	
	public void save(Adminaccount users) {
		repo.save(users);
	}
	
	public Adminaccount get(Long user_id) {
		return repo.findById(user_id).get();
	}
	
	
	public void delete(Long user_id) {
		repo.deleteById(user_id);
	}
}
