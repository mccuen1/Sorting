
/*
∗ CSC144 Object−Oriented Programming
∗ Brodie McCuen
∗ 16 November 2021
*/

import java.util.*;

public class Sorting {

    // creates a list of random numbers with a defined size
    public static List<Integer> makeList(int size, Random rng) {
        List<Integer> list = new ArrayList<>();

        for (int i=0; i < size; i++) {
            int n = 10 + rng.nextInt(100); // nextInt like rand_int
            list.add(n);
        }

        return list;
    } // end of makeList()

    public static void printList(List<Integer> list) {
        for(int n : list) {
            System.out.print(n + " ");
        }
    } // end of PrintList()


    public static int smallestNumber(List<Integer> list) {
        int smallest;
        smallest = list.get(0);

        for (int n : list) {
            if (n < smallest) {
                smallest = n;
            }
        }

        return smallest;

    } // end of smallestNumber

    public static int getIndexSmallest(List<Integer> list) {
        int smallest = smallestNumber(list);
        int index = list.indexOf(smallest);

        return index;

    } // end getIndexSmallest

    public static int smallestFromIndex(List<Integer> list, int starting) {
        int index = starting;

        // create a new list of integers starting at the index
        for (int i=starting; i < list.size(); i++) {
            if (list.get(i) < list.get(index)) {
                index = i;
            }
        }

        return index;
    } // end smallestIndexFromIndex

    public static void swap(List<Integer> list, int index1, int index2) {
        int value1 = list.get(index1);
        int value2 = list.get(index2);

        list.set(index1, value2);
        list.set(index2, value1);
    } // end swapIndex

    public static void selectionSort(List<Integer> list) {
        for (int i=0; i < list.size(); i++) {
            int j = smallestFromIndex(list, i);
            swap(list, i, j);
        }
    }


    public static boolean ascending(List<Integer> list, int max) {
        int previous = list.get(0);
        for (int i=1; i <= max; i++) {
            if (list.get(i) >= previous) {
                previous = list.get(i);
            }
            else {
                return false;
            }  
        }
        return true;
    } //ascending(list, max)


    public static void move(List<Integer> list, int max) {
        int j = max + 1;
        swap(list, max, j);

        if (!ascending(list, max)) {
            move(list, max-1);
        }
    }

    public static List<Integer> merge(List<Integer> sorted1, List<Integer> sorted2) {
        int index1 = 0;
        int index2 = 0;
        List<Integer> sorted = new ArrayList<>();

        // takes smaller number from either list and adds it to the new list
        while (index1 != sorted1.size() && index2 != sorted2.size()) {

            if (sorted1.get(index1) <= sorted2.get(index2)) {
                sorted.add(sorted1.get(index1));
                index1 += 1;
            }
            else {
                sorted.add(sorted2.get(index2));
                index2 += 1;
            }
        }

        // checks for remaining numbers left in the two lists
        if (index1 == sorted1.size()) {
            for (int i=index2; i < sorted2.size(); i++) {
                sorted.add(sorted2.get(i));
            }
        }
        else if (index2 == sorted2.size()) {
            for (int i=index1; i < sorted1.size(); i++) {
                sorted.add(sorted1.get(i));
            }
        }

        return sorted;   
    } // merge(sorted1, sorted2)


    public static void main(String [] args) {
        Random rng = new Random();
        final int NUM = 100;

        // makeList method takes size, random number
        List<Integer> data = makeList(NUM, rng);
        List<Integer> list1 = Arrays.asList(2, 5, 6, 7, 7, 10, 11);
        List<Integer> list2 = Arrays.asList(4, 4, 7, 8, 9, 15, 90);

        List<Integer> sorted = merge(list1, list2);
        printList(sorted);


    } // end of main


}
