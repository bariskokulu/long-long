package bariss26.longlong;

public class Translator {
	
	public static boolean[] switchSignificance(boolean[] bits) {
		boolean[] newbits = new boolean[bits.length];
		for(int i = 0; i<bits.length; i++) {
			newbits[bits.length-i-1] = bits[i];
		}
		return newbits;
	}
	
	public static void flipSignificance(boolean[] bits) {
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
	
	public static boolean[] toBits(byte b) {
		boolean[] bits = new boolean[8];
		for(int i = 0; i<8; i++) {
			bits[i] = ((b>>>i)&1)==1;
		}
		return bits;
	}
	
	public static boolean[] toBits(short s) {
		boolean[] bits = new boolean[16];
		for(int i = 0; i<16; i++) {
			bits[i] = ((s>>>i)&1)==1;
		}
		return bits;
	}
	
	public static boolean[] toBits(char c) {
		boolean[] bits = new boolean[16];
		for(int i = 0; i<16; i++) {
			bits[i] = ((c>>>i)&1)==1;
		}
		return bits;
	}
	
	public static boolean[] toBits(int i) {
		boolean[] bits = new boolean[32];
		for(int t = 0; t<32; t++) {
			bits[t] = ((i>>>t)&1)==1;
		}
		return bits;
	}
	
	public static boolean[] toBits(long l) {
		boolean[] bits = new boolean[64];
		for(int i = 0; i<64; i++) {
			bits[i] = ((l>>>i)&1)==1;
		}
		return bits;
	}
	
	public static long toLong(boolean[] bits) {
		long l = 0;
		for(int i = 63; i>=0; i--) {
			l=(l<<1)|(bits[i]?1:0);
		}
		return l;
	}
	
	public static int toInt(boolean[] bits) {
		int i = 0;
		for(int t = 32; t>0; t--) {
			i=(i<<1)|(bits[t-1]?1:0);
		}
		return i;
	}
	
	public static char toChar(boolean[] bits) {
		char c = 0;
		for(int i = 15; i>=0; i--) {
			c=(char) (((c&0x7FFF)<<1)|(bits[i]?1:0));
		}
		return c;
	}
	
	public static short toShort(boolean[] bits) {
		short s = 0;
		for(int i = 15; i>=0; i--) {
			s=(short) (((s&0x7FFF)<<1)|(bits[i]?1:0));
		}
		return s;
	}
	
	public static byte toByte(boolean[] bits) {
		byte b = 0;
		for(int i = 7; i>=0; i--) {
			b=(byte) (((b&0xFF)<<1)|(bits[i]?1:0));
		}
		return b;
	}

}
