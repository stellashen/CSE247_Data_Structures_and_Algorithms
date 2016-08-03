package kwaymergesort.test;

import timing.ExecuteAlgorithm;
import timing.utils.GenSizes;
import timing.utils.IntArrayGenerator;

public class MergeSortTimer {


	public MergeSortTimer() {
	}



	public static void main(String[] args) {
		runExperiment(30000);   // FIXME change to 25000 or some large number so times show up
	}

	private static void runExperiment(int factor) {
		int start = 5;
		int end   = 50;
		GenSizes sizes = GenSizes.arithmetic(start*factor, end*factor, factor);
		ExecuteAlgorithm.timeAlgorithm(
				"mergesort", 
				"kwaymergesort.MergeSort", 
				new IntArrayGenerator(), 
				sizes
				);
	}

}
