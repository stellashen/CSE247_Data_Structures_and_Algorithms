package week1;

import cse131.ArgsProcessor;

//2. check if a string has all unique characters ("aabd" fails; "abcd" passes)
public class unique {
	
	public static boolean isUnique(String a){
		char[] arrayA = a.toCharArray();
		for (int i=1; i < arrayA.length;i++){
			for (int j=0; j < i; j++){
				if(arrayA[i]==arrayA[j]){
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String stringC = ap.nextString("Please enter a string to check if it has unique characters.");
		boolean result2 = isUnique(stringC);
		System.out.println("Does " + stringC + " have unique characters? " + result2);

	}

}
