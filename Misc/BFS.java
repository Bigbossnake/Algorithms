import java.io.*;
import java.util.*;

public class Solution {
    
    private static String SPACE = " ";
    private static String closestNode = "";
    private static Integer minimunSteps = -1;
    private static Hashtable<String, Boolean> visitedNodes = new Hashtable<String, Boolean>();
    
    public static int BFS_FIRST(Hashtable<String, String> graph, 
                              Hashtable<String, Boolean> visitedNodes,
                              String initialNode,
                              String targetNode) {
        
        Queue<String> pendingNodes = new LinkedList<>();
        
        visitedNodes.put(initialNode, true);
        pendingNodes.add(initialNode);
        
        int numberOfSteps = 0;

        while (!pendingNodes.isEmpty()) {
            
            numberOfSteps ++;
            String currentNode = pendingNodes.poll();
            
            if (currentNode.equalsIgnoreCase(targetNode)) {
                break;
            }
            
            String neighborsInfo = graph.get(currentNode);
            String[] neighbors   = neighborsInfo.split(SPACE);
                
            Arrays.stream(neighbors).forEach(neighbor -> {
                
                if (!visitedNodes.containsKey(neighbor)) {
                    visitedNodes.put(neighbor, true);
                    pendingNodes.add(neighbor);
                   }
            });
        }
        
        return numberOfSteps;
    }

    public static void main(String[] args) {
        
        String graphDetails;
        String problemInfo;
        
        Scanner input = new Scanner(System.in);
        graphDetails  = input.nextLine();
        problemInfo   = input.nextLine();
        
        String[] graphInfo = graphDetails.split(SPACE);
        
        int numberOfNodes      = Integer.parseInt(graphInfo[0]);
        int numberOfEdges      = Integer.parseInt(graphInfo[1]);
        int numberOfObjectives = Integer.parseInt(graphInfo[2]);
    
        String nodeInfo;
        String[] nodeDetails;
        String node;
        String neighbor;
        String neighbors;
        
        Hashtable<String, String> graph         = new Hashtable<String, String>();
        Hashtable<String, Integer> objectives   = new Hashtable<String, Integer>();
        
        for (int i = 0; i < numberOfEdges; i++) {
            
            nodeInfo    = input.nextLine();
            nodeDetails = nodeInfo.split(SPACE);
            
            node     = nodeDetails[0];
            neighbor = nodeDetails[1];
            
            if (!graph.containsKey(node)) {
                graph.put(node, neighbor);
            } 
            
            else {
                neighbors = graph.get(node);
                neighbors = neighbors + SPACE + neighbor;
                graph.replace(node, neighbors); 
            }
            
            if (!graph.containsKey(neighbor)) {
                graph.put(neighbor, node);
            }
            
            else {
                  neighbors = graph.get(neighbor);
                  neighbors = neighbors + SPACE + node;
                  graph.replace(neighbor, neighbors); 
            }
                 
        }
        
        String[] problemDetails = problemInfo.split(SPACE);
        String initialNode      = problemDetails[0];
        
        for (int j = 1; j <= numberOfObjectives; j++) {
            objectives.put(problemDetails[j], 1);
        }
        
        objectives.forEach((targetNode, value) -> {
            
            int numberOfSteps = BFS_FIRST(graph, visitedNodes, initialNode, targetNode);
            visitedNodes      = new Hashtable<String, Boolean>();
            
            if (minimunSteps < 0) {
                minimunSteps = numberOfSteps;
                closestNode = targetNode;
                
            } else if (numberOfSteps < minimunSteps && numberOfSteps != -1) {
                minimunSteps = numberOfSteps;
                closestNode = targetNode;
            }
        });
        
        System.out.println(closestNode);
    }
}