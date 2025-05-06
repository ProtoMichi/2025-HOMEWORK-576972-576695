package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

class ComandoVaiTest {

	private ComandoVai comandoVai;
	private Partita partita;
	private Stanza stanzaIniziale;
	private Stanza stanzaAdiacente;

	@BeforeEach
	void setUp(){
		comandoVai = new ComandoVai();
		partita = new Partita();
		stanzaIniziale = new Stanza("Inizio");
		stanzaAdiacente = new Stanza("Biblioteca");
		stanzaIniziale.impostaStanzaAdiacente("nord", stanzaAdiacente);
		partita.setStanzaCorrente(stanzaIniziale);
		partita.getGiocatore().setCfu(10);
		comandoVai.setIO(new IOConsole());
	}

	@Test
	public void testVaiInDirezioneValida() {
		comandoVai.setParametro("nord");
		comandoVai.esegui(partita);
		assertEquals("Biblioteca", partita.getStanzaCorrente().getNome());
		assertEquals(9, partita.getGiocatore().getCfu());  // Verifica decremento CFU
	}

	@Test
	public void testVaiInDirezioneInesistente() {
		comandoVai.setParametro("sud");
		comandoVai.esegui(partita);
		assertEquals("Inizio", partita.getStanzaCorrente().getNome());  // Non si muove
		assertEquals(10, partita.getGiocatore().getCfu());  // CFU non decrementati
	}

	@Test
	public void testDirezioneNull() {
		comandoVai.setParametro(null);
		comandoVai.esegui(partita);
		assertEquals("Inizio", partita.getStanzaCorrente().getNome());
		assertEquals(10, partita.getGiocatore().getCfu());  // Nessun decremento
	}
}
