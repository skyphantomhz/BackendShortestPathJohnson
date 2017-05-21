package com.findpath.dao;

public class BellmanFord {
	private int distances[];
    private int numberofvertices;
 
    public static final int MAX_VALUE = 999;
 
    public BellmanFord(int numberofvertices)  
    {
        this.numberofvertices = numberofvertices;
        distances = new int[numberofvertices + 1];
    }
 
    public void BellmanFordEvaluation(int source, int adjacencymatrix[][])
    {
        for (int node = 0; node < numberofvertices; node++)
        {
            distances[node] = MAX_VALUE;
        }
 
        distances[source] = 0;
 
        for (int node = 0; node < numberofvertices - 1; node++)
        {
            for (int sourcenode = 0; sourcenode < numberofvertices; sourcenode++)
            {
                for (int destinationnode = 0; destinationnode < numberofvertices; destinationnode++)
                {
                    if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE)
                    {
                        if (distances[destinationnode] > distances[sourcenode] 
                               + adjacencymatrix[sourcenode][destinationnode])
                        {
                            distances[destinationnode] = distances[sourcenode]
                               + adjacencymatrix[sourcenode][destinationnode];
                        }
                    }
                }
            }
        }
 
        for (int sourcenode = 0; sourcenode < numberofvertices; sourcenode++)
        {
            for (int destinationnode = 0; destinationnode < numberofvertices; destinationnode++)
            {
                if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE)
                {
                    if (distances[destinationnode] > distances[sourcenode]
                            + adjacencymatrix[sourcenode][destinationnode])
                        System.out.println("The Graph contains negative egde cycle");
	        }
            }
        }
    }
 
    public int[] getDistances()
    {
        return distances;
    }
}
