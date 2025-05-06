package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoAiuto;
import it.uniroma3.diadia.comandi.ComandoFine;
import it.uniroma3.diadia.comandi.ComandoGuarda;
import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica fabbrica;
	private IO io;

	@BeforeEach
	public void setUp() {
		this.fabbrica = new FabbricaDiComandiFisarmonica();
		this.io = new IOConsole();  // O una finta/mock se disponibile
	}

	@Test
	public void testComandoVai() {
		Comando c = fabbrica.costruisciComando("vai nord", io);
		assertTrue(c instanceof ComandoVai);
		assertEquals("nord", c.getParametro());
	}

	@Test
	public void testComandoPrendi() {
		Comando c = fabbrica.costruisciComando("prendi chiave", io);
		assertTrue(c instanceof ComandoPrendi);
		assertEquals("chiave", c.getParametro());
	}

	@Test
	public void testComandoPosa() {
		Comando c = fabbrica.costruisciComando("posa lanterna", io);
		assertTrue(c instanceof ComandoPosa);
		assertEquals("lanterna", c.getParametro());
	}

	@Test
	public void testComandoAiuto() {
		Comando c = fabbrica.costruisciComando("aiuto", io);
		assertTrue(c instanceof ComandoAiuto);
		assertNull(c.getParametro());
	}

	@Test
	public void testComandoFine() {
		Comando c = fabbrica.costruisciComando("fine", io);
		assertTrue(c instanceof ComandoFine);
	}

	@Test
	public void testComandoGuarda() {
		Comando c = fabbrica.costruisciComando("guarda", io);
		assertTrue(c instanceof ComandoGuarda);
	}

	@Test
	public void testComandoNonValido() {
		Comando c = fabbrica.costruisciComando("balla", io);
		assertTrue(c instanceof ComandoNonValido);
	}

	@Test
	public void testComandoVuoto() {
		Comando c = fabbrica.costruisciComando("", io);
		assertTrue(c instanceof ComandoNonValido);
	}

	@Test
	public void testComandoNull() {
		Comando c = fabbrica.costruisciComando(null, io);
		assertTrue(c instanceof ComandoNonValido);
	}

}
