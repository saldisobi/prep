package algoexpert.medium;

import java.util.Stack;

class MinStack
{
	// main stack to store elements
	private Stack<Integer> s = new Stack<>();

	// variable to store minimum element
	private int min;

	// Inserts a given element on top of the stack
	public void push(int x)
	{
		if (s.empty()) {
			s.push(x);
			min = x;
		}
		else if (x > min) {
			s.push(x);
		}
		else {
			s.push(2 * x - min);
			min = x;
		}

		System.out.println("pushed "+s.peek());
	}

	// Removes top element from the stack and returns it
	public void pop()
	{
		if (s.empty()) {
			System.out.println("Stack underflow!!");
		}

		int top = s.peek();
		if (top < min)
			min = 2 * min - top;
		s.pop();
	}

	// Returns the minimum element from the stack in constant time
	public int min()
	{
		return min;
	}

	public static void main (String[] args)
	{
		MinStack s = new MinStack();

		s.push(6);
		System.out.println(s.min());

		s.push(7);
		System.out.println(s.min());

		s.push(5);
		System.out.println(s.min());

		s.push(3);
		System.out.println(s.min());

		s.push(-1);
		System.out.println(s.min());

		s.pop();
		System.out.println(s.min());

		s.pop();
		System.out.println(s.min());
	}
}