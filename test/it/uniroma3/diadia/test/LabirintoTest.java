package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class LabirintoTest {
	private Labirinto labirinto;

	@BeforeEach
	void setUp(){
		this.labirinto = new Labirinto();
	}

	@Test
	public void testCostruttore() {
		assertNotNull(this.labirinto.getEntrata()); 
		assertEquals("Atrio", this.labirinto.getEntrata().getNome());
		assertNotNull(this.labirinto.getUscita()); 
		assertEquals("Biblioteca", this.labirinto.getUscita().getNome());
	}

	@Test
	public void testGetEntrata() {
		assertEquals("Atrio", this.labirinto.getEntrata().getNome());
	}

	@Test
	public void testGetUscita() {
		assertEquals("Biblioteca", this.labirinto.getUscita().getNome());
	}

	@Test
	public void testSetEntrata() {
		Stanza nuovaEntrata = new Stanza("Ingresso");
		this.labirinto.setEntrata(nuovaEntrata);
		assertEquals("Ingresso", this.labirinto.getEntrata().getNome()); 
	}

	@Test
	public void testSetUscita() {
		Stanza nuovaUscita = new Stanza("Corridoio");
		this.labirinto.setUscita(nuovaUscita);
		assertEquals("Corridoio", this.labirinto.getUscita().getNome()); 
	}

	@Test
	public void testCollegamentiStanze() {
		Stanza atrio = this.labirinto.getEntrata();

		assertEquals("Biblioteca", atrio.getStanzaAdiacente("nord").getNome());
		assertEquals("Aula N11", atrio.getStanzaAdiacente("est").getNome());
		assertEquals("Aula N10", atrio.getStanzaAdiacente("sud").getNome());
		assertEquals("Laboratorio Campus", atrio.getStanzaAdiacente("ovest").getNome());
	}

	@Test
	public void testAttrezziNelleStanze() {
		Stanza aulaN10 = this.labirinto.getEntrata().getStanzaAdiacente("sud");
		assertNotNull(aulaN10.getAttrezzo("lanterna"));

		Stanza atrio = this.labirinto.getEntrata();
		assertNotNull(atrio.getAttrezzo("osso"));
	}



}
