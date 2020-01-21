/*
 	Maxx Mudd on 1/20/2020
 	HackerRank exercise: Caesar Cipher
 	
 	--PROBLEM--
 	
  	Julius Caesar protected his confidential information by encrypting it using a cipher. Caesar's cipher shifts each letter by a number of letters.
 	If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet. In the case of a rotation by 3, w, x, y and z 
 	would map to z, a, b and c.

	Original alphabet:      abcdefghijklmnopqrstuvwxyz
	Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc
	
	For example, the given cleartext:
	s = There's-a-starman-waiting-in-the-sky 
	and the alphabet is rotated by k = 3. The encrypted string is:
	Wkhuh'v-d-vwdupdq-zdlwlqj-lq-wkh-vnb
	
	Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.
	
	--FUNCTION DESCRIPTION--

	Complete the caesarCipher function in the editor below. It should return the encrypted string.

	caesarCipherHR has the following parameter(s):

	s: a string in cleartext
	k: an integer, the alphabet rotation factor
	Input Format

	The first line contains the integer, n, the length of the unencrypted string.
	The second line contains the unencrypted string, s.
	The third line contains k, the number of letters to rotate the alphabet by.

	--CONSTRAINTS--
	
	1 <= n <= 100
	0 <= k <= 100
	
	s is a valid ASCII string without any spaces.
 
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class caesarCipherHR {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
    	// create arrays of both upper case and lower case alphabet
        char[] upArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] lowArr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        // convert the string to a char array for manipulation
        char[] charArr = s.toCharArray();
        // loop through the entire character array
        for(int i = 0; i < s.length(); i++) {
            // if the character is a letter, begin case checking
            if(Character.isLetter(charArr[i]) == true) {
                // if letter is upper case, begin looping through upper case alphabet
                if(Character.isUpperCase(charArr[i]) == true) {
                     for(int j = 0; j < 26; j++) {
                    	 // once the letter is found, add the rotation factor to the index
                        if(charArr[i] == upArr[j]) {
                        	// if the index is greater than the length of the alphabet, wrap index around
                            int temp = j+k;
                            if(temp > 26) {
                                temp %= 26;
                            }
                            // assign the new letter to the current character and exit the loop
                            charArr[i] = upArr[temp];
                            break;
                        }
                    }
                     // if the letter is lower case, begin looping through lower case alphabet
                } else if (Character.isLowerCase(charArr[i]) == true) {
                    for(int j = 0; j < 26; j++) {
                    	// once the letter is found, add the rotation factor to the index
                        if(charArr[i] == lowArr[j]) {
                        	// if the index is greater than the length of the alphabet, wrap index around
                            int temp = j+k;
                            if(temp > 26) {
                                temp %= 26;
                            }
                            // assign the new letter to the current character and exit the loop
                            charArr[i] = lowArr[temp];
                            break;
                        }
                    }

                } else {
                	// do nothing if the current character is not a letter
                }
            }
        }
        
        // reassign the character array as a string then return it
        s = new String(charArr);
        return s;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();
    }
}
