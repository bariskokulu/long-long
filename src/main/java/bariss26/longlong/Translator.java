package bariss26.longlong;

public class Translator {
	
	public static boolean[] switchEndian(boolean[] bits) {
		boolean[] newbits = new boolean[bits.length];
		for(int i = 0; i<bits.length; i++) {
			newbits[bits.length-i-1] = bits[i];
		}
		return newbits;
	}
	
	public static void flipEndian(boolean[] bits) {
		boolean[] newbits = new boolean[bits.length];
		for(int i = 0; i<bits.length; i++) {
			newbits[bits.length-i-1] = bits[i];
		}
		System.arraycopy(newbits, 0, bits, 0, bits.length);
	}
	
	public static String bitString(boolean[] bits) {
		StringBuilder b = new StringBuilder(bits.length);
		for(boolean bit : bits) {
			b.append(bit?"1":0);
		}
		return b.toString();
	}

}
