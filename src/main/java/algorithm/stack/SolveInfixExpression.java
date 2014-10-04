package algorithm.stack;

import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

/** 
 * Description : 求中缀表达式的值，思路：先转化为后缀表达式，然后再求值。参考博客http://www.cnblogs.com/zghaobac/p/3394705.html
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-14 
 * Time : 下午8:12:45
 */
public class SolveInfixExpression {
	
	public static HashMap<Character, Integer> priorities = new HashMap<Character, Integer>();

	static {
		priorities.put('(', -1);
		priorities.put('+', 0);
		priorities.put('-', 0);
		
		priorities.put('*', 1);
		priorities.put('/', 1);		
	}

	public String infixToSuffix(String expression) {
		Stack<Character> s = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < expression.length(); i++) {
			
			char curr = expression.charAt(i);
			
			if (curr <= '9' && curr >= '0') {
				sb.append(curr);
				continue;
			}
			
			//左括号直接入栈，不要判断优先级了，因为有((这种情况。
			if (curr == '(') {
				s.add(curr);
				continue;
			}			
			
			if (s.size() == 0){
				s.add(curr);
			} else if (curr == ')') {
				while(!s.isEmpty() && s.peek() != '(') {
					sb.append(s.pop());
				}
				s.pop();
			} else if (priorities.get(curr) > priorities.get(s.peek())) {
				s.add(curr);
			} else if (priorities.get(curr) <= priorities.get(s.peek())) {
				
				while(!s.isEmpty() && priorities.get(s.peek()) >= priorities.get(s.peek())){
					sb.append(s.pop());
				}
				s.add(curr);
			} else {
				System.out.println(expression.charAt(i));
				return "error";
			}
		}
		
		while (!s.isEmpty()) {
			sb.append(s.pop());
		}
		return sb.toString();
	}
	
	public int solveSuffix(String suffix) {
		int result = 0;
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < suffix.length(); i++) {
			char curr = suffix.charAt(i);
			if (curr <= '9' && curr >= '0'){
				s.add(curr - '0');
				continue;
			}
			
			System.out.println(s);
			
			int val2 = s.pop();
			int val1 = s.pop();
			
			switch(curr) {
			case '+':
				s.add(val1 + val2);
				break;
			case '-':
				s.add(val1 - val2);
				break;
			case '*':
				s.add(val1 * val2);
				break;
			case '/':
				s.add(val1 / val2);
				break;
			default:
				return -1;
			}
		}
		return s.pop();
	}
	
	
	public int solveInfix(String expression) {
				
		String r = infixToSuffix(expression);
		int result = solveSuffix(r);
		
		return result;
	}
	
	@Test
	public void test(){
		String r = infixToSuffix("1+((2+3)*4)-5");
		System.out.println(r);
		
		System.out.println(solveInfix("1+((2+3)*4)-5"));
	}
	
	
}
