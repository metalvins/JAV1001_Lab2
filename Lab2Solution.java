import java.util.Scanner;
import java.util.Arrays;

public class Lab2Solution {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a string to encrypt. ");
        String word = s.nextLine();
        System.out.println("What value do you want to encrypt with?");
        Integer offset = s.nextInt();
        offset %= 26;
        String encrypted = encrypt(word.trim(), offset);
        System.out.println(word.trim() + " encrypted is " + encrypted);
        System.out.println("Using " + encrypted + " to test the decryption with " + offset + "...");
        System.out.println("The decrypted string is " + decrypt(encrypted, offset));

        System.out.println("\n\nNow it is time for arrays!!");

        System.out.println("Please enter length of array: ");
        Integer num = s.nextInt();

        System.out.println("Creating an int array of length " + num);
        int[] arr = new int[num];
        boolean[] search = new boolean[101];
        int sum = 0;
        for(int i=0; i<num; i++) {
            arr[i] = (int)(Math.random() * 101);
            search[arr[i]] = true;
            sum += arr[i];
        }
        System.out.println("The array is");
        System.out.println(Arrays.toString(arr));
        System.out.println("The sum of the array is " + sum);

        System.out.println();
        System.out.println("Enter a number to search for in the previous array: ");
        num = s.nextInt();
        String response = "The array does not contain " + num ;
        if(num < 0 || num > 101) {
            System.out.println(response);
        } else {
            System.out.println(!search[num] ? response : "The array contains " + num);
        }

        System.out.println("Now searching using loop...");
        System.out.println(search(arr, num));
    }

    private static String search(int[] arr, int num) {
        for(int i : arr) {
            if(i == num) {
                return "The array contains " + num;
            }
        }
        return "The array does not contain " + num;
    }

    private static String encrypt(String str, int offset) {
        char[] arr = str.toCharArray();

        for(int i=0; i<arr.length; i++) {

            if((Character.isLowerCase(arr[i]) && 'z' < (char)(arr[i] + offset)) 
                || (Character.isUpperCase(arr[i]) && 'Z' < (char)(arr[i] + offset)))  {

                arr[i] += offset - 26;

            } else if ((Character.isLowerCase(arr[i]) && 'a' > (char)(arr[i] + offset))
                || (Character.isUpperCase(arr[i]) && 'A' > (char)(arr[i] + offset))) {

                arr[i] += offset + 26;
            }
            else {
                arr[i] += offset;
            }
        }
        return new String(arr);
    }

    private static String decrypt(String str, int num) {
        return encrypt(str, 0 - num);
    }
}
