/**
 * Shortest Path in
 * Unweighted Graph
 */
package com.graph.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInGraph {

	private int vertexCount;
	private static boolean[] isVisited;
	private static int[] distance;

	public ShortestPathInGraph(int vertexCount) {
		this.vertexCount = vertexCount;
		isVisited = new boolean[vertexCount];
		distance = new int[vertexCount];
	}

	private static void addNodes(ArrayList<ArrayList<Integer>> adjList, int vertex1, int vertex2) {
		adjList.get(vertex1).add(vertex2);
		adjList.get(vertex2).add(vertex1);
	}

	private static void BFS(ArrayList<ArrayList<Integer>> adjList, int sourceVertex) {
		isVisited[sourceVertex] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(sourceVertex);
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			ArrayList<Integer> adjValue = adjList.get(temp);
			for (int i = 0; i < adjValue.size(); i++) {
				if (!isVisited[adjValue.get(i)]) {
					isVisited[adjValue.get(i)] = true;
					distance[adjValue.get(i)] = distance[temp] + 1;
					queue.add(adjValue.get(i));
				}
			}
		}
	}

	public static void main(String[] args) {
		ShortestPathInGraph shortestPath = new ShortestPathInGraph(4);
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(shortestPath.vertexCount);

		for (int i = 0; i < shortestPath.vertexCount; i++) {
			adjList.add(new ArrayList<Integer>());
		}

		addNodes(adjList, 0, 1);
		addNodes(adjList, 0, 2);
		addNodes(adjList, 1, 2);
		addNodes(adjList, 1, 3);
		addNodes(adjList, 2, 3);

		int sourceVertex = 0;
		BFS(adjList, sourceVertex);
		for (int i = 0; i < shortestPath.vertexCount; i++) {
			if (i != sourceVertex && !isVisited[i]) {
				BFS(adjList, i);
			}
		}

		for (int i = 0; i < distance.length; i++) {
			System.out.print(distance[i] + " ");
		}

	}

}
