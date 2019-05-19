package com.coding.practice.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String N = br.readLine();

            int out_ = solve(N);
            System.out.println(out_);
            System.out.println("");
         }

         wr.close();
         br.close();
    }
    
    static int solve(String N){
        Map<Integer, Integer> freqMap = new HashMap<>();
        // finding all the freq.
        for(int i = 0; i < N.length(); i++) {
            if(freqMap.containsKey(Character.getNumericValue(N.charAt(i)))) {
                int freq = freqMap.get(Character.getNumericValue(N.charAt(i)));
                freq = freq + 1;
                freqMap.put(Character.getNumericValue(N.charAt(i)), freq);
            } else {
                freqMap.put(Character.getNumericValue(N.charAt(i)), 1);
            }
        }
        
        //sorting the map accoridng to the keys.
        //Collections.sort(freqMap);
        Map<Integer, Integer> treeMap = new TreeMap<>(freqMap);
        int count = 0;
        Set<Integer> processed = new HashSet<>();
        
        Set<Map.Entry<Integer, Integer>> entrySet = treeMap.entrySet();
        for(Map.Entry<Integer, Integer> entry : entrySet) {
            int key = entry.getKey();
            System.out.println("key: "+ key);
            int greaterKey = ++key;
            if(freqMap.containsKey(greaterKey) && !processed.contains(greaterKey - 1) && !processed.contains(greaterKey)) {
                
                processed.add(key - 1);
                processed.add(greaterKey);
                int value = entry.getValue();
                int greaterValue = freqMap.get(greaterKey);
                
                System.out.println("value: "+ value);
                System.out.println("key + 1 : "+ greaterKey);
                System.out.println("greaterValue: "+ greaterValue);
                
                if(greaterValue == value && value == 2) {
                	count += 1;
                } else {
                    // choose 2 out of the present numbers for both add to the count.
                	long comb1 = findCombinations(value, 2);
                	if(comb1 > 1) {
                		count += comb1;
                	}
                	
                	long comb2 = findCombinations(greaterValue, 2);
                	if(comb2 > 1) {
                		count += comb2;
                	}
                }
                System.out.println("asdf");
                
            }
        }
        
        return count;
    
    }
    
    
    public static long findCombinations(int obj, int samples) {
    	long one = fact(obj);
    	long two = fact(samples);
    	long three = fact(obj - samples);
    	
    	long value = one/(two*three);
    	return value;
    }
    
    public static long fact(int n) {
    	if(n == 0) {
    		return 1;
    	}
    	return n * fact(n-1);
    }
}
