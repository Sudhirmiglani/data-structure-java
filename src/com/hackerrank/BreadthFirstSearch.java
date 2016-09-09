package com.hackerrank;

import java.util.*;

/**
 * Created by sudhirmiglani on 22/07/16.
 */
public class BreadthFirstSearch {

    private static int V;

    private static LinkedList<Integer> adj[]; //Adjacency Lists

    private static void setData(int numOfVertices) {
        V = numOfVertices;

        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList();
        }

    }

    private static void addEdge(int start, int end) {
        adj[start - 1].add(end - 1);
    }

    private static int bfs(int start, int end) {

        boolean visited[] = new boolean[V];

        Queue<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[start] = true;
        queue.add(start);

        int distance = 0;
        int currentLevel = 1;
        int nextLevel = 0;
        int s;
        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            currentLevel--;

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    if (n == end) {
                        return distance + 1;
                    }
                    queue.add(n);
                    nextLevel++;
                }
            }


            if(currentLevel == 0){
                currentLevel = nextLevel;
                nextLevel = 0;
                distance++;
            }
        }

        return -1;
    }

    private static void printDistance(int start) {

        start--;
        for (int i = 0; i < adj.length; i++) {
            if (i != start) {
                int distance = bfs(start, i);
                distance = distance > -1 ? distance * 6 : distance;
                System.out.print(distance + " ");
            }
        }

    }

    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int N = 0, M = 0;
        for (int j = 0; j < t; j++) {
            N = sc.nextInt();
            M = sc.nextInt();

            setData(N);
            for (int i = 0; i < M; i++) {
                addEdge(sc.nextInt(), sc.nextInt());
            }

            printDistance(sc.nextInt());
            System.out.println();
        }


    }
}
