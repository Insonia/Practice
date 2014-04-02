package com.leetcode.oj;

//import Program13.GenericStack;

public class Solution_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = {"3", "-4", "+"};
		System.out.println(evalRPN(tokens));
	}
	
	public static int evalRPN(String[] tokens){
		if(tokens.length == 1) return Integer.parseInt(tokens[0]);
		int result;
		int index = 0;
		String[] stack = new String[tokens.length];
		for(int i = 0; i< tokens.length; i++){
			if(tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "/" || tokens[i] =="*"){
				int oprend1 = Integer.parseInt(stack[index - 1]);
				int oprend2 = Integer.parseInt(stack[index - 2]);
				char op = tokens[i].charAt(0);
				index--;
				switch (op) {
				case '+':
					stack[index - 1] = (oprend1+oprend2)+"";
					break;
				case '-':
					stack[index - 1] = (oprend2-oprend1)+"";
					break;
				case '/':
					stack[index - 1] = (oprend2/oprend1)+"";
					break;
				case '*':
					stack[index - 1] = (oprend1*oprend2)+"";
					break;
				default:
					break;
				}
			}else{
				stack[index] = tokens[i];
				index ++;
			}
		}
		result = Integer.parseInt(stack[0]+ "");
		return result;
	}

}
