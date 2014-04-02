package Program13;

public class RecursiveSelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] list = {12,34,45,123,465,123,2354,456,1234};
		sort(list);
		for (double d : list) {
			System.out.print(d + " ");
		}
	}
	
	public static void sort(double[] list) {
		sort(list,0,list.length - 1);
	}
	
	public static void sort(double[] list, int low, int high) {
		if(low < high){
			int indexOfMin = low;
			double min = list[low];
			for(int i= low +1; i<=high; i++){
				if(list[i] < min){
					min = list[i];
					indexOfMin = i;
				}
			}
			
			list[indexOfMin] = list[low];
			list[low] = min;
			
			sort(list, low +1, high);
		}
	}

}
