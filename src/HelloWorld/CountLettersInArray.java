package HelloWorld;

import HelloWorld.RandomCharacter;

public class CountLettersInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chars = creatArray();
		displayArray(chars);
		
		System.out.println();
		int[] counts = countLetters(chars);
		displayCounts(counts);
	}
	
	public static char[] creatArray() {
		char[] chars = new char[100];
		
		for(int i=0; i<chars.length; i++)
			chars[i] = RandomCharacter.getRandomLowerCaseLetter();
		
		return chars;
	}
	
	public static void displayArray(char[] chars) {
		for(int i=1; i<chars.length+1; i++)
		{
			if((i%20)==0)
				System.out.println(chars[i-1]);
			else {
				System.out.print(chars[i-1] + " ");
			}
		}
	}
	
	public static int[] countLetters(char[] chars) {
		int[] counts = new int[26];
		
		for(int i=0;i<chars.length;i++)
			counts[(int)(chars[i] - 'a')]++;
		
		return counts;
	}
	
	public static void displayCounts(int[] counts) {
		for(int i=0;i<counts.length;i++)
			if((i+1)%10==0)
				System.out.println(counts[i] + " " + (char)(i+'a'));
			else {
				System.out.print(counts[i] + " " + (char)(i+'a')+ " ");
			}
	}
}
