package com.practice.ds.graphs;

import java.util.ArrayList;

public class DFSUsingRecursion {

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfsPath = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfs(0, visited, adj, dfsPath);
        return dfsPath;
    }

    public void dfs(int vertexIndex, boolean[] visited, ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> dfsPath) {
        visited[vertexIndex] = true;
        dfsPath.add(vertexIndex);
        ArrayList<Integer> neighbors = adjList.get(vertexIndex);

        for (int neighborIndex : neighbors) {
            if (!visited[neighborIndex]) {
                dfs(neighborIndex, visited, adjList, dfsPath);
            }
        }
    }
}
