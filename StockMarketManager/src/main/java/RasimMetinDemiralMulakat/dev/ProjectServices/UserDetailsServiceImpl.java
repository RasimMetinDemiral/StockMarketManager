package RasimMetinDemiralMulakat.dev.ProjectServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import RasimMetinDemiralMulakat.dev.Model.MyUserDetails;
import RasimMetinDemiralMulakat.dev.Model.User;
import RasimMetinDemiralMulakat.dev.Repositories.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.getUserByUsername(username);

		if (user == null) {

			throw new UsernameNotFoundException("could not found user");

		}

		return new MyUserDetails(user);
	}

}
