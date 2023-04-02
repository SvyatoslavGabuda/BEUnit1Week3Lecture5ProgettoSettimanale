package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "prestiti")
@NamedQuery(name = "Prestito.findAll", query = "SELECT p FROM Prestito p")

public class Prestito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Utente utente;
	@OneToOne(mappedBy="prestato")

	private ElementoCatalogo el;
	private LocalDate dataInizioPrestito;
	private LocalDate dataRestituzionePrevista;
	private LocalDate dataRestituzioneEffettiva;

	public Prestito() {
	}

	public Prestito(Utente utente, ElementoCatalogo el, LocalDate dataInizioPrestito,
			 LocalDate dataRestituzioneEffettiva) {
		super();
		this.utente = utente;
		this.el = el;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrevista = this.dataInizioPrestito.plusDays(30);
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}
}
