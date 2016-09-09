//package com.graph;
//
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * Created by sudhirmiglani on 28/06/16.
// */
//class Graph {
//
//    private Vertex[] vertices;
//    int MAX_VERTICES = 20;
//    int nVertex = 0;
//
//    int[][] adjacencyList;
//
//    Graph() {
//        vertices = new Vertex[MAX_VERTICES];
//        adjacencyList = new int[MAX_VERTICES][MAX_VERTICES];
//    }
//
//    public void addVertex(Vertex vertex) {
//        vertices[nVertex++] = vertex;
//    }
//
//    public void addEdge(int start, int end) {
//        adjacencyList[start][end] = 1;
//        adjacencyList[end][start] = 1;
//    }
//
//}
//
//class Vertex {
//
//    private char label;
//    private List<Vertex> vertices;
//
//    Vertex(char ch) {
//        label = ch;
//        vertices = new LinkedList<>();
//    }
//
//}
//
//public class GraphCode {
//
//    public static void main(String ar[]) {
//        Graph graph = new Graph();
//        graph.addVertex(new Vertex('A'));
//        graph.addVertex(new Vertex('B'));
//        graph.addVertex(new Vertex('C'));
//        graph.addVertex(new Vertex('D'));
//
//
//        // add edges
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(2, 3);
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 2);
//
//        for (int i = 0; i < graph.adjacencyList.length ;i++){
//            for (int j = 0;j < graph.adjacencyList[0].length; j++){
//                System.out.print(graph.adjacencyList[i][j]);
//            }
//            System.out.println();
//        }
//
//
//    }
//
//}
//
