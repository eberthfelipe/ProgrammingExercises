package com.java.hackerhank;

import java.io.IOException;
import java.util.Scanner;

public class Exercises {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		int arrCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		int[] arr = new int[arrCount];
		String[] arrItems = scanner.nextLine().split(" ");

		for (int i = 0; i < arrCount; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int[] res = reverseArray(arr);

		for (int i = 0; i < res.length; i++) {
			System.out.print(String.valueOf(res[i]));
			if (i != res.length - 1) {
				System.out.print(" ");
			}
		}
		scanner.close();
	}

	// Complete the reverseArray function below.
	static int[] reverseArray(int[] a) {
		int[] reverseArray = new int[a.length];
		int lastPosition = a.length-1;
		for(int i=0; i<a.length; i++){
			reverseArray[i] = a[lastPosition];
			lastPosition--;
		}
		return reverseArray;
	}


}
