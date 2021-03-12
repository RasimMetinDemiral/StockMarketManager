package RasimMetinDemiralMulakat.dev;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenaator {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword= "123"; // kend oluştruduğun databasedeki şifreyi koyabilirsin
		String encodedPassword = encoder.encode(rawPassword); // methodu çağırdım yukarıdaki değişkeni methoda gönderdim
		
		System.out.println(encodedPassword); // ekrana test için yazdırdım

	}

}
