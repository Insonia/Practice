package milo;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {3,2,4,1,7,123,6,123,678,12,54,76};
		bubbleSort(list);
		for (int i : list) {
			System.out.print(i + " ");
		}
	}
	
	public static void bubbleSort(int[] list) {
		boolean needNextPass = true;
		for(int i = 1; i< list.length && needNextPass == true; i++){
			needNextPass = false;
			for(int j = 0; j< list.length - i; j++){
				if(list[j] > list[j+1]){
					int temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
					needNextPass = true;
				}
			}
		}
	}

}
