import java.io.*;
import java.util.Scanner;

// Fibonacci Sequence - Enter a number and have the program generate the Fibonacci sequence to that number or to the Nth number.

class Fib {

  public static void main(String args[]) {

    PrintWriter output = new PrintWriter(System.out, true);
    Scanner input = new Scanner(System.in);
    int n = 1;

    output.println("Enter the number that you would like to calculate the Fibonacci sequence up to: ");
    if (input.hasNextInt()) n = input.nextInt();

    int result[] = new int[n];

    // Store the base cases
    result[0] = 1;
    result[1] = 1;

    if(n >= 2) {
      // Iteratively add the results to the array, until you reach the target number.
      for(int i = 2; i < n; i++) {
        result[i] = result[i-1] + result[i-2];
      }
    }

    output.println("The fibonacci sequence is: ");

    for(int i : result) {
      output.print(i + " ");
    }
    output.println();
  }
}
