import static java.lang.System.out;

public class UseInterface implements MIF3 {
	public static void main(String[] args) {
		// Create an instance of MyClass which implemented MyInterface.
		MyClass x = new MyClass();
		x.notInterfaceMethod();
		x.interfaceMethod();

		// You are able to reference an instance to the interface it implemented
		MyInterface y = x;
		y.interfaceMethod();
		// y.notInterfaceMethod();
		// ^ Same instance but MyInterface does not have the method, so you can not call it.

		// Print out that x and y are the same instance. 
		out.println(x);
		out.println(y);

		
		// You can create an instance of an interface using a class that implemented the interface.
		MyInterface z = new MyClass();
		z.interfaceMethod();
	
	}

	// You must implement all method from the interface's super class
	public void m1() {
	}; // MIF1

	public void m2() {
	}; // MIF2

	public void m3() {
	}; // MIF3
}

interface MyInterface {
	// auto add all method of java.lang.Object i.e. toString(), equals()
	int MAX = 100; // auto add public static final
	void interfaceMethod(); // auto add public
	// private void cannotCreate(); You can not create an private method in an interface
}

class MyClass implements MyInterface {

	public void notInterfaceMethod() {
		out.println("I'm an independent method");
	}

	public void interfaceMethod() {
		// The field MAX is automatically added final modifier, so you may not
		// change its value.
		// MAX++;
		out.println("Implement, MAX:" + MAX);
	}
}

interface MIF1 {
	void m1();
}

interface MIF2 {
	void m2();
}

interface MIF3 extends MIF1, MIF2 {
	// Interface can extends other interfaces.
	void m3();
}