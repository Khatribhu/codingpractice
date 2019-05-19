package com.coding.practice.design.blackjack;

public class BlackJackCard extends Card {

	public BlackJackCard(int v, Suit suit) {
		super(v, suit);
	}

	@Override
	public int value() {
		if(isAce()) return 1;
		else if(isFaceCard()) return 10;
		else return faceValue;
	}
	
	public boolean isAce() {
		return faceValue == 1;
	}
	
	public boolean isFaceCard() {
		return (faceValue >= 11 && faceValue <= 13);
	}
	
	public int maxValue() {
		if(isAce()) {
			return 11;
		} else {
			return faceValue;
		}
	}
	
	public int minValue() {
		if(isAce()) {
			return 1;
		} else {
			return faceValue;
		}
	}
}
