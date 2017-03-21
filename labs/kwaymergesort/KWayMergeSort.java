package kwaymergesort;

import timing.Ticker;

public class KWayMergeSort {

	/**
	 * 
	 * @param K some positive power of 2.
	 * @param input an array of unsorted integers.  Its size is either 1, or some other power of 2 that is at least K
	 * @param ticker call .tick() on this to account for the work you do
	 * @return
	 */
	public static Integer[] kwaymergesort(int K, Integer[] input, Ticker ticker) {
		int n = input.length;

		//
		// FIXME
		// Following just copies the input as the answer
		//
		// You must replace the loop below with code that performs
		// a K-way merge sort, placing the result in ans
		//
		// The web page for this assignment provides more detail.
		//
		// Use the ticker as you normally would, to account for
		// the operations taken to perform the K-way merge sort.
		//
		Integer[] ans = new Integer[n];
		//		for (int i=0; i < n; ++i) {
		//			ans[i] = input[i];
		//			ticker.tick();
		//		}

		// if only one element, then it's sorted.
		if(n==1){
			ans[0] = input[0];
		}
		else{
			//merge sort
			int size = n/K;
			//store the arrays returned by each call
			Integer[][] sortedArrays = new Integer[K][size];
			//split the input array into K arrays
			for (int i = 0; i < K; i++){
				for (int j=0; j < size; j++){
					ans[j] = input[i*size+j];
				}
				Integer[] returned = kwaymergesort(K, ans, ticker);
				for (int m=0; m < size; m++){
					sortedArrays[i][m] = returned[m];
				}
			}
			//merge K arrays into one array
			//there are K/2 even/odd pairs
			//merge each pair
			Integer[] evenArray = new Integer[size];
			Integer[] oddArray = new Integer[size];
			for (int i = 0; i < K/2; i++){
				for (int j = 0; j < size; j++){
					evenArray[j] = sortedArrays[i*2][j];
					oddArray[j] = sortedArrays[i*2+1][j];
				}
				int count = 0;
				for (int a = 0; a < size; a++){
					for (int b = 0; b < size; b++){
						while(evenArray[a] > oddArray[b]){
							ans[count]=evenArray[b];
							count++;
						}
						//???
					}

				}
			}
		}
		return ans;
	}

}
