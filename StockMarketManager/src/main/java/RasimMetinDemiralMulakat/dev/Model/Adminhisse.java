package RasimMetinDemiralMulakat.dev.Model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "adminhisse")
public class Adminhisse {

	private Long id;
	private String code;
	private String name;
	private float price;

	
	@Temporal(TemporalType.DATE)
	@Column(name = "date") // database e system date değerini almam için gerrekli anotasyon
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime date;
	public Adminhisse() {
		super();
	}

	@Id // databaseden jpa kullanark verileri almak için kullandım ve primary colum
		// olduğu için
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	

	

}
