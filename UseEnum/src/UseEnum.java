
public class UseEnum {

	public static void main(String[] args) {
		SIZE mySize = SIZE.SMALL;
		System.out.println(mySize);
		System.out.println(SIZE.LARGE);
	}

}


enum SIZE{
	LARGE("L"), MEDIN("M"),SMALL("S");
	
	private String message;
	
	// Constructor can only be private.
	private SIZE(String s){
		message = s;
	}
	
	public String toString(){
		return "Size:" +message;
	}
	
}