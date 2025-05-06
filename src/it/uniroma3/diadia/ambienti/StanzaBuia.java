package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String nomeAttrezzo;
	
	public StanzaBuia(String nomeStanza,String nomeAttrezzo) {
		super(nomeStanza);
		this.nomeAttrezzo = nomeAttrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(this.nomeAttrezzo)) {
			String nonPresente = "qui c'è buio pesto";
			return nonPresente;
		}
		else {
			return super.getDescrizione();
		}
	}
}
