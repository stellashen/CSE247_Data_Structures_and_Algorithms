package studio0;

import timing.ExecuteAlgorithm;
import timing.utils.GenSizes;
import timing.utils.IntArrayGenerator;

public class AddOne extends Rarrays {

	/**
	 * We ask for a new, bigger array that is just one element larger
	 *   than the curent one.
	 */
	@Override
	public int getNewSize() {
		//
		// FIXME
		//
		return -1;
		
	}
	
	public String toString() { return "Grow by one"; }

	public static void main(String[] args) {
		GenSizes sizes = GenSizes.arithmetic(1, 1000, 1);
		ExecuteAlgorithm.timeAlgorithm(
				"growbyone", 
				"studio0solved.AddOne", 
				new IntArrayGenerator(), 
				sizes
				);	
	}

}
