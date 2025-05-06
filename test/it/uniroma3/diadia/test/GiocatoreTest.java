package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {

	private Giocatore giocatore;

	@BeforeEach
	void setUp() {
		this.giocatore = new Giocatore();
	}

	@Test
	public void testCostruttore() {
		assertEquals(20, this.giocatore.getCfu()); // Controlla i CFU iniziali
		assertNotNull(this.giocatore.getAttrezzi()); // Controlla che la borsa non sia null
	}

	@Test
	public void testSetGetCfu() {
		this.giocatore.setCfu(15);
		assertEquals(15, this.giocatore.getCfu()); // Deve restituire 15 dopo il set
	}

	@Test
	public void testSetGetAttrezzi() {
		Borsa nuovaBorsa = new Borsa();
		this.giocatore.setAttrezzi(nuovaBorsa);
		assertEquals(nuovaBorsa, this.giocatore.getAttrezzi()); // Deve restituire la nuova borsa
	}

}
