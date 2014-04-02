package milo;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {1,3,4,345,56,-1,34,-345,123,34,45,56,67,567,5678,234,45,23,-345,-654,56};
		quickSort(list);
		for (int i : list) {
			System.out.print(i+" ");
		}
	}
	
	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);
	}
	
	private static void quickSort(int[] list, int first, int last){
		if(last>first){
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	
	private static int partition(int[] list, int first, int last){
		int pivot = list[first];
		int low = first + 1;
		int high = last;
		
		while(high > low){
			while(low <= high && list[low] <= pivot)
				low++;
			
			while(low <= high && list[high] > pivot)
				high--;
			
			if(low < high){
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		while (high > first && list[high] >= pivot)
			high--;
		
		if(pivot > list[high]){
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}else {
			return first;
		}
	}

}
