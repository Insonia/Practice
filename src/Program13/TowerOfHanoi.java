package Program13;

import java.util.Scanner;

public class TowerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enetr number of disk: ");
		int n = input.nextInt();
		
		System.out.println("The moves are: ");
		moveDisks(n, 'A', 'B', 'C');
	}
	
	public static void moveDisks(int n, char fromTower, char auxTower, char toTower) {
		if(n == 1)
			System.out.println("Move disk " + n +" "+ fromTower + " -> " + toTower);
		else {
			moveDisks(n-1, fromTower, toTower, auxTower);
			System.out.println("Move disk " + n+" " + fromTower + " -> " + toTower);
			moveDisks(n -1, auxTower, fromTower, toTower);
		}
	}

}
			