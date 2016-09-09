package com.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by sudhirmiglani on 10/07/16.
 */
public class AmazonTest2 {

    private static int V;

    private static int[][] adj;

    private static boolean[] visited;


    private static void setData(int numOfVertices) {
        V = numOfVertices;

        adj = new int[V][V];
        visited = new boolean[V];
    }

    private static void addEdge(int start, int end) {
        adj[start - 1][end - 1] = 1;
        adj[end - 1][start - 1] = 1;
    }

    private static int getNextUnvisited() {
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int getMaxDfs(int start, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        visited[start] = true;
        int max = arr[start];
        int count = 1;
        stack.push(start);

        int element, i;
        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = element;
            while (i < V)
            {
                if (adj[element][i] == 1 && !visited[i])
                {
                    if (arr[i] > max){
                        max = arr[i];
                        count = 1;
                    }else if(arr[i] == max){
                        count ++ ;
                    }
                    stack.push(i);
                    visited[i] = true;
                    element = i;
                    i = 0;
                    continue;
                }
                i++;
            }
            stack.pop();
        }
        return count;

    }

    private static void getNumber(int[] arr) {
        BigInteger prod = BigInteger.ONE;
        while (getNextUnvisited() != -1) {
            int source = getNextUnvisited();
            prod = prod.multiply(BigInteger.valueOf(getMaxDfs(source, arr)));
        }
        prod = prod.mod(BigInteger.valueOf(1000000000 + 7));
        System.out.println(prod);
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String temp[];
        temp = line.split(" ");
        int N = Integer.parseInt(temp[0]);
        setData(N);
        int M = Integer.parseInt(temp[1]);
        line = br.readLine();
        temp = line.split(" ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine();
            temp = line.split(" ");
            addEdge(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }

        getNumber(arr);


    }
}
