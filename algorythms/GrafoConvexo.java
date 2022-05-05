import java.io.*;
import java.util.*;

public class Solution {
    
    private static String SPACE   = " ";
    private static String isConex = "T";
    
    private static Hashtable<Character, Boolean> nodesToVisit = new Hashtable<Character, Boolean>();
    private static List<String> answers = new ArrayList<String>();
    
    public static long marksNodePending(String visitedNodes) {
        
        for (int i = 0; i < visitedNodes.length(); i++) {
            
            char node = visitedNodes.charAt(i);
            nodesToVisit.put(node, true);
            
        }
        
        return nodesToVisit.entrySet().stream().filter( map -> map.getValue() == true).count();
        
    }
    
    public static boolean isIsolated(Hashtable<String, String> graph, String initialNode) {
                
       if (!graph.containsKey(initialNode)) {
            return true;
        }
        
        return false;
    }
    
    public static String[] BFS(Hashtable<String, String> graph, String initialNode) {
                
        Hashtable<String, Boolean> visitedNodes = new Hashtable<String, Boolean>();
        Queue<String> pendingNodes = new LinkedList<>();
        
        visitedNodes.put(initialNode, true);
        pendingNodes.add(initialNode);
        
        List<String> graphInfo = new ArrayList();
        
        while (!pendingNodes.isEmpty()) {
        
            String currentNode = pendingNodes.poll();
            
            graphInfo.add(currentNode);
            
            String neighborsInfo = graph.get(currentNode);
            String[] neighbors   = neighborsInfo.split(SPACE);
                
            Arrays.stream(neighbors).forEach(neighbor -> {
                
                if (!visitedNodes.containsKey(neighbor)) {
                    visitedNodes.put(neighbor, true);
                    pendingNodes.add(neighbor);
                   }
            });
                
        }
        
        return graphInfo.toArray(new String[graphInfo.size()]);
    }
        
    public static void main(String[] args) {
        
        String problemStatement;
        
        Scanner input    = new Scanner(System.in);
        problemStatement = input.nextLine();
        
        String[] problemInfo = problemStatement.split(SPACE);
        int numberOfNodes = Integer.parseInt(problemInfo[0]);
        int numberOfEdges = Integer.parseInt(problemInfo[1]);
        
        Hashtable<String, String> graph = new Hashtable<String, String>();
        
        String neighbors;
        String[] possibleNodes = { "A", "B", "C", "D", "F", "G", 
                                   "H", "I", "J", "K", "L", "M", 
                                   "N", "O", "P", "Q", "R", "S", 
                                   "T", "U", "V", "W", "X", "Y", "Z"};

        
        String initialNode = null;
        String topNode     = "A";
        String greaterNode;
        
        for (int i = 0; i < numberOfEdges; i++) {
            
            String nodeInfo      = input.nextLine();
            String[] nodeDetails = nodeInfo.split(SPACE);
            
            String node     = nodeDetails[0];
            String neighbor = nodeDetails[1];
            
            if (node.compareTo(neighbor) > 0) {
                greaterNode = node;
            } 
            
            else {
                greaterNode = neighbor;
            }
            
            if (topNode.compareTo(greaterNode) < 0) {
                topNode = greaterNode;
            }
            
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
        
        List<Character> nodesToVisitList = new ArrayList<Character>();
        
        for (int i = 'A'; i <= topNode.charAt(0); i++) {
            char nodeToVisit = (char)i;
            
            nodesToVisitList.add(nodeToVisit);
            nodesToVisit.put(nodeToVisit, false);
        }
        
        int pendingNodesToVisit = nodesToVisitList.size();
                
        nodesToVisitList.forEach(initialNodeToVisit -> {
            
            // System.out.println(initialNodeToVisit);
            
            if (isIsolated(graph, Character.toString(initialNodeToVisit)) && 
                !nodesToVisit.get(initialNodeToVisit)) {
                
                marksNodePending(Character.toString(initialNodeToVisit));
                isConex = "F";
                
                answers.add(Character.toString(initialNodeToVisit) + "\n");
            }
            
            else {
                
                if (!nodesToVisit.get(initialNodeToVisit)) {
                    String[] nodesVisited = BFS(graph, Character.toString(initialNodeToVisit));
                    Arrays.sort(nodesVisited); 
                    
                    String answer = "";
                    for (int i = 0; i < nodesVisited.length; i++) {
                        marksNodePending(nodesVisited[i]);
                        answer += nodesVisited[i];
                    }
                    
                    answers.add(answer  + "\n");
                }
            }            
        });
        
        System.out.println(isConex);
        answers.forEach(a -> System.out.print(a));
    }
}