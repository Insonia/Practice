package com.leetcode.oj;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//任意一条直线都可以表述为
//
//y = ax + b
//
//假设，有两个点(x1,y1), (x2,y2)，如果他们都在这条直线上则有
//
//y1 = kx1 +b
//
//y2 = kx2 +b
//
//由此可以得到关系，k = (y2-y1)/(x2-x1)。即如果点c和点a的斜率为k, 而点b和点a的斜率也为k，可以知道点c和点b也在一条线上。
//
//取定一个点points[i], 遍历其他所有节点, 然后统计斜率相同的点数，并求取最大值即可

public class Solution_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] pointsArray = {{84,250},{0,0},{1,0},{0,-70},{0,-70},{1,-1},{21,10},{42,90},{-42,-230}};
		Point[] points = Point.pointsArray(pointsArray);
		System.out.println(maxPoints(points));
	}

	public static int maxPoints(Point[] points) {
		if (points.length == 0)
			return 0;
		if (points.length == 1)
			return 1;

		HashMap<Float, Integer> map = new HashMap<Float, Integer>();
		//float k;
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			map.clear();
			map.put(Float.MIN_VALUE, 0);
			int duplicate = 1;
			for (int j = 0; j < points.length; j++) {
				if(j == i) continue;
				if(points[j].x == points[i].x && points[j].y == points[i].y){
					duplicate++;
					continue;
				}
				//在point[j].y前面先转换为float，如果等计算完斜率再转float会造成精度缺失
				float k = (points[j].x == points[i].x) ? Float.MAX_VALUE: ((float)points[j].y - points[i].y) / (points[j].x - points[i].x);
				if (!map.containsKey(k)) {
					map.put(k, 1);
				} else {
					int value = map.get(k).intValue();
					value++;
					map.put(k, value);
				}
			}
			Set<Map.Entry<Float, Integer>> set = map.entrySet();
			for (Map.Entry<Float, Integer> entry : set)
				if ((entry.getValue() + duplicate) > max)
					max = entry.getValue() + duplicate;
		}
		return max;
	}

	static class Point {
		public int x;
		public int y;

		public Point() {
			x = 0;
			y = 0;
		}

		public Point(int a, int b) {
			x = a;
			y = b;
		}
		
		public static Point[] pointsArray(int[][] pointsArray){
			Point[] points = new Point[pointsArray.length];
			for(int i = 0; i < pointsArray.length; i++)
			{
				points[i] = new Point();
				points[i].x = pointsArray[i][0];
				points[i].y = pointsArray[i][1];
			}
			
			return points;
		}
	}

}
