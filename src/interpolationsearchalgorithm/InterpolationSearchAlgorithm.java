/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpolationsearchalgorithm;

import java.util.Scanner;

/**
 *
 * @author Minh Tan
 */
public class InterpolationSearchAlgorithm {

    // Array of items on which search will 
    // be conducted. 
    static int arr[] = new int[]{10, 12, 13, 16, 18, 19, 20, 21, 22, 23,
        24, 33, 35, 42, 47};

    // If findValue is present in arr[0..n-1], then returns 
    // index of it, else returns -1. 
    static int interpolationSearch(int findValue) {
        // Find indexes of two corners 
        int lo = 0, hi = (arr.length - 1);

        // Since array is sorted, an element present 
        // in array must be in range defined by corner 
        while (lo <= hi && findValue >= arr[lo] && findValue <= arr[hi]) {

            if (lo == hi) {
                if (arr[lo] == findValue) {
                    return lo;
                }
                return -1;
            }

            // Probing the position with keeping 
            // uniform distribution in mind. 
            int pos = lo + (((hi - lo)
                    / (arr[hi] - arr[lo])) * (findValue - arr[lo]));

            // Condition of target found 
            if (arr[pos] == findValue) {
                return pos;
            }

            // If findValue is larger, findValue is in upper part 
            if (arr[pos] < findValue) {
                lo = pos + 1;
            } // If findValue is smaller, findValue is in the lower part 
            else {
                hi = pos - 1;
            }
        }
        return -1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Init Scanner object
        Scanner cin = new Scanner(System.in);
        
        //Enter find value
        System.out.print("Enter value want to search: ");
        int findValue = cin.nextInt();
        
        //index element found
        int index = interpolationSearch(findValue);

        // If element was found 
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found.");
        }
    }

}
