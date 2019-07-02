package com.java.hackerhank;

import java.io.IOException;
import java.util.Scanner;

public class Exercises {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        leftRotation(n, d, a);

		scanner.close();
	}

	static void leftRotation(int n, int d, int[] array) {
		int[] auxArray = new int[n];
		int pos;
		if(d >= n)
			d -= n;
		for (int i = 0; i < array.length; i++) {
			pos = n-d+i;
			if(pos>=array.length)
				pos-=array.length;
			auxArray[pos] = array[i];
		}
		for (int i = 0; i < auxArray.length; i++) {
			System.out.print(auxArray[i] + " ");
		}
	}


}
