package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	private final String[] elencoComandi;
	private IO io;
	
	public ComandoAiuto(String[] elencoComandi) {
		this.elencoComandi = elencoComandi;
	}
	
	@Override
	public void esegui(Partita partita) {
		System.out.println("Comando 'aiuto' eseguito!");
		for(int i=0; i<elencoComandi.length; i++) { 
			if(elencoComandi[i]!=null) {
				io.mostraMessaggio(elencoComandi[i].toString()+" ");
			}
		}
		io.mostraMessaggio("");
	}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
	
	@Override
	public String getNome() {
	    return "aiuto";
	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
