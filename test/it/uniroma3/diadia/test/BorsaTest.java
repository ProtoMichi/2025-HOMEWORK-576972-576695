package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {
	private Borsa borsa;
	private Attrezzo attrezzo1;


	@BeforeEach
	void setUp(){
		this.borsa = new Borsa();
		this.attrezzo1 = new Attrezzo("martello", 3);
	}

	@Test
	public void testCostruttore() {
		assertEquals(10, this.borsa.getPesoMax());
		assertTrue(this.borsa.isEmpty());
	}

	@Test
	public void testAddAttrezzoSuccess() {
		assertTrue(this.borsa.addAttrezzo(attrezzo1));
		assertTrue(this.borsa.hasAttrezzo("martello"));
		assertEquals(3, this.borsa.getPeso());
	}

	@Test
	public void testAddAttrezzoTroppoPesante() {
		Borsa borsaPiccola = new Borsa(2);
		assertFalse(borsaPiccola.addAttrezzo(attrezzo1)); 
		assertFalse(borsaPiccola.hasAttrezzo("martello")); 
	}

	@Test
	public void testGetAttrezzoPresente() {
		this.borsa.addAttrezzo(this.attrezzo1);
		assertEquals(this.attrezzo1, this.borsa.getAttrezzo("martello"));
	}

	@Test
	public void testGetAttrezzoNonPresente() {
		assertNull(this.borsa.getAttrezzo("cacciavite"));
	}

	@Test
	public void testRemoveAttrezzoSuccess() {
		this.borsa.addAttrezzo(attrezzo1);
		assertNotNull(this.borsa.removeAttrezzo("martello"));
		assertFalse(this.borsa.hasAttrezzo("martello")); 
		assertEquals(0, this.borsa.getPeso());
	}

	@Test
	public void testRemoveAttrezzoNonPresente() {
		assertNull(this.borsa.removeAttrezzo("cacciavite"));
	}

	@Test
	public void testIsEmpty() {
		assertTrue(this.borsa.isEmpty()); 
		this.borsa.addAttrezzo(this.attrezzo1);
		assertFalse(this.borsa.isEmpty()); 
	}

	@Test
	public void testToStringBorsaVuota() {
		assertEquals("Borsa vuota", borsa.toString());
	}

	@Test
	public void testToStringBorsaConAttrezzi() {
		this.borsa.addAttrezzo(this.attrezzo1);
		assertTrue(this.borsa.toString().contains("martello"));
	}

}
