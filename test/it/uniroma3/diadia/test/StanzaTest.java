package it.uniroma3.diadia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

	private Stanza stanza(String nome) {
		return new Stanza(nome);
	}

	@Test
	void testGetStanzaAdiacenteValoreCorretto() {
		Stanza stanza = stanza("Aula N11");
		Stanza adiacente = stanza("Bar");
		stanza.impostaStanzaAdiacente("Est", adiacente);
		assertEquals(stanza.getStanzaAdiacente("Est").getNome(),adiacente.getNome());
	}

	@Test
	void testGetStanzaAdiacenteStanzaInesistente() {
		Stanza stanza = stanza("Aula N11");
		Stanza adiacente = stanza("Bar");
		stanza.impostaStanzaAdiacente("Est", adiacente);
		assertNull(stanza.getStanzaAdiacente("Ovest"));
	}

	@Test
	void testGetStanzaAdiacenteDirezioneInesistente() {
		Stanza stanza = stanza("Aula N11");
		Stanza adiacente = stanza("Bar");
		stanza.impostaStanzaAdiacente("Est", adiacente);
		assertNull(stanza.getStanzaAdiacente("Ovest"));
	}



	@Test
	void testImpostaStanzaAdiacenteNotNull() {
		Stanza stanza = stanza("Aula N11");
		Stanza adiacente = stanza("Bar");
		stanza.impostaStanzaAdiacente("Est", adiacente);
		assertNotNull(stanza.getStanzaAdiacente("Est"));
	}

	@Test
	void testImpostaStanzaAdiacenteNull() {
		Stanza stanza = stanza("Aula N11");
		stanza.impostaStanzaAdiacente("Est", null);
		assertNull(stanza.getStanzaAdiacente("Est"));
	}

	@Test
	void testImpostaStanzaAdiacenteValoreCorretto() {
		Stanza stanza = stanza("Aula N11");
		Stanza adiacente = stanza("Bar");
		stanza.impostaStanzaAdiacente("Est", adiacente);
		assertEquals("Bar", stanza.getStanzaAdiacente("Est").getNome());
	}

	@Test
	void testAddAttrezzoValoreCorretto() {
		Stanza stanza = stanza("Aula N11");
		assertTrue(stanza.addAttrezzo(new Attrezzo("Penna",1)));
	}

	@Test
	void testAddAttrezzoAttrezziPieno() {
		Stanza stanza = stanza("Aula N11");
		stanza.addAttrezzo(new Attrezzo("Penna",1));
		stanza.addAttrezzo(new Attrezzo("Penna",1));
		stanza.addAttrezzo(new Attrezzo("Penna",1));
		stanza.addAttrezzo(new Attrezzo("Penna",1));
		stanza.addAttrezzo(new Attrezzo("Penna",1));
		stanza.addAttrezzo(new Attrezzo("Penna",1));
		stanza.addAttrezzo(new Attrezzo("Penna",1));
		stanza.addAttrezzo(new Attrezzo("Penna",1));
		stanza.addAttrezzo(new Attrezzo("Penna",1));
		stanza.addAttrezzo(new Attrezzo("Penna",1));
		assertFalse(stanza.addAttrezzo(new Attrezzo("Penna",1)));
	}

	@Test
	void testAddAttrezzoValoreCorrettoPresente() {
		Stanza stanza = stanza("Aula N11");
		stanza.addAttrezzo(new Attrezzo("Penna",1));
		assertEquals("Penna", stanza.getAttrezzo("Penna").getNome());
	}
	
	@Test
	void testHasAttrezzoTrue() {
		Stanza stanza = stanza("Aula N11");
		stanza.addAttrezzo(new Attrezzo("Penna",1));
		assertTrue(stanza.hasAttrezzo("Penna"));
	}
	
	@Test
	void testHasAttrezzoFalse() {
		Stanza stanza = stanza("Aula N11");
		stanza.addAttrezzo(new Attrezzo("Penna",1));
		assertFalse(stanza.hasAttrezzo("Piuma"));
	}
	
	@Test
	void testHasAttrezzoNull() {
		Stanza stanza = stanza("Aula N11");
		assertFalse(stanza.hasAttrezzo(null));
	}
	
	@Test
	void testGetAttrezzoValoreCorretto() {
		Stanza stanza = stanza("Aula N11");
		stanza.addAttrezzo(new Attrezzo("Penna",1));
		assertEquals("Penna",stanza.getAttrezzo("Penna").getNome());
	}
	
	@Test
	void testGetAttrezzoValoreInesistente() {
		Stanza stanza = stanza("Aula N11");
		stanza.addAttrezzo(new Attrezzo("Penna",1));
		assertNull(stanza.getAttrezzo("Piuma"));
	}
	
	@Test
	void testGetAttrezzoValoreNull() {
		Stanza stanza = stanza("Aula N11");
		stanza.addAttrezzo(new Attrezzo("Penna",1));
		assertNull(stanza.getAttrezzo(null));
	}
	
	@Test
	void testGetDirezioniPresenti() {
		Stanza stanza = stanza("Aula N11");
		Stanza adiacente=new Stanza("Mensa");
		stanza.impostaStanzaAdiacente("Est", adiacente);
		 String[] direzioniAttese = {"Est"};
		 assertArrayEquals(direzioniAttese,stanza.getDirezioni());
	}
	
	@Test
	void testRemoveAttrezzoTrue() {
		Stanza stanza = stanza("Aula N11");
		Attrezzo attrezzo=new Attrezzo("Penna",1);
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.removeAttrezzo(attrezzo));
	}
	
	@Test
	void testRemoveAttrezzoFalse() {
		Stanza stanza = stanza("Aula N11");
		Attrezzo attrezzo=new Attrezzo("Penna",1);
		stanza.addAttrezzo(attrezzo);
		Attrezzo attrezzo2=new Attrezzo("Piuma",1);
		assertFalse(stanza.removeAttrezzo(attrezzo2));
	}
	
	@Test
	void testRemoveAttrezzoNull() {
		Stanza stanza = stanza("Aula N11");
		Attrezzo attrezzo=new Attrezzo("Penna",1);
		stanza.addAttrezzo(attrezzo);
		assertFalse(stanza.removeAttrezzo(null));
	}

}
