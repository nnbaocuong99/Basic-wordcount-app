/**
 * 	  Revision History
 *  	Josh Athwal 
 *   WordCounterApp.java
 * 		Assignment 4
 *  Created: 2022-11-30
 *  Comments: 2022-11-01
 */
package com.wordcounter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordCounterApp {
	/**
	 * Declare Constants
	 */
	public static final int minZero = 0;
	public static final int indexOffsetZero = 1;
	
	/**
	 *  Gets All words from file and assign words into an ArrayList
	 *  Removes numbers and desired special characters (0123456789\\-\\&,.\\/')
	 *  and displays
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Takes All the words from the file and puts the words in an array list. 
		// ArrayList that has the original file text
		try {
			
			ArrayList<String> arrayListFile = new ArrayList<String>();
			
			System.out.print("Enter file name: ");
			Scanner scanner = new Scanner(System.in);

			File file = new File(scanner.nextLine());

			scanner = new Scanner(file);

			StringBuilder initalData = new StringBuilder(
					"Words from file\n");

			while (scanner.hasNextLine()) {
				String scan = scanner.nextLine();
				arrayListFile.add(scan);
				initalData.append(scan + "\n");
			}
			scanner.close();

			System.out.println(initalData.toString());

			/* This deletes numbers and certain characters */
			//this ArrayList has the new data
			
			ArrayList<String> arrayListNew = new ArrayList<String>();

			StringBuilder sbNewData = new StringBuilder(
					"Words after removing special characters\n");

			// filters the numbers and selected characters (0123456789\\-\\&,.\\/') from the file
			for (String string : arrayListFile) {
				String s = string.replaceAll("[0123456789\\-\\&,.\\/']", "");
				if (s.length() != minZero) {
					sbNewData.append(s + "\n");
					arrayListNew.add(s);
				}
			}
			System.out.println(sbNewData.toString());

			/* displays on the console*/
			StringBuilder sbCountData = new StringBuilder(
					"Length -- number of words\n");

			
			ArrayList<Integer> arrayListCount = new ArrayList<Integer>();
			for (String string : arrayListNew) {
				arrayListCount.add(string.length());
			}

			// Finds maximum value of words in the array
			int max = Collections.max(arrayListCount);

			// Maximun array
			int[] arrayCounter = new int[max];

			// checks for characters in the array
			for (int i = minZero; i < arrayCounter.length; i++) {
				for (String string : arrayListNew) {
					if (i + indexOffsetZero == string.length()) {
						arrayCounter[i]++;
					}
				}
				sbCountData.append((i + indexOffsetZero) + " letters | " + arrayCounter[i] + " words\n");
			}

			System.out.println(sbCountData.toString());

		} catch (Exception ex) {
			// TODO: handle exception
			System.err.println("Error: " + ex.getMessage());
		}
	}
}
