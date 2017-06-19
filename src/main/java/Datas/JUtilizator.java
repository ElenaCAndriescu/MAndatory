package Datas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Utilizatori")
public class JUtilizator {

	public JUtilizator() {
	}

	public JUtilizator(int i, String nume) {
		this.id = i;
		this.nume = nume;
	}

	@Id @GeneratedValue
	private int id;

	@Column(name = "NUME_USERI", length = 225, nullable = false)
	private String nume;
	@Transient
	private String password;
	
	@OneToMany(mappedBy = "utilizator")
	  private List<JTranzactie> tranzactii;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}