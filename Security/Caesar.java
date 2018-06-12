import java.io.*;
import java.util.Scanner;

/* Caesar cipher - Implement a Caesar cipher, both encoding and decoding.
 * The key is an integer from 1 to 25. This cipher rotates the letters of the
 * alphabet (A to Z). The encoding replaces each letter with the 1st to 25th
 * next letter in the alphabet (wrapping Z to A). So key 2 encrypts "HI" to "JK",
 * but key 20 encrypts "HI" to "BC". This simple "monoalphabetic substitution cipher"
 * provides almost no security, because an attacker who has the encoded message
 * can either use frequency analysis to guess the key, or just try all 25 keys. */

class Caesar {

  static String enc(String cipher, int key) {
    // Encode the given message with the given integer
    StringBuilder code = new StringBuilder();
    int len = cipher.length();

    for(int i = 0; i < len; i++) {
      char c;

      if(cipher.charAt(i) == ' ') c = ' ';
      else c = (char) ('A' + ((cipher.charAt(i) + key - 'A') % ('Z' - 'A')));


      code.append(c);
    }

    // Return the encoded message.
    return code.toString();
  }

  static String dec(String code, int key) {
    return enc(code, 25-key);
  }

  public static void main(String args[]) {
    // Accepts only characters above 'A' and less than 'Z'
    Scanner in = new Scanner(System.in);
    int key = 0;
    String cipher;
    String encode;
    String decode;

    System.out.print("Enter the message you would like to encode: ");
    cipher = in.nextLine();
    System.out.print("Enter the key (an int from 1 to 25): ");
    if(in.hasNextInt()) key = in.nextInt();

    System.out.print("Here is that message encoded: ");
    encode = enc(cipher, key);
    System.out.println(encode);

    System.out.print("Here is that message decoded: ");
    decode = dec(encode, key);
    System.out.println(decode);
  }
}
