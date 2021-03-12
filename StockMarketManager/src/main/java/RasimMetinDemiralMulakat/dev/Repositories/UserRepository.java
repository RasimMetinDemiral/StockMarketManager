package RasimMetinDemiralMulakat.dev.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import RasimMetinDemiralMulakat.dev.Model.User;

public interface UserRepository extends CrudRepository<User, Integer> {  // user classda id yi ne taımladıysan o olmalı
	
	
	@Query("SELECT u FROM User u WHERE u.username= :username")
	public User getUserByUsername(@Param("username") String username);
}
