package src.java.practice.design.blackjack;

public abstract class Card {

	private Boolean available = true;

	/*
	 * Number or face that's on card: a number through 2 to 10, 11 for jack, 12 for
	 * queen, 13 for king, or 1 for Ace
	 */
	protected int faceValue;
	protected Suit suit;
	
	public Card(int v, Suit suit) {
		faceValue = v;
		suit = suit;
	}
	
	public abstract int value();
	public Suit suit() {
		return suit;
	}
	
	/* 
	 * Check cards are available to given out to someone
	 * */
	public boolean isAvailable() {
		return available;
	}
	
	public void markUnavailable() {
		this.available = false;
	}
	
	public void markAvailable() {
		this.available = true;
	}

}
