import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        int n = matrix.size();
        int m = (matrix.get(0)).size();
        int x = 0,temp = 0,temp1 = n,temp2 = m,temp3 = n,temp4 = m,min = 0,s = 0,q = r;
        if(n>m){
            min = m;
            temp = m;
        }
        else{
            min = n;
            temp = n;
        }
        if(min%2==0){
            while (min != temp / 2) {
                s = (2 * temp1 - 2) + (2 * temp2 - 2);
                if(s==0){
                    s=1;
                }
                q = r % s;
                if (q == 0) {
                    q = s;
                }
                int a = (int) (matrix.get(x)).get(x);
                int f = q;
                while(f!=0){
                    a = (int) (matrix.get(x)).get(x);
                    for (int i = x; i < n - 1; i++) {
                        int b = (int) (matrix.get(i + 1)).get(x);
                        (matrix.get(i + 1)).set(x, a);
                        a = b;
                    }
                    for (int i = x; i < m - 1; i++) {
                        int b = (int) (matrix.get(n - 1)).get(i + 1);
                        (matrix.get(n - 1)).set(i + 1, a);
                        a = b;
                    }
                    for (int i = n - 1; i > x; i--) {
                        int b = (int) (matrix.get(i - 1)).get(m - 1);
                        (matrix.get(i - 1)).set(m - 1, a);
                        a = b;
                    }
                    for (int i = m - 1; i > x; i--) {
                        int b = (int) (matrix.get(x)).get(i - 1);
                        (matrix.get(x)).set(i - 1, a);
                        a = b;
                    }
                    f--;
                }

                x++;
                n--;
                m--;
                min--;
                temp1 = temp1 - 2;
                temp2 = temp2 - 2;
            }
            for (int i = 0; i < temp3; i++) {
                for (int j = 0; j < temp4; j++) {
                    int a = (int) (matrix.get(i)).get(j);
                    System.out.print(a + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
