package com.practice.ds.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    private static class Graph {

        private int MAX_VERTICES = 20;
        private Vertex[] vertexList;
        private int adjMat[][];
        private int nVertex;

        public Graph() {
            vertexList = new Vertex[MAX_VERTICES];
            adjMat = new int[MAX_VERTICES][MAX_VERTICES];
            nVertex = 0;
        }

        public void addVertex(char label) {
            vertexList[nVertex++] = new Vertex(label);
        }

        public void addEdge(int start, int end) {
            adjMat[start][end] = 1;
            adjMat[end][start] = 1;
        }

        public void displayVertex(int v) {
            System.out.print(vertexList[v].label + " ");
        }

        public void bfs() {
            Queue<Integer> theQueue = new LinkedList<>();
            theQueue.offer(0);
            vertexList[0].wasVisited = true;
            displayVertex(0);

            int v2;
            while (!theQueue.isEmpty()) {
                int v1 = theQueue.remove();
                while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                    vertexList[v2].wasVisited = true;
                    displayVertex(v2);
                    theQueue.offer(v2);
                }
            }

            for (int i = 0; i < nVertex; i++) {
                vertexList[i].wasVisited = false;
            }
        }

        private int getAdjUnvisitedVertex(int v) {
            for (int i = 0; i < nVertex; i++) {
                if (adjMat[v][i] == 1 && !vertexList[i].wasVisited) {
                    return i;
                }
            }
            return -1;
        }
    }

    private static class Vertex {
        public char label;
        public boolean wasVisited = false;

        public Vertex(char lab) {
            this.label = lab;
            wasVisited = false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        System.out.println("Visits: ");
        graph.bfs();
    }
}
