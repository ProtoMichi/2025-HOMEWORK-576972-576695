package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

class ComandoPosaTest {

	private ComandoPosa comandoPosa;
	private Partita partita;
	private Attrezzo attrezzo;

	@BeforeEach
	void setUp(){
		comandoPosa = new ComandoPosa();
		partita = new Partita();
		Stanza stanza = new Stanza("Atrio");
		partita.setStanzaCorrente(stanza);

		attrezzo = new Attrezzo("chiave", 1);
		partita.getGiocatore().getAttrezzi().addAttrezzo(attrezzo);
	}

	@Test
	public void testPosaAttrezzoPresente() {
		comandoPosa.setParametro("chiave");
		comandoPosa.esegui(partita);

		assertNull(partita.getGiocatore().getAttrezzi().getAttrezzo("chiave"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("chiave"));
	}

	@Test
	public void testPosaAttrezzoNonPresente() {
		comandoPosa.setParametro("lanterna");
		comandoPosa.esegui(partita);

		assertNull(partita.getStanzaCorrente().getAttrezzo("lanterna"));
		assertNotNull(partita.getGiocatore().getAttrezzi().getAttrezzo("chiave"));  // chiave è ancora lì
	}

	@Test
	public void testParametroNull() {
		comandoPosa.setParametro(null);
		comandoPosa.esegui(partita);

		assertTrue(partita.getGiocatore().getAttrezzi().hasAttrezzo("chiave"));  // nulla è stato tolto
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("chiave"));       // nulla è stato posato
	}
}
