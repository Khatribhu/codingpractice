package com.coding.practice.design.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackHand extends Hand<BlackJackCard> {

	@Override
	public int score() {
		ArrayList<Integer> scores = possibleScores();
		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;
		for (int score : scores) {
			if (score > 21 && score < minOver) {
				minOver = score;
			} else if (score < 21 && score > maxUnder) {
				maxUnder = score;
			}
		}

		return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;

	}

	private ArrayList<Integer> possibleScores() {
		List<Integer> list = new ArrayList<>();
		for (BlackJackCard card : cards) {
		}
		return new ArrayList<>();
	}
}
