package Program14;

public class TestEdible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] objects = {new Tiger(), new Chicken(), new Apple(), new Orange()};
		for (Object object : objects) {
			if(object instanceof Edible)
				System.out.println(((Edible)object).howToEat());
		}
	}
}
class Animal{
	
}

class Chicken extends Animal implements Edible{
	public String howToEat(){
		return "Chicken: Fry it.";
	}
}

class Tiger extends Animal{
	
}

abstract class Fruit implements Edible{
	
}

class Apple extends Fruit{

	@Override
	public String howToEat() {
		// TODO Auto-generated method stub
		return "Apple : Male apple cider";
	}
}

class Orange extends Fruit{

	@Override
	public String howToEat() {
		// TODO Auto-generated method stub
		return "Orange: Make orange juice.";
	}
	
}

