package src.java.practice.design.blackjack;

import java.util.HashMap;
import java.util.Map;

public enum Suit {

	CULB(0), DIAMOND(1), HEART(3), SPADE(4);

	private int value;

	Suit(Integer v) {
		this.value = v;
	}

	public int getValue() {
		return this.value;
	}

	private static final Map<Integer, Suit> stringToEnum = new HashMap<>();

	static {
		for (Suit op : Suit.values()) {
			stringToEnum.put(op.getValue(), op);
		}
	}

	public static Suit getSuitFromValue(int value) {
		if (stringToEnum != null && stringToEnum.size() > 0) {
			return stringToEnum.get(value);
		}
		return null;
	}

}
