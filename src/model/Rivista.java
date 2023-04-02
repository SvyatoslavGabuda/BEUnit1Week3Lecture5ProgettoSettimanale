package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import utils.Periodicita;

@Getter
@Setter

@Entity
@Table(name = "riviste")
public class Rivista extends ElementoCatalogo {
	@Enumerated(EnumType.STRING)
	@Column(name = "periodicita")
	private Periodicita periodicita;

	public Rivista() {

	}

	public Rivista(String titolo, int annoPublicazione, int nPagine, Periodicita p) {
		super(titolo, annoPublicazione, nPagine);

		this.periodicita = p;
	}

	@Override
	public String toString() {
		return "Rivista [periodicita=" + periodicita + ", getISBN()=" + getISBN() + ", getTitolo()=" + getTitolo()
				+ ", getAnnoPublicazione()=" + getAnnoPublicazione() + ", getNPagine()=" + getNPagine() + "]";
	}

}
