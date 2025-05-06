package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

class ComandoPrendiTest {

	private ComandoPrendi comandoPrendi;
    private Partita partita;
    private Attrezzo attrezzo;

    @BeforeEach
    public void setUp() {
        comandoPrendi = new ComandoPrendi();
        partita = new Partita();
        Stanza stanza = new Stanza("Aula");
        partita.setStanzaCorrente(stanza);

        attrezzo = new Attrezzo("libro", 2);
        stanza.addAttrezzo(attrezzo);
        comandoPrendi.setIO(new IOConsole());
    }

    @Test
    public void testPrendiAttrezzoPresente() {
        comandoPrendi.setParametro("libro");
        comandoPrendi.esegui(partita);

        assertNull(partita.getStanzaCorrente().getAttrezzo("libro"));  // rimosso dalla stanza
        assertNotNull(partita.getGiocatore().getAttrezzi().getAttrezzo("libro"));  // aggiunto in borsa
    }

    @Test
    public void testPrendiAttrezzoInesistente() {
        comandoPrendi.setParametro("martello");
        comandoPrendi.esegui(partita);

        assertNull(partita.getGiocatore().getAttrezzi().getAttrezzo("martello"));  // non esiste
        assertNotNull(partita.getStanzaCorrente().getAttrezzo("libro"));  // nulla è cambiato
    }

    @Test
    public void testParametroNull() {
        comandoPrendi.setParametro(null);
        comandoPrendi.esegui(partita);

        assertNull(partita.getGiocatore().getAttrezzi().getAttrezzo("libro"));  // nulla preso
        assertNotNull(partita.getStanzaCorrente().getAttrezzo("libro"));  // ancora nella stanza
    }
}
