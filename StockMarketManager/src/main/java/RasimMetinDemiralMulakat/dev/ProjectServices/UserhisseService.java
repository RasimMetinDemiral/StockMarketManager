package RasimMetinDemiralMulakat.dev.ProjectServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RasimMetinDemiralMulakat.dev.Model.Userhisse;
import RasimMetinDemiralMulakat.dev.Repositories.UserhisseRepository;

@Service
public class UserhisseService {

	@Autowired
	private UserhisseRepository repo3;

	public List<Userhisse> listall() {

		return repo3.findAll();
	}

	public void savehisse(Userhisse Userhisse) {

		repo3.save(Userhisse);
	}

	public Userhisse get(Long id) {
		return repo3.findById(id).get();
	}

	public void delete(Long id) {
		repo3.deleteById(id);
	}

}
