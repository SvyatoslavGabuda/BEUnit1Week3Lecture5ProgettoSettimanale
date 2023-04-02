package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name= "catalogo_biblioteca")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name="ElementoCatalogo.findAll", query = "SELECT a FROM ElementoCatalogo a")
public abstract class ElementoCatalogo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id_isbn")
	private long ISBN;
	private String titolo;
	private int annoPublicazione;
	private int nPagine;
	@OneToOne
	private Prestito prestato;

	public ElementoCatalogo() {
	}

	

	public ElementoCatalogo( String titolo, int annoPublicazione, int nPagine) {
		super();
	
		this.titolo = titolo;
		this.annoPublicazione = annoPublicazione;
		this.nPagine = nPagine;
	}

}
