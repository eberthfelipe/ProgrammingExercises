package com.java.hackerhank;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];
        
        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Querie[] queries = new Querie[queriesCount];
        
        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = new Querie(queriesItem);
        }
        matchingStrings(strings, queries);

        scanner.close();
	}

	static void matchingStrings(String[] strings, Querie[] queries) {
		for (String auxString : strings) {
			for(int i=0; i<queries.length; i++) {
				if(queries[i].equals(auxString)) {
					queries[i].update();
				}
			}
		}
		for (Querie querie : queries) {
			System.out.println(querie.count);
		}
		
    }
	
}

class Querie {
	String querieName;
	int count;

	Querie(String querieName){
		this.querieName = querieName;
		this.count = 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		String other = (String) obj;
		if (querieName == null) {
			if (other != null)
				return false;
		} else if (!querieName.equals(other))
			return false;
		return true;
	}
	
	public void update(){
		this.count++;
	}
}
