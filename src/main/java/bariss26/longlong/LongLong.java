package bariss26.longlong;

public class LongLong {

	public boolean[] bits;
	boolean signed;

	public LongLong(int digits) {
		this(digits, true);
	}

	public LongLong(int digits, boolean signed) {
		this.bits = new boolean[digits];
		this.signed = signed;
	}
	
	public String toBitString() {
		StringBuilder b = new StringBuilder(bits.length);
		for(boolean bit : bits) {
			b.append(bit?"1":0);
		}
		return b.toString();
	}
	
	void add(boolean[] bits) {
		boolean carry = false, bit, selfbit, xor;
		int k = this.bits.length-bits.length;
		for(int i = bits.length-1; i>=0; i--) {
			selfbit = this.bits[i+k];
			bit = bits[i];
			xor = (bit&&!selfbit)||(selfbit&&!bit);
			this.bits[i+k] = (xor&&!carry)||(carry&&!xor);
			carry = (selfbit&&bits[i])||(carry&&xor);
		}
	}
	
	void subtract(boolean[] bits) {
		boolean carry = false, bit, selfbit, xor;
		int k = this.bits.length-bits.length;
		for(int i = bits.length-1; i>=0; i--) {
			selfbit = this.bits[i+k];
			bit = bits[i];
			xor = (bit&&!selfbit)||(selfbit&&!bit);
			this.bits[i+k] = (xor&&!carry)||(carry&&!xor);
			carry = (!selfbit&&bits[i])||(carry&&!xor);
		}
	}
	
	void multiply(boolean[] bits) {
		
	}
	
}