package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	
	private String nomeDirezioneBloccata;
	private String nomeAttrezzoSbloccante;
	
	public StanzaBloccata(String nomeStanza,String nomeDirezioneBloccata,String nomeAttrezzoSbloccante) {
		super(nomeStanza);
		this.nomeDirezioneBloccata = nomeDirezioneBloccata;
		this.nomeAttrezzoSbloccante = nomeAttrezzoSbloccante;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(dir.equals(this.nomeDirezioneBloccata) && !this.hasAttrezzo(this.nomeAttrezzoSbloccante)) {
			return this;
		}
		else {
			return super.getStanzaAdiacente(dir);
		}
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(this.nomeAttrezzoSbloccante)) {
			return super.getDescrizione() + "\nDirezione bloccata: " + this.nomeDirezioneBloccata;
		}
		else {
			return super.getDescrizione();
		}
	}
}
