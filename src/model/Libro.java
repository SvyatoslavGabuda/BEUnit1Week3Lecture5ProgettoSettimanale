package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@Entity
@Table(name= "libri")
public class Libro extends ElementoCatalogo {
	@Column(name="autore")
	private String autore;
	@Column(name="genere")
	private String genere;
	
	
	public Libro() {
		super();
		
	}
	public Libro( String titolo, int annoPublicazione, int nPagine,String autore,String genere) {
		super( titolo, annoPublicazione, nPagine);
		this.genere=genere;
		this.autore=autore;
	}
	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + ", getISBN()=" + getISBN() + ", getTitolo()="
				+ getTitolo() + ", getAnnoPublicazione()=" + getAnnoPublicazione() + ", getNPagine()=" + getNPagine()
				+ "]";
	}

}
