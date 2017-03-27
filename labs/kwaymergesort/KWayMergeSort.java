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
		ticker.tick();

		//test
//		System.out.println("--------------");
//		System.out.println("n="+n);
//		System.out.println("K="+K);
//		for(int i = 0; i < n; i++){
//			System.out.print(input[i] + " ");
//		}
//		System.out.println();

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
		ticker.tick();

		// if only one element, then it's sorted.
		if(n==1){
			ans[0] = input[0];
			ticker.tick();
			//System.out.println("Base case");
		}
		else{
			int size = n/K;
			//System.out.println("size = " + size);
			//split the arrays, store them in a 2d array
			Integer[][] sortedArrays = new Integer[K][size];
			Integer[][] arraysToMerge = new Integer[K][size];
			ticker.tick(3); 
			//split the input array into K arrays
			for (int i = 0; i < K; i++){
				//Integer[] sorted = new Integer[size];
				for (int j=0; j < size; j++){
					sortedArrays[i][j] = input[i*size+j];
					ticker.tick(); 
					//array 0: input[0,1,2,....size-1]
					//array 1: input[size,size+1,size+2...2size-1]
					//...array K-1: input[(K-1)size,....K*size-1]
					//System.out.println("sortedArrays["+i+"]["+j+"]="+sortedArrays[i][j]);
				}
				arraysToMerge[i] = kwaymergesort(K,sortedArrays[i],ticker);
				ticker.tick();
			}
			//test
//			System.out.println("arraysToMerge: ");
//			for(int c = 0; c<K; c++){
//				for(int r = 0; r<size; r++){
//					System.out.print(arraysToMerge[c][r] + " ");
//				}
//				System.out.println();
//			}

			//merge K arrays into one array 
			ans = mergeArrays(arraysToMerge, K, size,ticker);
			ticker.tick();
		}

//		System.out.print("ans: ");
//		for(int i = 0; i < n; i++){
//			System.out.print(ans[i]);
//		}
//		System.out.println(".");

		return ans;
	}

	public static Integer[] mergeArrays(Integer[][] arrays, int K, int size, Ticker ticker){
		Integer[] ans = new Integer[size*K];
		ticker.tick();
		while (K>1){
			//use a 2-dimensional array to store merged arrays
			Integer[][] merged = new Integer[K/2][size*2];
			//there are K/2 even/odd pairs
			//merge each pair, then store the new array in the 2d-array merged
			Integer[] evenArray = new Integer[size];
			Integer[] oddArray = new Integer[size];
			Integer[] newArray = new Integer[size*2];
			ticker.tick(4);
			
			for (int i = 0; i < K/2; i++){
				//get one pair
				for (int j = 0; j < size; j++){
					evenArray[j] = arrays[i*2][j];
					oddArray[j] = arrays[i*2+1][j];
					ticker.tick(2);
				}
				//merge one pair
				newArray = mergeOnePair(evenArray,oddArray,size,ticker);
				ticker.tick();
				//store the merged array (merged from the ith pair)
				for(int count=0; count < size*2; count++){
					merged[i][count] = newArray[count];
					ticker.tick();
				}
			}
			//test
//			System.out.println("merged:");
//			for(int r = 0; r < K/2; r++){
//				for(int c = 0; c < 2*size;c++){
//					System.out.print(merged[r][c]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("end of merged");

			//after merging pairs, there are K/2 arrays (new size = size*2)
			K = K/2;
			size = size*2;
			arrays = merged;
			ticker.tick(3);
			if(K==1){
				ans = merged[0];
				ticker.tick();
			}
		}
		return ans;
	}

	private static Integer[] mergeOnePair(Integer[] evenArray,Integer[] oddArray,int size, Ticker ticker) {
		//test
//		System.out.print("evenArray: ");
//		for(int c = 0; c < evenArray.length;c++){
//			System.out.print(evenArray[c]+" ");
//		}
//		System.out.println("end of evenArray");
//		System.out.print("oddArray:");
//		for(int c = 0; c < oddArray.length;c++){
//			System.out.print(oddArray[c]+" ");
//		}
//		System.out.println("end of oddArray");
//		System.out.println("size="+size);
		
		Integer[] newArray = new Integer[size*2];
		int countEven = 0;
		int countOdd = 0;
		int countNew = 0;
		ticker.tick(4);

		while (countEven < size && countOdd < size){
			ticker.tick();
			if(evenArray[countEven] < oddArray[countOdd]){
				newArray[countNew] = evenArray[countEven];
				countNew++;
				countEven++;
				ticker.tick(3);
			}
			else{
				newArray[countNew] = oddArray[countOdd];
				countNew++;
				countOdd++;
				ticker.tick(3);
			}
		}

		if(countEven == size){
			ticker.tick();
			//copy the rest of oddArray to newArray
			for(int c = countNew; c < 2*size; c++){
				newArray[c] = oddArray[countOdd];
				countOdd++;
				ticker.tick(2);
			}
		}
		else{
			for(int c = countNew; c < 2*size; c++){
				newArray[c] = evenArray[countEven];
				countEven++;
				ticker.tick(2);
			}
		}
		return newArray;
	}

	public static void main(String[] args) {
		Integer[] input = {4,5,7,6,3,4,1,0,8,9,2,4,5,3,4,1};
		Ticker ticker = null;
		Integer[] mergedFinal = kwaymergesort(4,input,ticker);
	}
}