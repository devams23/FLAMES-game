package FunGames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Description: Below is the code for a very famous game "FLAMES"
 * --->Here in the last step(which is to cancel out the letter in FLAMES string) I have started from the first letter everytime . So the answer might be different if 
 *      in your algorithm you continue from the last letter cancelled out .

 * Author: devam
 * Date: 2024-04-04
 */

public class Flames {
    //------------------------ STEP -1   ------------------------
    static boolean isAnagram(char str1[], char str2[]) {
        int n_chars = 256;
        // Create 2 count arrays and initialize
        // all values as 0
        int count1[] = new int[n_chars];
        Arrays.fill(count1, 0);
        int count2[] = new int[n_chars];
        Arrays.fill(count2, 0);
        int i;
        if (str1.length != str2.length)
            return false;

        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (i = 0; i < str1.length; i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }
        for (i = 0; i < n_chars; i++)
            if (count1[i] != count2[i])
                return false;

        return true;

    }
//------------------------ STEP -2 ------------------------
    static int getcommonlength(char str1[], char str2[]) {

        int final_len = str1.length + str2.length;

        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if ((str1[i] == str2[j]) && (str1[i] != '0')) {
                    // this is to cut two same letters from the final string so substracting by 2
                    final_len -= 2;
                    str1[i] = '0';
                    str2[j] = '0';
                }
            }
        }
        // System.out.println(str1);
        // System.out.println(str2);
        return final_len;
    }
//------------------------ STEP -3 ------------------------
    static char getfinalletter(ArrayList<Character> flame, int length) {
        // this will start from the first index everytime in the flame object
        while (flame.size() != 1) {

            flame.remove(length % flame.size());

        }
        return flame.get(0);
    }

    /* Driver code */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter the second name: ");
        String secondName = sc.nextLine();
        sc.close();
        char str1[] = (firstName).toLowerCase().toCharArray();
        char str2[] = (secondName).toLowerCase().toCharArray();
        ArrayList<Character> flame = new ArrayList<>();
        flame.add('F');
        flame.add('L');
        flame.add('A');
        flame.add('M');
        flame.add('E');
        flame.add('S');

        if (isAnagram(str1, str2)) {
            System.out.println("anagram");
        }

        else {
            int length = getcommonlength(str1, str2) - 1;
            
            char final_letter = getfinalletter(flame, length);
            // System.out.println(final_letter);\
            System.out.println("Your FLAMES Result:");
            switch (final_letter) {
                case 'F':
                    System.out.println("F: Friends - It appears that your relationship is more suited for friendship.");
                    break;
                case 'L':
                    System.out.println("L: Lovers - Well, it seems like there might be some sparks flying between you two!");
                    break;
                case 'A':
                    System.out.println("A: Affectionate - Looks like there's mutual affection between you two.");
                    break;
                case 'M':
                    System.out.println("M: Marriage - It seems like your relationship is built on a strong foundation, making marriage a natural next step.");
                    break;
                case 'E':
                    System.out.println("E: Enemies - Uh oh! It seems like there could be some tension between you two.");
                    break;
                case 'S':
                    System.out.println("S: Siblings - Looks like you two are more like siblings.");
                    break;
                default:
                    System.out.println("Hey! Something is beyond FLAMES...!");
                    break;
            }
            System.out.println("Now that you know your FLAMES result, remember, it's just for fun! Don't take it too seriously. Relationships are complex and unique!");
        }

    }
}
