import java.util.*;

interface Stack {
	
	public void push(String item);

	public String pop();

	public String lastElement();

	public boolean isEmpty();

	public void printStack();
}

class StackImplement implements Stack {
	private int top;
	public String stack[] = new String[100];

	StackImplement() {
		top = -1;
	}

	/**
	 * To add value to the top of Stack
	 * 
	 * @param item
	 *            - to insert at top
	 */
	@Override
	public void push(String item) {
		if (top > stack.length) {
			System.out.println("Stack Over Flow");
		} else {
			top++;
			stack[top] = item;
		}
	}

	/**
	 * Return top element of stack
	 * 
	 * @return
	 */
	@Override
	public String lastElement() {
		return stack[top];
	}

	/**
	 * Delete the top element
	 * 
	 * @return
	 */
	@Override
	public String pop() {
		return stack[top--];
	}

	/**
	 * Check if Stack is empty or Not
	 * 
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Print the stack
	 */
	@Override
	public void printStack() {
		for (int i = 0; i <= top; i++) {
			System.out.print(stack[i] + " ");
		}
	}
}

public class InfixEvaluation {
	private static String op[] = { "(", ")", "*", "/", "+", "-", "<", ">",
			"<=", ">=", "==", "!=", "&&", "||" };

	/**
	 * Check the precedence between 2 Operator
	 * 
	 * @param ch1
	 *            - Operator 1
	 * @param ch2
	 *            - Operator 2
	 * @return
	 */
	public static boolean checkPrecedence(String ch1, String ch2) {
		if ("/".equals(ch1) && "*".equals(ch2)) {
			return true;
		}
		if ("-".equals(ch1) && "+".equals(ch2)) {
			return true;
		}
		if ("(".equals(ch1)) {
			return false;
		}
		for (int i = 0; i < op.length; i++) {
			if (op[i].equals(ch1)) {
				return true;
			}
			if (op[i].equals(ch2)) {
				return false;
			}
		}
		return false;
	}

	/**
	 * Calculate the Operation and return result for that operation on 2
	 * operands
	 * 
	 * @param first
	 * @param second
	 * @param op
	 * @return
	 */
	public static int performedTask(int first, int second, String op) {
		if ("+".equals(op)) {
			return first + second;
		} else if ("-".equals(op)) {
			return first - second;
		} else if ("*".equals(op)) {
			return first * second;
		} else if ("/".equals(op)) {
			return first / second;
		} else if ("<".equals(op)) {
			if (first < second) {
				return 1;
			} else {
				return 0;
			}
		} else if (">".equals(op)) {
			if (first > second) {
				return 1;
			} else {
				return 0;
			}
		} else if ("<=".equals(op)) {
			if (first <= second) {
				return 1;
			} else {
				return 0;
			}
		} else if (">=".equals(op)) {
			if (first >= second) {
				return 1;
			} else {
				return 0;
			}
		} else if ("==".equals(op)) {
			if (first == second) {
				return 1;
			} else {
				return 0;
			}
		} else if ("!=".equals(op)) {
			if (first != second) {
				return 1;
			} else {
				return 0;
			}
		} else if ("&&".equals(op)) {
			if (first == 1 && second == 1) {
				return 1;
			}
			return 0;
		} else if ("||".equals(op)) {
			if (first == 0 && second == 0) {
				return 0;
			}
			return 1;
		}
		return 0;

	}

	/**
	 * Check that string is operator or not
	 * 
	 * @param op
	 * @return
	 */
	public static boolean isOperator(String op) {
		for (int i = 0; i < InfixEvaluation.op.length; i++) {
			if (InfixEvaluation.op[i].equals(op))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out
				.println("Enter the expression(with space seprate between each character) :");
		String input = scan.nextLine();
		String expression[] = input.split(" ");
		StackImplement operator = new StackImplement();
		StackImplement elements = new StackImplement();
		for (int i = 0; i < expression.length; i++) {
			if (isOperator(expression[i]) == false) {
				elements.push(expression[i]);
			} else if (")".equals(expression[i])) {
				String oper = operator.pop();
				while ("(".equals(oper) == false) {
					int second = Integer.parseInt(elements.pop());
					int first = Integer.parseInt(elements.pop());
					int result = performedTask(first, second, oper);
					elements.push(String.valueOf(result));
					oper = operator.pop();
				}
			} else {
				if (operator.isEmpty()) {
					operator.push(expression[i]);
				} else {
					String last = operator.lastElement();
					if (checkPrecedence(last, expression[i])) {
						int second = Integer.parseInt(elements.pop());
						int first = Integer.parseInt(elements.pop());
						String oper = operator.pop();
						int result = performedTask(first, second, oper);
						elements.push(String.valueOf(result));
						operator.push(expression[i]);
					} else {
						operator.push(expression[i]);
					}

				}
			}
		}
		while (operator.isEmpty() != true) {
			int second = Integer.parseInt(elements.pop());
			int first = Integer.parseInt(elements.pop());
			String oper = operator.pop();
			int result = performedTask(first, second, oper);
			elements.push(String.valueOf(result));
		}
		System.out.println(elements.stack[0]);
		scan.close();
	}
}
