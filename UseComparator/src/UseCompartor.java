import java.util.*;
import static java.lang.System.out;

public class UseCompartor {

	public static void main(String[] args) {
		// Creates some custom shirt objects.
		Shirt r = new Shirt("Red", 10);
		Shirt b = new Shirt("Blue", 465);
		Shirt g = new Shirt("Green", 3213456);
		// Creates some custom comparator object.
		SizeComp s = new SizeComp();
		ColorComp c = new ColorComp();
		// Creates some tree sets using custom comparator. 
		TreeSet<Shirt> mySizeSet = new TreeSet<>(s);
		mySizeSet.add(r);
		mySizeSet.add(g);
		mySizeSet.add(b);
		out.println("Sort by Size");
		out.println(mySizeSet);
		
		TreeSet<Shirt> myCompSet = new TreeSet<>(c);
		myCompSet.add(r);
		myCompSet.add(g);
		myCompSet.add(b);
		out.println("Sort by Color");
		out.println(myCompSet);
	}

}

class Shirt{
	String color;
	int Size;

	Shirt(String color, int Size) {
		this.color = color;
		this.Size = Size;
	}

	@Override
	public String toString() {

		return "Color: " + this.color + "\tSize: " + Size + "\n";
	}
}

class ColorComp implements Comparator<Shirt> {
	@Override
	public int compare(Shirt x, Shirt y) {
		return x.color.compareTo(y.color);
	}
}

class SizeComp implements Comparator<Shirt> {
	@Override
	public int compare(Shirt x, Shirt y) {
		return x.Size - y.Size;
	}
}