package week1;
import cse131.ArgsProcessor;
//1. check if two strings are permutations of each other

public class permutation {

	public static boolean checker(String a,String b){
		boolean charFound = false;
		if (a.length() != b.length()){
			return false;
		}
		char[] arrayA = a.toCharArray();
		char[] arrayB = b.toCharArray();
		for (int i=0; i<arrayA.length;i++){
			for (int j=0;j<arrayB.length;j++){
				if (arrayB[j]==arrayA[i]){
					charFound=true;
					//replace arrayB with a new arrayB without the character arrayB[j]
					char[] arrayC = new char[arrayB.length - 1];
					for (int k=0;k<j;k++){
						arrayC[k]=arrayB[k];
					}
					for (int m=j;m<arrayC.length;m++){
						arrayC[m]=arrayB[m+1];
					}
					arrayB = arrayC;
					//to exit the for loop of arrayB
					j=arrayB.length;
				}
				else{
					charFound=false;
				}
			}
			if (charFound==false){
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String stringA = ap.nextString("Please enter the first string.");
		String stringB = ap.nextString("Please enter the second string.");
		boolean result = checker(stringA,stringB);
		System.out.println("Do " + stringA + " and " + stringB + " have the same permutations? " + result);


	}
}
