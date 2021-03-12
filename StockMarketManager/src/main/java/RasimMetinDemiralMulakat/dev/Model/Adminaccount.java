package RasimMetinDemiralMulakat.dev.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Adminaccount {

	private Long user_id; // OLUŞTRUDUĞUMUZ DEĞERLER DATABASEDKİ DEĞERLER İLE AYNI çünkü constructor
							// classı datebaseden alıyor verileri
	private String name;
	private String surname;
	private String email;
	private String usertype;
	private String username;
	private String password;
	private boolean enabled;

	public Adminaccount() {
		super();
		// contructor methodu kullandım ilk ekrana basılacak olan databse verilerini
		// döndürmesi için
	}

	@Id // databaseden jpa kullanark verileri almak için kullandım ve primary colum
		// olduğu için
	@GeneratedValue(strategy = GenerationType.IDENTITY) // primary id column için kullandım
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
