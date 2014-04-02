package com.leetcode.oj;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//����һ��ֱ�߶����Ա���Ϊ
//
//y = ax + b
//
//���裬��������(x1,y1), (x2,y2)��������Ƕ�������ֱ��������
//
//y1 = kx1 +b
//
//y2 = kx2 +b
//
//�ɴ˿��Եõ���ϵ��k = (y2-y1)/(x2-x1)���������c�͵�a��б��Ϊk, ����b�͵�a��б��ҲΪk������֪����c�͵�bҲ��һ�����ϡ�
//
//ȡ��һ����points[i], �����������нڵ�, Ȼ��ͳ��б����ͬ�ĵ���������ȡ���ֵ����

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
				//��point[j].yǰ����ת��Ϊfloat������ȼ�����б����תfloat����ɾ���ȱʧ
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
