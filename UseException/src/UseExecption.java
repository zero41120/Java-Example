import static java.lang.System.out;
import java.io.*;

public class UseExecption {

	public static void main(String[] args) {
		/*
		 * The following is an example of try-catch-finally statement.
		 */
		String a = null;
		try {
			// Try to catch an Exception.
			out.println(a.length());
		} catch (NullPointerException e) {
			// Get a NullPointerException
			out.println(e);
			out.println("Can not print length becuase object is Null");
			
		} catch (Exception e) {
			// Get a general Exception
			e.printStackTrace();
			out.println("This catch statement catches any Exception other than NullPointerException");

		} finally {
			// Do this no matter what happens
			out.println("-----");
		}

		MyObj x = new MyObj();
		try {
			x.open();
			x.close();
		} catch (Exception e) {
			out.println(e);
			out.println("Called close() and it has thrown an Exception");
		} finally {
			out.println("-----");
		}

		try (MyObj y = new MyObj();) {
			// ^ this kind of statement is usually used for opening files.
			x.open();
			Exception customExceptionMessage = new Exception("y.close() is called automatically");
			throw customExceptionMessage;
		} catch (Exception e) {
			e.printStackTrace();
			out.println("X.close is not automatically called because it is not in this scope.");
		} finally {
			out.println("-----");
		}

		int someNum = (int) (Math.random() * 10);
		try {
			if (someNum > 4)
				throw new CustomException("Greater than 4");
			if (someNum < 6)
				throw new CutsomRuntimeException("Less than 6");
		} catch (CustomException | CutsomRuntimeException e) {
			// Catch statement can catch multiple Exceptions
			out.println(e);
		} catch (Exception e) {
			out.println(e);
		} finally {
			out.println("-----");
		}

		try {
			// Activated assert at run-time by -ea option on the java command.
			// Assert is not turned on by default.
			x.methodWithAssert(1);
			x.methodWithAssert(-5);
			x.methodWithAssert(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class MyObj implements AutoCloseable {
	void open() {
		out.println("open");
	}

	@Override
	public void close() throws Exception {
		throw new Exception("Closed");
	}

	void methodWithAssert(int x) {
		assert (x > 0) : "x = " + x;
		out.println("x = " + x);
	}

}

class CustomException extends Exception {
	CustomException(String s) {
		super(s);
	}
}

class CutsomRuntimeException extends RuntimeException {
	CutsomRuntimeException(String s) {
		super(s);
	}
}

class CustomIOException {
	void m1() throws IOException {

	}
}

class CustomException_NoChange extends CustomIOException {
	@Override
	void m1() throws IOException {
		// Same method definition
	}
}

class CustomException_NoThrows extends CustomIOException {
	@Override
	void m1() {
		// Method is not necessary to throw Exception.
	}
}

class CustomException_UseSubexception extends CustomIOException {
	void m1() throws FileNotFoundException {
		// subclass exception is fine
	}
}

class CustomException_UseSubexceptions extends CustomIOException {
	void m1() throws EOFException, FileNotFoundException {
		// Throwing multiple subexceptions are fine

	}
}

class CustomException_UseOtherException extends CustomIOException {
	// void m1() throws java.awt.AWTException{
	// Yon can not change exception type to other exception class.
	// }

}
