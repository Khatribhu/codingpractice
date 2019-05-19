package src.java.practice.java.enumpratice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Stream;

import org.omg.CORBA.portable.ValueInputStream;

public enum Enum {

	PLUS("+") {
		public double apply(double a, double b) {
			return a + b;
		}
	},
	MINUS("-") {
		public double apply(double a, double b) {
			return a - b;
		}
	},
	TIMES("*") {
		public double apply(double a, double b) {
			return a * b;
		}
	},
	DIVIDE("/") {
		public double apply(double a, double b) {
			return a / b;
		}
	};

	private final String symbol;

	Enum(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	private static final Map<String, Enum> stringToEnum = new HashMap<>();

	static {
		for (Enum op : Enum.values()) {
			stringToEnum.put(op.toString(), op);
		}
	}

	public static Enum fromString(String input) {
		if (stringToEnum != null && stringToEnum.size() > 0) {
			return stringToEnum.get(input);
		}
		return null;
	}

	public abstract double apply(double a, double b);

	public static void main(String[] args) {
		double x = 2;
		double y = 4;
		for (Enum op : Enum.values())
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));

		System.out.println(fromString("-").name());
	}
}
