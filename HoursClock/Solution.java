import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int p = (m-2) * (n-2);
        int s[] = new int[p];
        int sum = 0;
        int count = 0, j = 0, a = 0;
        for(int i = 0; i < (m-2) * (n-2); i++){
            s[i] = 0;
        }
        System.out.println(p);
        while(p != 0){
            int i;
            for(i = 0; i < (arr[0].length)/2; i++){
                s[count] = s[count] + arr[j][a];
                s[count] = s[count] + arr[j+2][a];
                System.out.print(a);
                a++; 
            }
            a = a - i + 1;
            s[count] = s[count] + arr[j+1][a];
            if(a == (arr[0].length/2)+1){
                a = 0;
            }
            count++;
            if(count%((arr.length/2)+1) == 0){
                j++;
            }
            p--;
        }
        sum = s[0];
        for(int i = 1; i < (m-2) * (n-2); i++){
            if(s[i] > sum){
                sum = s[i];
            }
        }
        return sum;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
