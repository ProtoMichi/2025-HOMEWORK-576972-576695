package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {

	private Partita partita;

	@BeforeEach
	void setUp(){
		this.partita = new Partita();
	}

	
	@Test
	void testVintaFalse() {
		assertFalse(partita.vinta());
	}

	@Test
	void testVintaTrue() {
		Stanza corrente = this.partita.getStanzaVincente();
		this.partita.setStanzaCorrente(corrente);
		assertTrue(this.partita.vinta());
	}

	@Test
	void testVintaNonVinta() {
		Stanza corrente = new Stanza("StanzaNonVincente");
		this.partita.setStanzaCorrente(corrente);
		assertFalse(this.partita.vinta());
	}

	@Test
	void testIsFinitaVinta() {
		Stanza corrente = this.partita.getStanzaVincente();
		this.partita.setStanzaCorrente(corrente);
		assertTrue(this.partita.isFinita());
	}

	@Test
	void testIsFinitaCfuZero() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}

	@Test
	void testIsFinitaNonFinita() {
		assertFalse(this.partita.isFinita());
	}
}