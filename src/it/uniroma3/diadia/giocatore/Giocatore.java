package it.uniroma3.diadia.giocatore;

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
	
	public Borsa getAttrezzi() {
		return attrezzi;
	}



	public void setAttrezzi(Borsa attrezzi) {
		this.attrezzi = attrezzi;
	}
	
	@Override
	public String toString() {
		return this.cfu + " "+ this.attrezzi.toString();
	}
}
