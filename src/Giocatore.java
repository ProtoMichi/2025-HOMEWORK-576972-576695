package it.uniroma3.diadia;

public class Giocatore {

	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa attrezzi;

	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.attrezzi=new Borsa();
	}

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
}
