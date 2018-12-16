import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingValleys function below.
    private static final Scanner scanner = new Scanner(System.in);
    static int countingValleys(int n, String s) {
        char c = s.charAt(0),c1; 
        int count = 0,count1 = 0,count2 = 0;
        for(int i = 0; i<n; i++)
        {
            c1 = s.charAt(i);
            if(count == 0){
                if(c1 == 'U'){
                    count++;
                    if (count - count1 == 0) {
                        count2++;
                    }
                }
                else if(c1 == 'D'){
                        count1++;
                    }
                }
            else if(c1 == 'U'){
                count++;
                if (count - count1 == 0) {
                    count2++;
                }
            }
            else{
                count--;
            }
        }
        return count2;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
