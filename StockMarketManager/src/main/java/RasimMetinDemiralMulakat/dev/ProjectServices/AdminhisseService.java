package RasimMetinDemiralMulakat.dev.ProjectServices;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RasimMetinDemiralMulakat.dev.Model.Adminhisse;
import RasimMetinDemiralMulakat.dev.Repositories.AdminhisseRespository;


@Service
public class AdminhisseService {
	
	
	@Autowired
	private AdminhisseRespository repo2;
	
	public List<Adminhisse> listall(){
		
		return repo2.findAll();
	}
	
	public void saveStock(Adminhisse adminhisse) {
		
		repo2.save(adminhisse);
	}
	
	public Adminhisse get(Long id) {
		return repo2.findById(id).get();
	}
	
	
	public void delete(Long id) {
		repo2.deleteById(id);
	}
	

	
	
	
}
