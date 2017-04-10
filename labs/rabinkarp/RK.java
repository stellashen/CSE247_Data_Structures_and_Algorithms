package rabinkarp;

public class RK {
	//
	// Be sure to look at the write up for this assignment
	//  so that you get full credit by satisfying all
	//  of its requirements
	//

	private int m;
	private int[] c;
	private int h;
	private int i;

	/**
	 * Rabin-Karp string matching for a window of the specified size
	 * @param m size of the window
	 */
	public RK(int m) {
		this.m = m;
		c = new int[m];
		h = 0;
		i = 0;
	}
	/**
	 * Compute the rolling hash for the previous m-1 characters with d appended.
	 * @param d the next character in the target string
	 * @return
	 */
	public int nextCh(char d) {
		// int max value is 2,147,483,647
		// 31^7 will cause overflow
		int p=(int)Math.pow(31, m);
		h = (h*31 - c[i%m]*p % 511 + d) % 511;
		c[i%m]=d;
		i++;
		return h;
	}

}
