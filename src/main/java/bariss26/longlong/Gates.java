package bariss26.longlong;

public class Gates {
	
	public static void and(boolean[] result, boolean[] a, boolean b) {
		for(int i =0; i<a.length; i++) {
			result[i] = a[i]&&b;
		}
	}
	
	public static void and(boolean[] result, boolean[] a, boolean[] b) {
		for(int i =0; i<a.length; i++) {
			result[i] = a[i]&&b[i];
		}
	}

	public static boolean add(boolean[] result, boolean[] a, boolean[] b) {
		boolean carry = false, xor, ba, bb;
		int m = (a.length>b.length?a.length:b.length)-1;
		for(int i = 0; i<m; i++) {
			ba = a[i];
			bb = b[i];
			xor = (ba&&!bb)||(bb&&!ba);
			result[i] = (xor&&!carry)||(carry&&!xor);
			carry = (bb&&ba)||(carry&&xor);
		}
		return carry;
	}

	public static void subtract(boolean[] a, boolean[] b, boolean[] result) {
		boolean carry = false, xor, ba, bb;
		for(int i = 0; i<(a.length>b.length?a.length:b.length); i++) {
			ba = a[i];
			bb = b[i];
			xor = (ba&&!bb)||(bb&&!ba);
			result[i] = (xor&&!carry)||(carry&&!xor);
			carry = (!ba&&bb)||(carry&&!xor);
		}
	}
	
	public static void multiply(boolean[] result, boolean[] a, boolean[] b) {
		if(a.length>b.length) {
			boolean[] t = b;
			b = a;
			a = t;
		}
		boolean[] band = new boolean[a.length];
		boolean[] sum = new boolean[a.length];
		boolean carry = false;
		for(int i = 0; i<b.length; i++) {
			and(band, a, b[i]);
			carry = multipliAdd(sum, band, carry, sum);
			result[i] = sum[0];
		}
		for(int i = result.length-b.length; i>0&&i<sum.length; i++) {
			result[b.length+i-1] = sum[i];
		}
	}

	private static boolean multipliAdd(boolean[] result, boolean[] a, boolean carryIn, boolean[] b) {
		boolean carry = false, xor, ba, bb;
		int m = (a.length>b.length?a.length:b.length);
		for(int i = 0; i<m; i++) {
			ba = a[i];
			bb = i==m-1?carryIn:b[i+1];
			xor = (ba&&!bb)||(bb&&!ba);
			result[i] = (xor&&!carry)||(carry&&!xor);
			carry = (bb&&ba)||(carry&&xor);
		}
		return carry;
	}

}
