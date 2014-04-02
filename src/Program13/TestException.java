package Program13;

public class TestException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(sum(new int[]{1,2,3,4,5}));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("\n" + e.getMessage());
			System.out.println("\n" + e.toString());
			
			System.out.println("\nTrace Info Obtained from getStackTrace");
			StackTraceElement[] traceElements = e.getStackTrace();
			for (StackTraceElement stackTraceElement : traceElements) {
				System.out.print("method " + stackTraceElement.getMethodName());
				System.out.print("(" + stackTraceElement.getClassName() + ":");
				System.out.println(stackTraceElement.getLineNumber() + ")");
			}
		}
	}
	
	public static int sum(int[] list){
		int result = 0;
		for(int i=0; i<=list.length;i ++)
			result += list[i];
		return result;
	}

}
