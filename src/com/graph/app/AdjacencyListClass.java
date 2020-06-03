package com.graph.app;

import java.util.ArrayList;

public class AdjacencyListClass {
	public static int vertexCount;

	public AdjacencyListClass(int vertexCount) {
		AdjacencyListClass.vertexCount = vertexCount;
	}

	public static void printGraph(ArrayList<ArrayList<Integer>> adjList) {
		for (int i = 0; i < adjList.size(); i++) {
			System.out.print(i + " -> ");
			for (int j = 0; j < adjList.get(i).size(); j++) {
				System.out.print(adjList.get(i).get(j) + " -> ");
			}
			System.out.println("null");
		}
	}

	public static void addNodes(ArrayList<ArrayList<Integer>> adjList, int vertex1, int vertex2, boolean isDirected) {
		if (isDirected) {
			adjList.get(vertex1).add(vertex2);
		} else {
			adjList.get(vertex1).add(vertex2);
			adjList.get(vertex2).add(vertex1);
		}
	}

	public static void main(String[] args) {

		vertexCount = 5;
		boolean isDirected = false;
		new AdjacencyListClass(vertexCount);
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(vertexCount);

		for (int i = 0; i < vertexCount; i++) {
			adjList.add(new ArrayList<Integer>());
		}

		addNodes(adjList, 0, 1, isDirected);
		addNodes(adjList, 0, 2, isDirected);
		addNodes(adjList, 1, 3, isDirected);
		addNodes(adjList, 2, 3, isDirected);
		//addNodes(adjList, 1, 4, isDirected);
		addNodes(adjList, 3, 4, isDirected);

		printGraph(adjList);
		
		new BFSUtil(vertexCount);
		BFSUtil.BFSGraph(adjList, 0);
		
		System.out.println();
		new DFSUtil(vertexCount);
		DFSUtil.DFSGraph(adjList, 0);
	}

}
