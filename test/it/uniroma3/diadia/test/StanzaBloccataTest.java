package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {

    private StanzaBloccata stanzaBloccata;
    private Stanza stanzaAdiacente;
    private final String DIREZIONE_BLOCCATA = "nord";
    private final String ATTREZZO_SBLOCCANTE = "chiave";

    @BeforeEach
    void setUp() {
        stanzaBloccata = new StanzaBloccata("Corridoio", DIREZIONE_BLOCCATA, ATTREZZO_SBLOCCANTE);
        stanzaAdiacente = new Stanza("Sala Segreta");
        stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_BLOCCATA, stanzaAdiacente);
    }

    @Test
    void testGetStanzaAdiacente_DirezioneBloccata_SenzaAttrezzo() {
        Stanza stanza = stanzaBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA);
        assertEquals(stanzaBloccata, stanza); // resta nella stanza bloccata
    }

    @Test
    void testGetStanzaAdiacente_DirezioneBloccata_ConAttrezzo() {
        stanzaBloccata.addAttrezzo(new Attrezzo(ATTREZZO_SBLOCCANTE, 1));
        Stanza stanza = stanzaBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA);
        assertEquals(stanzaAdiacente, stanza);
    }

    @Test
    void testGetStanzaAdiacente_DirezioneNonBloccata() {
        stanzaBloccata.impostaStanzaAdiacente("sud", new Stanza("Cucina"));
        Stanza stanza = stanzaBloccata.getStanzaAdiacente("sud");
        assertEquals("Cucina", stanza.getNome());
    }

    @Test
    void testGetDescrizione_SenzaAttrezzo() {
        String descrizione = stanzaBloccata.getDescrizione();
        assertTrue(descrizione.contains("Direzione bloccata: nord"));
    }

    @Test
    void testGetDescrizione_ConAttrezzo() {
        stanzaBloccata.addAttrezzo(new Attrezzo(ATTREZZO_SBLOCCANTE, 1));
        String descrizione = stanzaBloccata.getDescrizione();
        assertFalse(descrizione.contains("Direzione bloccata"));
    }
}
