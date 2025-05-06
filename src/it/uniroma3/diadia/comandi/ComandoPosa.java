package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	
	private String nomeAttrezzo;
	private IO io;

	
	@Override
	public void esegui(Partita partita) {
		
		if(nomeAttrezzo==null && io!=null) {
			io.mostraMessaggio("Che attrezzo vuoi posare?");
		}
		Attrezzo attrezzo=null;
		attrezzo = partita.getGiocatore().getAttrezzi().getAttrezzo(nomeAttrezzo);
		if(attrezzo==null && io!=null) {
			io.mostraMessaggio("Attrezzo inesistente");
		}
		else {
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			partita.getGiocatore().getAttrezzi().removeAttrezzo(nomeAttrezzo);
		}
		if(attrezzo!=null && io!=null)
			io.mostraMessaggio("Hai posato l'attrezzo: "+ attrezzo.toString());
	}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
	
	@Override
	public String getNome() {
	    return "posa";
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
