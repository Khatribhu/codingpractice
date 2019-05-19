package src.java.practice.java.generics;

public class GenericMethod {
	
	public <T> T callingMethod(T t) {
		return t;
	}
	
	public static <T> T callingStaticMethod(T t ) {
		return t;
	}
}
