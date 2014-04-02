package Program14;

public class GenericSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intArray = {new Integer(2), new Integer(4), new Integer(3)};
		
		Double[] doubleArray = {new Double(3.4), new Double(1.3), new Double(-2)};
		
		Character[] charArray = {new Character('a'), new Character('g'),new Character('e')};
		
		String[] stringArray = {"Tom","John","Fred"};
		
		sort(intArray);
		sort(doubleArray);
		sort(charArray);
		sort(stringArray);
		
		System.out.println("Sorted Integer objects: ");
		printList(intArray);
		System.out.println("Sorted Double objects: ");
		printList(doubleArray);
		System.out.println("Sorted Character objects: ");
		printList(charArray);
		System.out.println("Sorted String objects: ");
		printList(stringArray);
	}
	
	public static void sort(Comparable[] list) {
		Comparable currentMin;
		int currentIndex;
		
		for(int i=0; i < list.length; i++){
			currentMin = list[i];
			currentIndex = i;
			
			for(int j = i+1; j<list.length; j++){
				if(currentMin.compareTo(list[j]) > 0){
					currentMin = list[j];
					currentIndex = j;
				}
			}
			
			if(currentIndex !=i){
				list[currentIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}
	
	public static void printList(Object[] list) {
		for (Object object : list) {
			System.out.print(object + "");
		}
		System.out.println();
	}

}
