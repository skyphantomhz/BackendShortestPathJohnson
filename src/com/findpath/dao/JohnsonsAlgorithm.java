package com.findpath.dao;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.findpath.model.*;
public class JohnsonsAlgorithm 
{ 
    public static final int MAX_VALUE = 999;
 
    public void johnsonsAlgorithms(JohnsonAlgorithmMODEL johnsonAlgorithmMODEL)
    {
        computeAugmentedGraph(johnsonAlgorithmMODEL);
        johnsonAlgorithmMODEL.getBellmanFord().BellmanFordEvaluation(johnsonAlgorithmMODEL.getSOURCE_NODE(), johnsonAlgorithmMODEL.getAugmentedMatrix());
        johnsonAlgorithmMODEL.setPotential(johnsonAlgorithmMODEL.getBellmanFord().getDistances());
        int reweightedGraph[][] = reweightGraph(johnsonAlgorithmMODEL);

        for (int source = 0; source < johnsonAlgorithmMODEL.getNumberOfNodes(); source++)
        {
        	johnsonAlgorithmMODEL.getDijsktraShortesPath().dijkstraShortestPath(source, reweightedGraph);
            int[] result = johnsonAlgorithmMODEL.getDijsktraShortesPath().getDistances();
            for (int destination = 0; destination < johnsonAlgorithmMODEL.getNumberOfNodes(); destination++)
            {
            	johnsonAlgorithmMODEL.getAllPairShortestPath()[source][destination] = result[destination] 
                        + johnsonAlgorithmMODEL.getPotential()[destination] - johnsonAlgorithmMODEL.getPotential()[source];
            }
        }
    }
 
    private void computeAugmentedGraph(JohnsonAlgorithmMODEL johnsonAlgorithmMODEL)
    {
        for (int source = 0; source < johnsonAlgorithmMODEL.getNumberOfNodes(); source++)
        {
            for (int destination = 0; destination < johnsonAlgorithmMODEL.getNumberOfNodes(); destination++)
            { 
            	johnsonAlgorithmMODEL.getAugmentedMatrix()[source][destination] = johnsonAlgorithmMODEL.getAdjacencymatrix()[source][destination];
            }
        }
        for (int destination = 0; destination < johnsonAlgorithmMODEL.getNumberOfNodes(); destination++)
        {
        	johnsonAlgorithmMODEL.getAugmentedMatrix()[johnsonAlgorithmMODEL.getSOURCE_NODE()][destination] = 0;
        }
    }
 
    private int[][] reweightGraph(JohnsonAlgorithmMODEL johnsonAlgorithmMODEL)
    {
        int[][] result = new int[johnsonAlgorithmMODEL.getNumberOfNodes() + 1][johnsonAlgorithmMODEL.getNumberOfNodes() + 1];
        for (int source = 0; source < johnsonAlgorithmMODEL.getNumberOfNodes(); source++)
        {
            for (int destination = 0; destination < johnsonAlgorithmMODEL.getNumberOfNodes(); destination++)
            {
                result[source][destination] = johnsonAlgorithmMODEL.getAdjacencymatrix()[source][destination]
                       + johnsonAlgorithmMODEL.getPotential()[source] - johnsonAlgorithmMODEL.getPotential()[destination];
            }
        }
        return result;
    }
 
    
}