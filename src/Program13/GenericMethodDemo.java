package Program13;

public class GenericMethodDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] integers = {1,22,3,4,5};
		String[] strings = {"asd","Milo","Sb"};
		GenericMethodDemo.<Integer>print(integers);
		GenericMethodDemo.<String>print(strings);
	}
	
	public static <E> void print(E[] list){
		for(int i = 0; i< list.length; i++)
			System.out.print(list[i] + " ");
		System.out.println();
	}

}
