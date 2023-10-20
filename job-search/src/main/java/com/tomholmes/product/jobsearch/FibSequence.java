package com.tomholmes.product.jobsearch;

import java.util.HashMap;
import java.util.Map;

public class FibSequence
{
    static int n1=0,n2=1,n3=0;    
    
    public static void printFibonacci(int count)
    {    
       // 0 1 1 2 3 5 8 13 21 34 = count 10
       if(count>0)
       {    
            n3 = n1 + n2;    
            n1 = n2;    
            n2 = n3;    
            System.out.print(" "+n3);   
            printFibonacci(count-1);    
        }    
    }   
    
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                System.out.println("twoSum: i=" + i +  ", num[i]=" + nums[i] + ", j=" + j + ", num[j]=" + nums[j]);
                if(nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
    
  
    
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        boolean result = false;

        // convert from string, all letters into
        for( int i = 0 ; i < magazine.length()-1 ; i++ ) {
            char letter = magazine.charAt(i);
            System.out.println("i=" + i + ", letter=" + letter);
            int currentCount = magazineMap.getOrDefault(magazineMap, 0);
            magazineMap.put(letter, currentCount);
        }
        System.out.println("map size=" + magazineMap.size());

        for( int i = 0 ; i < magazine.length()-1 ; i++ ) {
             Character ransomeNoteLetter = ransomNote.charAt(i);
             result = magazineMap.containsKey(ransomeNoteLetter) ? true : false;
        }

        return result;
    }
    
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuffer sb = new StringBuffer();

        for( int i = words.length-1; i >= 0 ; i--) {
            System.out.println("i=" + i + ", word=" + words[i]);
            sb.append(  words[i].trim()   );
        }
        return sb.toString();
    }
    
    public static void reverseString(char[] s) {
        for(int i=0; i < s.length / 2 ; i++) {
            System.out.println("i=" + i + ", val=" + s[i] );
            char x = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = x;
            System.out.println(s);
        }
    }
    
    public static void main(String args[]){    
        // int count=10;    
        // System.out.print(n1+" "+n2);//printing 0 and 1    
        // printFibonacci(count-2);//n-2 because 2 numbers are already printed   
           
         //int[] nums = {1,7,15,11};
         //int target = 18;
         //twoSum(nums, target);
        
        // reverseWords("the sky is blue");
     
           char[] s  = {'h', 'e', 'l', 'l', 'o'};
           reverseString(s);
           
       }  
  
}
