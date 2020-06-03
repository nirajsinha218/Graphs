package com.graph.app;

import java.util.ArrayList;

public class DetectCycleDirectedGraph {
	private static int vertexCount;
	private static boolean[] isVisited;
	private static boolean[] inRecStack;

	public DetectCycleDirectedGraph(int vertexCount) {
		DetectCycleDirectedGraph.vertexCount = vertexCount;
		isVisited = new boolean[vertexCount];
		inRecStack = new boolean[vertexCount];
	}

	private static void addNodes(ArrayList<ArrayList<Integer>> adjList, int vertex1, int vertex2) {
		adjList.get(vertex1).add(vertex2);
	}

	private static boolean DFS(ArrayList<ArrayList<Integer>> adjList, int sourceVertex) {
		isVisited[sourceVertex] = true;
		inRecStack[sourceVertex] = true;
		ArrayList<Integer> adjValue = adjList.get(sourceVertex);
		for (int i = 0; i < adjValue.size(); i++) {
			if (!isVisited[adjValue.get(i)] && DFS(adjList, adjValue.get(i))) {
				return true;
			} else if(inRecStack[adjValue.get(i)]) {
				return true;
			}
		}
		inRecStack[sourceVertex] = false;
		return false;
	}

	public static void main(String[] args) {
		boolean isCyclePresent = false;
		DetectCycleDirectedGraph cycle = new DetectCycleDirectedGraph(6);
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < vertexCount; i++) {
			adjList.add(new ArrayList<Integer>());
		}

		addNodes(adjList, 0, 1);
		addNodes(adjList, 2, 1);
		addNodes(adjList, 2, 3);
		addNodes(adjList, 3, 4);
		addNodes(adjList, 4, 5);
		addNodes(adjList, 5, 3);

		int sourceVertex = 0;
		isCyclePresent = DFS(adjList, sourceVertex);

		if (!isCyclePresent) {
			for (int i = 0; i < vertexCount; i++) {
				if (i != sourceVertex && !isVisited[i]) {
					if (DFS(adjList, i)) {
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
