package com.java.hackerhank;

import java.io.IOException;
import java.util.Scanner;

public class Exercises {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
		

        System.out.println(hourglassSum(arr));
		scanner.close();
	}

	// Complete the reverseArray function below.
	static int hourglassSum(int[][] arr) {
		int maxValue = -99999;
		int aux;
		for (int i = 1; i < arr.length-1; i++) {
			for (int j = 1; j < arr.length-1; j++) {
				aux = 0;
				aux += arr[j-1][i-1];
				aux += arr[j-1][i];
				aux += arr[j-1][i+1];
				aux += arr[j][i];
				aux += arr[j+1][i-1];
				aux += arr[j+1][i];
				aux += arr[j+1][i+1];
				if(aux>maxValue)
					maxValue = aux;
			}
		}
		return maxValue;
	}


}
