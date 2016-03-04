import static java.lang.System.out;

public class UseAnonymousClass {

	// Calls the getWeaponName method.
	static void call_PrintWeaponName(PrintWeapon x) {
		x.getWeaponName();
	}

	public static void main(String[] args) {

		// Create a sword object, which implemented PrintWeapon Class
		Sword mySwordObject = new Sword();
		call_PrintWeaponName(mySwordObject);

		// Create an object by creating an anonymous class
		call_PrintWeaponName(new PrintWeapon() {
			@Override
			public void getWeaponName() {
				System.out.println("Laser Gun (Regular)");
			}
		});

		// Create an object by creating an anonymous class (Lambda Expression)
		call_PrintWeaponName(() -> {
			System.out.println("Laser Gun (Lambda)");
		});

		// Father has original coolMethod()
		PrintSuperCool dad = new PrintSuperCool();
		dad.coolMethod();
		// Son overrides the coolMethod()
		PrintSuperCool son = new PrintCooler();
		son.coolMethod();

		/*
		 *  Creating an object with its subclass is also known as the concept of polymorphism.
		 *  Exception is commonly use for this purpose. 
		 *  For example: Catching an IOException using Exception class on a try-catch statement.
		 */
		
		// Define an object as PrintSuperCool class but implemented it as an
		// PrintCooler class. The PrintCooler is overridden anonymously.
		PrintSuperCool fatherGetsOverriden = new PrintCooler() {
			@Override
			void coolMethod() {
				out.println("Cool stuff happens");
			}
		};

		fatherGetsOverriden.coolMethod();

		// PrintSuperCool does not have methodOnlySonHas() in its definition,
		// so it can not call the method.
		// fatherGetsOverriden.methodOnlySonHas();
	}

}

interface PrintWeapon {
	public void getWeaponName();
}

class Sword implements PrintWeapon {
	@Override
	public void getWeaponName() {
		out.println("Sword");
	}
}

class PrintSuperCool {
	void coolMethod() {
		out.println("Super Cool");
	}
}

class PrintCooler extends PrintSuperCool {
	// @Override checks if the subclass has the super class' methods
	@Override
	void coolMethod() {
		out.println("Cooler than Super Cool");
	}

	void methodOnlySonHas() {
		out.println("I'm the coolest");
	}
}
