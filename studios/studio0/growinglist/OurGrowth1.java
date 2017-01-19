package studio0.growinglist;

import timing.ExecuteAlgorithm;
import timing.utils.GenSizes;
import timing.utils.IntArrayGenerator;

public class OurGrowth1 extends Rarrays {

	/**
	 * Try some function you think will work here.
	 */
	public int getNewSize() {
		//throw new Error("You must implement this function");
		int newsize = (int) (array.length*1.1);
		if (newsize-array.length<1){
			newsize = array.length+1;
		}
		return newsize;
	}
	
	public String toString() { return "Grow by our own function (1)"; }

	public static void main(String[] args) {
		GenSizes sizes = GenSizes.arithmetic(1, 1000, 1);
		ExecuteAlgorithm.timeAlgorithm(
				"growth1", 
				"studio0.growinglist.OurGrowth1", 
				new IntArrayGenerator(), 
				sizes
				);	
	}

}
