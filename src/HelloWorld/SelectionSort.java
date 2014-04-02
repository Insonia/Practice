package HelloWorld;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayArray(selectionSort(new int[]{12,23,45,21,23}));
	}
	
	public static int[] selectionSort(int[] list) {
		for(int i=0; i<list.length;i++)
		{
			int currentMin = list[i];
			int currentIndex = i;
			
			for(int j=i+1;j<list.length;j++)
			{
				if(currentMin > list[j])
				{
					currentIndex = j;
					currentMin = list[j];
				}
			}
			
			if(currentIndex != i)
			{
				list[currentIndex] = list[i];
				list[i] = currentMin;
			}
		}
		
		return list;
	}
	
	public static void displayArray(int[] list) {
		for (int i : list) {
			System.out.print(i + " ");
			
		}
		System.out.println();
	}

}
