package bariss26.longlong;

public class Demo {

	public static void main(String[] args) {
//		boolean[] a = new boolean[] {false, true, false, false};
//		boolean[] b = new boolean[] {false, false, true, false};
//		boolean[] r = new boolean[8];
//		Gates.multiply(r, b, a);
//		System.out.println();
//		asd(a);
//		asd(b);
//		asd(r);
		
		long l = System.currentTimeMillis();
		System.out.println(l);
		asd(Translator.toBits(l));
		System.out.println(Translator.toLong(Translator.toBits(l)));
	}
	
	public static void asd(boolean[] b) {
		System.out.println(Translator.bitString(Translator.switchSignificance(b)));
	}
	
}
