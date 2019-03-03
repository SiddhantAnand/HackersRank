import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the alternate function below.
    static int alternate(String s) {
        int max = 0;                                              //to keep the record for max value
        int len = s.length();
        int i = 0,temp = 0;     //temp is for keep the track of ith variable so that the iteration begins from the position of the replaced variable
        while(len != 0){
            int j = i+1;
            char ic = s.charAt(i); //character at the ith index
            while(j < len){
                char jc = s.charAt(j);     //character at the jth index
                int count = 0;    //it counts the local length of two characters
                if(ic != jc){
                    temp = i;
                    int k = i;
                    int cp = 1;
                    while(k < len){
                        if(s.charAt(k) == ic && cp == 1){
                            count++;
                            cp = 0;
                        }
                        else if(s.charAt(k) == jc && cp == 0){
                            count++;
                            cp = 1;
                        }
                        else if((s.charAt(k) == ic && cp == 0)||(s.charAt(k) == jc && cp == 1)){
                            count = 0;
                            break;
                        }
                        k++;
                    }
                    if(count > max){
                        max = count;
                    }
                }
                j++;
            }   
            s = s.replace(Character.toString(ic),"");
            len = s.length();
            i = temp;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
