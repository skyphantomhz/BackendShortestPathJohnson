package com.findpath.model;


import com.findpath.dao.*;

public class JohnsonAlgorithmMODEL {
	private int adjacencymatrix[][];
	private int numberofvertices;
	private int distancematrix[][];
	private int SOURCE_NODE;
    private int numberOfNodes;
    private int augmentedMatrix[][];
    private int potential[];
    private BellmanFord bellmanFord;
    private DijkstraShortesPath dijsktraShortesPath;
    private int[][] allPairShortestPath;
    
    public JohnsonAlgorithmMODEL() {
	}
    
    public void initJohnsonsAlgorithm(){
    	numberOfNodes=numberofvertices;
        augmentedMatrix = new int[numberOfNodes + 2][numberOfNodes + 2];
        SOURCE_NODE = numberOfNodes + 1;
        potential = new int[numberOfNodes + 2];
        bellmanFord = new BellmanFord(numberOfNodes + 1);
        dijsktraShortesPath = new DijkstraShortesPath(numberOfNodes);
        allPairShortestPath = new int[numberOfNodes + 1][numberOfNodes + 1];
    }

	public void initAdjacencyMatrix() {
		for (int source = 0; source < numberofvertices; source++) {
			for (int destination = 0; destination < numberofvertices; destination++) {
				if (source == destination) {
					adjacencymatrix[source][destination] = 0;
					continue;
				}
				if (adjacencymatrix[source][destination] == 0) {
					adjacencymatrix[source][destination] = JohnsonsAlgorithm.MAX_VALUE;
				}
			}
		}
	}
	public int[][] getAdjacencymatrix() {
		return adjacencymatrix;
	}
	public void setAdjacencymatrix(int[][] adjacencymatrix) {
		this.adjacencymatrix = adjacencymatrix;
	}
	public int getNumberofvertices() {
		return numberofvertices;
	}
	public void setNumberofvertices(int numberofvertices) {
		this.numberofvertices = numberofvertices;
	}
	public int[][] getDistancematrix() {
		return distancematrix;
	}
	public void setDistancematrix(int[][] distancematrix) {
		this.distancematrix = distancematrix;
	}
	public int getSOURCE_NODE() {
		return SOURCE_NODE;
	}
	public void setSOURCE_NODE(int sOURCE_NODE) {
		SOURCE_NODE = sOURCE_NODE;
	}
	public int getNumberOfNodes() {
		return numberOfNodes;
	}
	public void setNumberOfNodes(int numberOfNodes) {
		this.numberOfNodes = numberOfNodes;
	}
	public int[][] getAugmentedMatrix() {
		return augmentedMatrix;
	}
	public void setAugmentedMatrix(int[][] augmentedMatrix) {
		this.augmentedMatrix = augmentedMatrix;
	}
	public int[] getPotential() {
		return potential;
	}
	public void setPotential(int[] potential) {
		this.potential = potential;
	}
	public BellmanFord getBellmanFord() {
		return bellmanFord;
	}
	public void setBellmanFord(BellmanFord bellmanFord) {
		this.bellmanFord = bellmanFord;
	}
	public DijkstraShortesPath getDijsktraShortesPath() {
		return dijsktraShortesPath;
	}
	public void setDijsktraShortesPath(DijkstraShortesPath dijsktraShortesPath) {
		this.dijsktraShortesPath = dijsktraShortesPath;
	}
	public int[][] getAllPairShortestPath() {
		return allPairShortestPath;
	}
	public void setAllPairShortestPath(int[][] allPairShortestPath) {
		this.allPairShortestPath = allPairShortestPath;
	}
    
}
