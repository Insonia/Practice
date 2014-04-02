package HelloWorld;

import java.util.Scanner;

public class FindNearestPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enetr number of points:");
		
		int numberOfPoints = input.nextInt();
		
		double[][] points = new double[numberOfPoints][2];
		System.out.println("Enetr " + numberOfPoints + " Points: ");
		for(int i=0; i< numberOfPoints; i++)
		{
			points[i][0] = input.nextDouble();
			points[i][1] = input.nextDouble();
		}
		
		int p1=0,p2=1;
		double nearestPoints = distance(points[p1][0], points[p1][1], points[p2][0], points[p2][1]);
		
		for(int i = 0; i<numberOfPoints; i ++)
			for(int j=i+1; j< numberOfPoints;j++)
			{
				double distance = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
				
				if(distance < nearestPoints)
				{
					nearestPoints = distance;
					p1 = i;
					p2 = j;
				}
			}
		
		System.out.println("The nearest two points are " + "(" + points[p1][0] + ", " + points[p1][1]
				+ "), (" + points[p2][0]+ ", " + points[p2][1] + "), the distance is " + nearestPoints);
	}
	
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	}

}
