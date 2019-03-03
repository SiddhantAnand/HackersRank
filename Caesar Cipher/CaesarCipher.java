import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        String st = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(k > 26){
                k = k % 26;
            }
            if((c > 64 && c < 91) || (c > 96 && c < 123)){ 
                int x = (int)c + k;
                if((int)c <= 122 && (int)c >= 97 && x > 122){
                    st = st + Character.toString((char)(96+x-122));
                }
                else if((int)c <= 90 && (int)c >= 65 && x > 90){
                    st = st + Character.toString((char)(64+x-90));
                }
                else{
                    st = st + Character.toString((char)x);
                }
            }
            else{
                st = st + Character.toString(c);
            }
        }
        return st;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
