package mynote.stack;

import java.util.Stack;

import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;

public class BasicCalculator2 {
	Stack<Character> opStack = new Stack<>();
	Stack<Integer>  numStack = new Stack<>();
	
	public int calculate(String s) {
		s = '(' + s + ')';		
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
				pushNum( num);
				i--;
			} else if (c != ' ') {
				pushOp( c);
			}
			i++;
		}
		return  numStack.pop();
	}

	private void pushOp(  char op) {
		if (op == '(' || op == '*' || op == '/') {
			opStack.push(op);		
			return;
		}	 

		if (op == '+' || op == '-') {		
			pushNum(calLast());
			opStack.push(op);
		} else if (op == ')') {	
			int right = calLast();
			opStack.pop();		
			pushNum(right);
		}
	}

	private void pushNum(  int num) {
		if (numStack.isEmpty()) {
			numStack.push(num);
			return;
		}

		char op =  opStack.peek();
		switch (op) {
		case '(':
		case '+':
		case '-':
			numStack.push(num);
			break;
		default:
			op = opStack.pop();
			Integer left = (Integer) numStack.pop();
			numStack.push(cal(left, num, op));
		}
	}
	
	private int calLast( ) {
		int right =  numStack.pop();
		char lop =   opStack.peek();
		if (lop == '+' || lop == '-') {
			opStack.pop();
			int left =  numStack.pop();
			right = cal(left,right,lop);				
		} 		
		return right;
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

		BasicCalculator2 calculator = new BasicCalculator2();
		assertEquals(calculator.calculate("0"), 0);
		assertEquals(calculator.calculate("1 + 1"), 2);
		assertEquals(calculator.calculate("2 * 3"), 6);
		assertEquals(10, calculator.calculate("8+9-7"));
	}

	@Test
	public void test2() {

		BasicCalculator2 calculator = new BasicCalculator2();
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
		Result result = JUnitCore.runClasses(BasicCalculator2.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
	}

	public static void test() {
		BasicCalculator2 calculator = new BasicCalculator2();
		System.out.println(calculator
				.calculate("2*(3+2)+2*(5+15)"));
	}

	public static void main(String[] args) {
		test();
		runJunit();
	}

}
