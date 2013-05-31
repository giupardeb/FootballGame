public class testADT {
		int integerTest;
		
		public testADT(int i) {
			integerTest = i;
		}
		
		public void increase() {
			integerTest++;
		}
		
		public int get() {
			return integerTest;
		}
	}