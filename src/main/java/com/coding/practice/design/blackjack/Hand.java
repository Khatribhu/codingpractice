package com.coding.practice.design.blackjack;

import java.util.ArrayList;

public class Hand<T extends Card> {

	protected ArrayList<T> cards = new ArrayList<>();
	
	public int score() {
		int score = 0;
		for(T t : cards) {
			score += t.value();
		}
		return score;
	}
	
	public void addCard(T card) {
		cards.add(card);
	}

	
}

