package com.hackerrank;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sudhirmiglani on 30/06/16.
 */
public class CountOfSequenceWithSumN {

    public static void main(String[] args) {
        CountOfSequenceWithSumN sol = new CountOfSequenceWithSumN();
        int n = 3,sum = 4;
        System.out.println(sol.countOfSequences(String.valueOf(sum),String.valueOf(n)));
    }


    //D.P Way
//    public BigInteger countOfSequencesDPWay(int n, int sum) {
//        if(sum < 1) {
//            return BigInteger.ZERO;
//        }
//        Map<Integer,BigInteger> countMap = new HashMap<>();
//        if(n > 0) {
//            countMap.put(1, BigInteger.ONE);
//        }
//        return countSequences(n,sum,countMap);
//    }

//    public BigInteger countSequences(int n,int sum,Map<Integer,BigInteger> countMap) {
//
//        if(countMap.containsKey(sum)) {
//            return countMap.get(sum);
//        }
//        else {
//            BigInteger count = BigInteger.ZERO;
//
//            for(int index = sum - 1;index > 0;index--) {
//
//                int diff = sum - index;
//
//                if(diff <= n) {
//                    BigInteger result = countSequences(n, index, countMap);
//                    System.out.println("index = " + index);
//                    System.out.println(result);
//                    count = count.add(result);
//                }
//
//                if(index > 1 && diff <= n && index <= n) {
//                    count = count.add(BigInteger.ONE);
//                }
//            }
//            countMap.put(sum,count);
//            return count;
//        }
//    }


    //Required only for test
    String countOfSequences(String N, String A) {
        int sum = Integer.parseInt(N);
        int n = Integer.parseInt(A);
        if (n < 1 || sum < 1) {
            //Edge case
            return String.valueOf(0);
        }

        int[] numbersDigitsSum = new int[9];
        for(int i=1; i <= n; i++) {
            int number = i,digitSum = 0;
            while (number > 0) {
                digitSum += number % 10;
                number /= 10;

                if(digitSum >= 10) {
                    digitSum = digitSum == 10 ? 1 : (1 + (digitSum % 10));
                }
            }
            numbersDigitsSum[digitSum - 1]++;
        }
        Map<Integer,BigInteger> lookup = new HashMap<>();
        return String.valueOf(countNumberOfSequences(numbersDigitsSum,sum,lookup));
    }

    /*
     *     sum = 3, n = 3
     *     Sum(3) = Sum(1) * ( ((sum 1) * sum(1)) + sum(2)) + Sum(2) * (Sum 1) + Sum(3)
     *
     */
    private BigInteger countNumberOfSequences(int[] numbersDigitsSum, int sum,Map<Integer,BigInteger> lookup) {
        BigInteger count = BigInteger.ZERO;
        int remainingSum;
        for(int i = 1; i <= 9;i++) {
            remainingSum = sum -i;
            if( remainingSum > 0) {
                if(lookup.containsKey(remainingSum)) {
                    count =  count.add(lookup.get(remainingSum).multiply(new BigInteger(String.valueOf(numbersDigitsSum[i - 1]))));
                }
                else {
                    count =  count.add(countNumberOfSequences(numbersDigitsSum, remainingSum, lookup).multiply(new BigInteger(String.valueOf(numbersDigitsSum[i - 1]))));
                }
            }
            else if(remainingSum == 0) {
                count = count.add(new BigInteger(String.valueOf(numbersDigitsSum[i -1])));
            }
            else  {
                // remaining sum is not greater than zero, so no point iterating further
                break;
            }

        }
        lookup.put(sum,count);
        return count;
    }
}