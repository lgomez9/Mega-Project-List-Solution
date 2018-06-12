import java.util.Scanner;
import java.math.BigDecimal;

public class PiToTheNth {
  // A class that finds Pi to the Nth given digit.
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    BigDecimal twentytwo = new BigDecimal(22.0);
    BigDecimal seven = new BigDecimal(7.0);

    System.out.print("Please enter the digit you'd like to read pi up to: ");

    int n = input.nextInt();

    BigDecimal pi = twentytwo.divide(seven, n, BigDecimal.ROUND_UP);

    if(n > 100 || n < 1) System.out.println("That index is out of bounds!");
    else System.out.println(pi);
  }
}
