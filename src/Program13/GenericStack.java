package Program13;

import java.util.ArrayList;

public class GenericStack<E> {
	private ArrayList<E> list = new ArrayList<E>();
	
	public int getSize() {
		return list.size();
	}
	
	public E peak() {
		return list.get(getSize() -1);
	}
	
	public void push(E o) {
		list.add(o);
	}
	
	public E pop() {
		E o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public static void main(String[] args){
		GenericStack<String> stack1 = new GenericStack<String>();
		stack1.push("London");
		stack1.push("Paris");
		stack1.push("Berlin");
		int stack1Size = stack1.getSize();
		for(int i= 0; i< stack1Size; i++){
			System.out.print(stack1.peak() + " ");
			stack1.pop();
		}
		System.out.println();
		
		GenericStack<Integer> stack2 = new GenericStack<Integer>();
		stack2.push(1);
		stack2.push(2);
		stack2.push(3);
		int stack2Size = stack2.getSize();
		for(int i= 0; i< stack2Size; i++){
			System.out.print(stack2.peak() + " ");
			stack2.pop();
		}
	}
}
