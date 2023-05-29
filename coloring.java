package Ai_main;

import java.util.*;

public class coloring {
    private static int [][]graph;
    private static int []colors;
    private static int numVertices;
    private static int numColors;
    private static int [] bestSolutions;

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of vertices");
        numVertices =sc.nextInt();

        graph = new int [numVertices][numVertices];
        System.out.println("enter adjacency matrix");
        for(int i=0;i<numVertices;i++){
            for(int j=0;j<numVertices;j++){
                graph[i][j]=sc.nextInt();
            }
        }

        System.out.println("enter no of colors:");
        numColors =sc.nextInt();

        colors = new int[numColors];
        Arrays.fill(colors,-1);

        bestSolutions = new int[numVertices];
        Arrays.fill(bestSolutions,-1);
        graphColoring(0);
        System.out.println("best solution");
        for(int i=0;i<numVertices;i++){
            System.out.println("vertices"+i+"colors"+bestSolutions[i]);
        }

    }
    public static void graphColoring(int vertex){
        if(vertex == numVertices){
            if(isValidSolution()){
                bestSolutions = Arrays.copyOf(colors,numVertices);
            }
            return;
        }

        for(int color =0;color<numColors;color++){
            colors[vertex]=color;
            if(isValidPartialSolution(vertex)){
                graphColoring(vertex+1);
            }
            colors[vertex]=-1;
        }
    }
    private static boolean isValidPartialSolution(int vertex){
        for(int i=0;i<numVertices;i++){
            if(graph[vertex][i]==1 && colors[vertex]==colors[i]){
                return false;
            }
        }
        return true;
    }

    private static boolean isValidSolution(){
        for(int i=0;i<numVertices;i++){
            for(int j=0;j<numVertices;j++){
                if(graph[i][j]==1 && colors[i]==colors[j]){
                    return false;
                }
            }
        }
        return true;
    }
}
