import java.util.ArrayList;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Create integer
		testADT t = new testADT(0);
		
		// Add integerTest to arraylist A
		ArrayList<testADT> A = new ArrayList<testADT>();
		A.add(t);
		
		// Add element of A to arraylist B
		ArrayList<testADT> B = new ArrayList<testADT>();
		B.add(A.get(0));
		
		
		// Before any change
		System.out.println("t: " + t.get());
		System.out.println("t (A): " + A.get(0).get());
		System.out.println("t (B): " + B.get(0).get());
		
		// Modify integerTest from B
		B.get(0).increase();
		
		// See if any change was made
		System.out.println("t: " + t.get());
		System.out.println("t (A): " + A.get(0).get());
		System.out.println("t (B): " + B.get(0).get());
	}
	
	

}


