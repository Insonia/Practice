package HelloWorld;

public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayArray(insertSort(new int[]{124,11,23,12,23,45,21,23,67,45,657,76,87,456,213,123}));
	}
	
	public static int[] insertSort(int[] list) {
		for(int i=0; i<list.length-1; i++)
		{
			int currentElement = list[i+1];
			int currentIndex = i;
			//当currentIndex >=0 放在currentElement<list[currentIndex]将报错，由于currentIndex<0,list[currentIndex]边界溢出
			while(currentIndex >=0 && currentElement<list[currentIndex] )
			{
				list[currentIndex+1] = list[currentIndex];
				//list[currentIndex] = currentElement;
				currentIndex--;
			}
			list[currentIndex+1]= currentElement;
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
