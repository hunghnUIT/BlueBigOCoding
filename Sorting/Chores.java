package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Chores {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for( int i = 0; i  < n; i++) {
				arr.add(sc.nextInt());
		}
		sc.close();

		Collections.sort(arr);

		System.out.println(arr.get(b) - arr.get(b-1));
	}
}
