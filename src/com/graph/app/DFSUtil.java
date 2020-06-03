package com.graph.app;

import java.util.ArrayList;

public class DFSUtil {
	private static int vertexCount;
	private static boolean[] isVisited;

	public DFSUtil(int vertexCount) {
		DFSUtil.vertexCount = vertexCount;
		isVisited = new boolean[vertexCount];
	}

	private static void DFSRec(ArrayList<ArrayList<Integer>> adjList, int sourceVertex) {
		isVisited[sourceVertex] = true;
		System.out.print(sourceVertex + " ");
		ArrayList<Integer> listOfValue = adjList.get(sourceVertex);
		for (int i = 0; i < listOfValue.size(); i++) {
			if (!isVisited[listOfValue.get(i)]) {
				DFSRec(adjList, listOfValue.get(i));
			}
		}
	}

	public static void DFSGraph(ArrayList<ArrayList<Integer>> adjList, int sourceVertex) {
		DFSRec(adjList, sourceVertex);
		for (int i = 0; i < vertexCount; i++) {
			if (i != sourceVertex && !isVisited[i]) {
				DFSRec(adjList, i);
			}
		}
	}
}
