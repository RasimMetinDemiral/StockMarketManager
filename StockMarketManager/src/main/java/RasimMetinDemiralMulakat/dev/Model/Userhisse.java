package RasimMetinDemiralMulakat.dev.Model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userhisse")
public class Userhisse {

	private Long id; // OLUŞTRUDUĞUMUZ DEĞERLER DATABASEDKİ DEĞERLER İLE AYNI çünkü constructor
						// classı datebaseden alıyor verileri
	private String code;
	private String name;
	private Long amount;
	private float totalprice;

	public Userhisse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id // databaseden jpa kullanark verileri almak için kullandım ve primary colum
		// olduğu için
	@GeneratedValue(strategy = GenerationType.IDENTITY) // primary id column için kullandım
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

}
