package Datas;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Tranzactii")
public class JTranzactie {

	// constructors

	public JTranzactie() {
	}

	public JTranzactie(int iD, JUtilizator user, int suma, String titlu, boolean recurent, String tip, String categorie,
			Date data) {
		super();
		ID = iD;
		this.utilizator = user;
		this.suma = suma;
		this.titlu = titlu;
		this.recurent = recurent;
		this.tip = tip;
		this.categorie = categorie;
		this.data = data;
	}

	// attributes

	@Id
	@GeneratedValue
	private int ID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UTILIZATOR_ID")
	private JUtilizator utilizator;

	@Column(name = "SUMA", nullable = false)
	private int suma;

	@Column(name = "TITLU", nullable = false)
	private String titlu;

	@Column(name = "RECURENT", nullable = false)
	private boolean recurent;

	@Column(name = "TIP", nullable = false)
	private String tip;

	@Column(name = "CATEGORIE", nullable = false)
	private String categorie;

	@Temporal(TemporalType.DATE)
	private Date data;

	// getters and setters

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public JUtilizator getUser() {
		return utilizator;
	}

	public void setUser(JUtilizator user) {
		this.utilizator = user;
	}

	public int getSuma() {
		return suma;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}

	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public boolean isRecurent() {
		return recurent;
	}

	public void setRecurent(boolean recurent) {
		this.recurent = recurent;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
