import java.util.Stack;

public class Test {

	private static Stack<Integer> stack = new Stack<>();

	public static int longestValidParenthesis(String inputString) {
		int maxCount = 1;
		stack.add(-1);

		for (int i = 0; i < inputString.length(); i++) {
			Character ch = inputString.charAt(i);
			switch (ch) {
			case '(':
				stack.push(i);
				break;

			case ')':

				stack.pop();
				// check stack status.
				if (!stack.isEmpty()) {
					maxCount = Math.max(maxCount, i - stack.peek());
				} else {
					stack.push(i);
				}

				break;

			default:
				System.out.println("Invalid String");
				return -1;
			}

			// System.out.println("iteration: "+i);
			// printStack((Stack)stack.clone());

		}
		return maxCount;
	}

	private static void printStack(Stack<Integer> stack) {
		for (int i = 0; i < stack.size(); i++) {
			System.out.print(stack.pop() + ",");
		}
	}

//	public static void main(String[] args) {
//		// String inputString = "()()()";
//		String inputString = "()()(((((()()(((()()()()()))()";
//		System.out.println("maxCount :" + longestValidParenthesis(inputString));
//
//	}

}
