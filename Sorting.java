import java.util.ArrayList;
import java.util.Collections;

public class Sorting {
	private static int min = 1; // minimum value
	private static int max = 500; // max value
	private static int range = max - min; // range of numbers to generate
	private static int amount = 10000; // choose the number of random doubles to generate

	public static void main(String args[]) {
		ArrayList<Double> sortArray = new ArrayList<Double>();
		for (int i = 0; i < amount; i++) {
			sortArray.add(i, (Math.random() * range)); // add values to array
		}
		// System.out.println("Unsorted Array:");
		// printArray(sortArray);
		long startSelect = System.currentTimeMillis(); // start time
		selectionSort(sortArray);
		long endSelect = System.currentTimeMillis(); // end time
		System.out.println("Selection sort took: " + (endSelect - startSelect) + " milliseconds");
		System.out.println();
		long startQuick = System.currentTimeMillis(); // start time
		quickSort(sortArray);
		long endQuick = System.currentTimeMillis(); // end time
		System.out.println("Quick sort took: " + (endQuick - startQuick) + " milliseconds");
	}

	public static void selectionSort(ArrayList<Double> array) {
		int n = array.size(); // stores the value of the array size in a variable
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (array.get(j) < array.get(min)) { //determines the minimum value in the array
					min = j;
				}
			}
			Collections.swap(array, min, i); // swaps the value of i with minimum
		}
		// System.out.println("Selection Sort:");
		// printArray(array);
	}

	public static void quickSort(ArrayList<Double> array) {
		int pivot = amount * (int) Math.random(); // chooses a random pivot
		int middle = (int) Math.ceil(array.size() / 2); // calculates the middle value
		ArrayList<Double> lower = new ArrayList<Double>();
		ArrayList<Double> higher = new ArrayList<Double>();
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) <= pivot) {
				if (i == middle) {
					continue;
				}
				lower.add(array.get(i)); // lower than pivot
			} else {
				higher.add(array.get(i)); // higher than pivot
			}
		}
		// System.out.println("Quick Sort:");
		// printArray(array);
	}

	public static void printArray(ArrayList<Double> array) { // print array method for testing
		int n = array.size();
		for (int i = 0; i < n; i++) {
			System.out.println(array.get(i) + " ");
		}
		System.out.println();
	}
}