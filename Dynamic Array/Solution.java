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

    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> li = new ArrayList<ArrayList<Integer>>();
        int lastAnswer = 0, m = 0;
        for(int i = 0; i < n; i++){
            li.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < queries.size(); i++){
            if((queries.get(i)).get(0) == 1){
                m = ((queries.get(i)).get(1) ^ lastAnswer) % n;
                li.get(m).add((queries.get(i)).get(2));
            }
            else if((queries.get(i)).get(0) == 2){
                m = ((queries.get(i)).get(1) ^ lastAnswer) % n;
                lastAnswer = (li.get(m)).get(((queries.get(i)).get(2))%((li.get(m)).size()));
                arr.add(lastAnswer);
            }
            else{
                i--;
            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
