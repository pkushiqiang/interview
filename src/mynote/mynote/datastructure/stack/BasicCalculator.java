package mynote.datastructure.stack;

import java.util.Stack;

import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;

public class BasicCalculator {

	public int calculate(String s) {
		s = '(' + s + ')';
		Stack stack = new Stack();
		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				int num = 0;
				while (i < s.length() && s.charAt(i) >= '0'
						&& s.charAt(i) <= '9') {
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				pushNum(stack, num);
				i--;
			} else if (c != ' ') {
				pushOp(stack, c);
			}
			i++;
		}
		return (Integer) stack.pop();
	}

	private void pushOp(Stack stack, char op) {
		if (op == '(' || op == '*' || op == '/') {
			stack.push(op);
			return;
		}
		int right = (int) stack.pop();

		if (op == '+' || op == '-') {
			char lop = (char) stack.peek();
			if (lop == '+' || lop == '-') {
				stack.pop();
				int left = (int) stack.pop();
				right = cal(left,right,lop);				
			} 
			stack.push(right);
			stack.push(op);
		} else if (op == ')') {
			if ((char) stack.peek() != '(') {
				char lop = (char) stack.pop();
				int left = (int) stack.pop();
				right = cal(left, right, lop);
			}
			stack.pop();
			pushNum(stack, right);
		}
	}

	private void pushNum(Stack stack, int num) {
		if (stack.isEmpty()) {
			stack.push(num);
			return;
		}

		char op = (char) stack.peek();
		switch (op) {
		case '(':
		case '+':
		case '-':
			stack.push(num);
			break;
		default:
			op = (Character) stack.pop();
			Integer left = (Integer) stack.pop();
			stack.push(cal(left, num, op));
		}
	}

	public static int cal(int left, int right, char op) {
		switch (op) {
		case '+':
			return left + right;
		case '-':
			return left - right;
		case '*':
			return left * right;
		case '/':
			return left / right;
		default:
			return 1;
		}

	}

	@Test
	public void test1() {

		BasicCalculator calculator = new BasicCalculator();
		assertEquals(calculator.calculate("0"), 0);
		assertEquals(calculator.calculate("1 + 1"), 2);
		assertEquals(calculator.calculate("2 * 3"), 6);
	}

	@Test
	public void test2() {

		BasicCalculator calculator = new BasicCalculator();
		assertEquals(0, calculator.calculate("0*(9+3)"));
		assertEquals(17, calculator.calculate("1 + ( 2+ 7 * 2 )"));
		assertEquals(10, calculator.calculate("2 * ( 3 + 2 ) "));
		assertEquals(50, calculator.calculate("2 * ( 3 + 2 ) + 2* (5+15) "));
		assertEquals(2, calculator.calculate("(2+14 ) / 8 "));
		assertEquals(15,
				calculator.calculate("(2 * ( 3 + 2 ) + 2* (5+15) - 10 ) / 8 + 5*2 "));
		
		assertEquals(5,
				calculator.calculate("(2 * ( 3 + 2 ) + 2* (5+15) - 10 ) / 8 "));
	}

	public static void runJunit() {
		Result result = JUnitCore.runClasses(BasicCalculator.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
	}

	public static void test() {
		BasicCalculator calculator = new BasicCalculator();
		System.out.println(calculator
				.calculate("8+9-7"));
	}

	public static void main(String[] args) {
		test();
		runJunit();
	}

}
