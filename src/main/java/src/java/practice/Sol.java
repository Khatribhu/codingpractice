package src.java.practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sol {

    // Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int numberOfGames = 0;
        int indexGame = 0;
        if(s <= p) {
            return 0;
        }

        while(s >= 0) {
           if(indexGame == 0) {
               s -= p;
               numberOfGames++;
           } else if(s >= (p-d) && (p - d) > m){
               s -= (p - d);
               p = (p - d);
               numberOfGames++;
           } else if((p - d) <= m){
               s -= m;
               numberOfGames++;
           } else {
               return numberOfGames;
           }
           indexGame++;
        }
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/service/abc.txt"));

        String[] pdms = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pdms[0]);

        int d = Integer.parseInt(pdms[1]);

        int m = Integer.parseInt(pdms[2]);

        int s = Integer.parseInt(pdms[3]);

        int answer = howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
