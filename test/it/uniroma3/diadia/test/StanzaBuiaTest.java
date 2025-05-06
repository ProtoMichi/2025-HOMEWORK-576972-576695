package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

    private StanzaBuia stanzaBuia;
    private final String NOME_ATTREZZO_LUCE = "torcia";

    @BeforeEach
    void setUp() {
        stanzaBuia = new StanzaBuia("Cantina", NOME_ATTREZZO_LUCE);
    }

    @Test
    void testDescrizioneConAttrezzoPresente() {
        stanzaBuia.addAttrezzo(new Attrezzo(NOME_ATTREZZO_LUCE, 1));
        String descrizione = stanzaBuia.getDescrizione();
        assertTrue(descrizione.contains("Cantina"));
    }

    @Test
    void testDescrizioneSenzaAttrezzo() {
        String descrizione = stanzaBuia.getDescrizione();
        assertEquals("qui c'è buio pesto", descrizione);
    }

    @Test
    void testDescrizioneConAltroAttrezzo() {
        stanzaBuia.addAttrezzo(new Attrezzo("martello", 2));
        String descrizione = stanzaBuia.getDescrizione();
        assertEquals("qui c'è buio pesto", descrizione);
    }
}
