package com.graph.app;

import java.util.ArrayList;

public class DetectCycleUndirectedGraph {
	private static int vertexCount;
	private static boolean[] isVisited;

	public DetectCycleUndirectedGraph(int vertexCount) {
		DetectCycleUndirectedGraph.vertexCount = vertexCount;
		isVisited = new boolean[vertexCount];
	}

	private static void addNodes(ArrayList<ArrayList<Integer>> adjList, int vertex1, int vertex2) {
		adjList.get(vertex1).add(vertex2);
		adjList.get(vertex2).add(vertex1);
	}

	private static boolean DFS(ArrayList<ArrayList<Integer>> adjList, int sourceVertex, int parent) {
		isVisited[sourceVertex] = true;
		ArrayList<Integer> adjValue = adjList.get(sourceVertex);
		for (int i = 0; i < adjValue.size(); i++) {
			if (!isVisited[adjValue.get(i)]) {
				if (DFS(adjList, adjValue.get(i), sourceVertex)) {
					return true;
				} else if (adjValue.get(i) != parent) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		DetectCycleUndirectedGraph cycle = new DetectCycleUndirectedGraph(6);
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(vertexCount);
		for (int i = 0; i < vertexCount; i++) {
			adjList.add(new ArrayList<Integer>());
		}

		boolean isCyclePresent = false;
		addNodes(adjList, 0, 1);
		addNodes(adjList, 1, 2);
		addNodes(adjList, 1, 3);
		addNodes(adjList, 3, 2);
		addNodes(adjList, 2, 4);
		addNodes(adjList, 4, 5);

		int sourceVertex = 0;
		isCyclePresent = DFS(adjList, sourceVertex, -1);

		if (!isCyclePresent) {
			for (int i = 0; i < vertexCount; i++) {
				if (i != sourceVertex && !isVisited[i]) {
					if (DFS(adjList, i, -1)) {
						isCyclePresent = true;
						break;
					}
				}
			}
		}

		if (isCyclePresent) {
			System.out.println("Cycle is present");
		} else {
			System.out.println("Cycle is not present");
		}
	}

}
