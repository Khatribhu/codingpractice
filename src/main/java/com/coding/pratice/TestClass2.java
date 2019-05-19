package com.coding.pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class TestClass2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String[] inp = br.readLine().split(" ");
            int r1 = Integer.parseInt(inp[0]);
            int r2 = Integer.parseInt(inp[1]);
            int N = Integer.parseInt(br.readLine().trim());
            String S = br.readLine();
            solve(r1, r2, N, S);
        }
        wr.close();
        br.close();
    }
    static void solve(int r1, int r2, int N, String S){
        // Solve the problem and print answer here 
        Double coEff = (double) ((double)r1 / (double)r2);
        int count = 0;
        
        for(int i= 0; i< S.length(); ) {
            if(S.charAt(i) == '*') {
                System.out.println("No way!");
                return;
            }
            
            // find all prime till index i+1 as index starting from 0.
            int A = findPrimeTillN(i+1);

            if((i+A) <= (S.length() -1) && A > 2 && (((double)A/(double)i) >= coEff) && S.charAt(i+A) != '*' ) {
                i += A;
                count++;
            }else if((i+2) <= (S.length() -1)  && S.charAt(i+2) != '*') {
                i += 2;
                count++;
            } else if((i+1) <= (S.length() -1) && S.charAt(i+1) != '*'){
                i++;
                count++;
            } else if(i <= S.length() -1 && S.charAt(i) == '*'){
                System.out.println("No way!");
                return;
            } else {
            	i++;
            }
            
        }
        System.out.println(count);
        return;
    }
    
    static int findPrimeTillN(int n) {
        int count = 0;
        for(int i = 2; i <= n; i++) {
            if(isPrime(i)) {
                count++;
            }
        }
        return count;
    }
    
    static boolean isPrime(int n) {
        if(n <= 1) {
            return false;
        }
        
        if(n <= 3) {
            return true;
        }
        
        if(n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        
        for(int i=5; i*i <= n; i += 6) {
            if(n % i == 0 || n % (i+2) == 0) {
                return false;
            }
        }
        return true;
    }
}