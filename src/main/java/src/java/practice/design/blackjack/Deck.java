//package src.java.practice.design.blackjack;
//
//import java.util.ArrayList;
//
//public class Deck<T extends Card> {
//
//	private ArrayList<T> cards;
//
//	private int dealtIndex = 0;
//
//	public void setDeckOfCards(ArrayList<T> deckOfCards) {
//		cards = new ArrayList<>();
//		int cardCt = 0;
//		for(int suit = 0; suit <= 3; suit++) {
//			for(int value = 1; value <= 13; value++) {
//				cards.set(cardCt, new T(value, suit));
//				cardCt++;
//			}
//		}
//		dealtIndex = 0;
//	}
//
//	public void shuffle() {
//		// Put all the used cards back into the deck, and shuffle it into
//		// a random order.
//		for (int i = 51; i > 0; i--) {
//			int rand = (int) (Math.random() * (i + 1));
//			Card temp = cards.get(i);
//			cards.set(rand, cards.get(rand));
//			cards.set(rand, temp);
//		}
//		dealtIndex = 0;
//	}
//
//	public int remainingCards() {
//		return cards.size() - dealtIndex;
//	}
//
//	public T[] dealHand(int number) {
//
//	}
//
//	public T dealCard() {
//		// Deals one card from the deck and returns it.
//		if (dealtIndex == 52)
//			shuffle();
//		dealtIndex++;
//		return cards.get(dealtIndex - 1);
//	}
//}
