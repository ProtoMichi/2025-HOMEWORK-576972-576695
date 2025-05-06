package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private String nomeAttrezzo;
	private IO io;

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null && io!=null) {
			io.mostraMessaggio("Che attrezzo vuoi prendere?");
		}
		Attrezzo attrezzo=null;
		attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);

		if(attrezzo==null && io!=null) {
			io.mostraMessaggio("Attrezzo inesistente");
		}
		if(attrezzo!=null && io!=null) {
			partita.getGiocatore().getAttrezzi().addAttrezzo(attrezzo);
			partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			io.mostraMessaggio("Hai preso l'attrezzo: "+ attrezzo.toString());
		}
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

}
