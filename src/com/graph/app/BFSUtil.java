package com.graph.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSUtil {
	private static int vertexCount;
	private static boolean[] isVisited;

	public BFSUtil(int vertexCount) {
		BFSUtil.vertexCount = vertexCount;
		isVisited = new boolean[vertexCount];
	}

	private static void BFS(ArrayList<ArrayList<Integer>> adjList, int sourceVertex) {
		isVisited[sourceVertex] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(sourceVertex);
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			System.out.print(temp + " ");
			ArrayList<Integer> listOfValue = adjList.get(temp);
			for (int i = 0; i < listOfValue.size(); i++) {
				if (!isVisited[listOfValue.get(i)]) {
					isVisited[listOfValue.get(i)] = true;
					queue.add(listOfValue.get(i));
				}
			}
		}
	}

	public static void BFSGraph(ArrayList<ArrayList<Integer>> adjList, int sourceVertex) {
		BFS(adjList, sourceVertex);
		for (int i = 0; i < vertexCount; i++) {
			if (i != sourceVertex && !isVisited[i]) {
				BFS(adjList, i);
			}
		}
	}

}
