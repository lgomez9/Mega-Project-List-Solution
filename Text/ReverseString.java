import java.io.*;
import java.util.Scanner;

/* Reverse a String - Enter a string and the program will reverse it
 * and print it out. */

class StringReverse {
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    StringBuilder backward = new StringBuilder();

    System.out.print("Enter a string to reverse: ");
    String forward = in.nextLine();

    int len = forward.length();

    for(int i = len-1; i >= 0; i--) {
      backward.append(forward.charAt(i));
    }

    String reversed = backward.toString();

    System.out.println("String reversed: " + reversed);
  }
}
