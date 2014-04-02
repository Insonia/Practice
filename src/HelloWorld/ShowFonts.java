package HelloWorld;

import java.awt.GraphicsEnvironment;

public class ShowFonts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontname = e.getAvailableFontFamilyNames();
		
		for (String string : fontname) {
			System.out.println(string);
		}
	}

}
