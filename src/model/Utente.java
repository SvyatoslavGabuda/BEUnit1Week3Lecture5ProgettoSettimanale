package model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "utenti")
@NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u")
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utente")
	private long id;
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	@Column(name = "tessera", nullable = false, unique = true)
	private Long numeroTessara;


	public Utente() {
	}

	public Utente(String nome, String cognome, LocalDate dataDiNascita, Long numeroTessara) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.numeroTessara = numeroTessara;
	}

}
