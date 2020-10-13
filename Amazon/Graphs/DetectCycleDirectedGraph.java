package AmazonGFG.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class DetectCycleDirectedGraph {

//    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V){
//        HashSet<Integer> white = new HashSet<>();
//        HashSet<Integer> grey = new HashSet<>();
//        HashSet<Integer> black = new HashSet<>();
//
//        for(int i=0; i<V; i++){
//            white.add(i);
//        }
//
//        while(!white.isEmpty()){
//            if(dfs(0, adj, white, grey, black))
//                return true;
//        }
//        return false;
//    }

//    static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> white, HashSet<Integer> grey, HashSet<Integer> black){
//        white.remove(v);
//        grey.add(v);
//
//        for(int i: adj.get(v)){
//            if(black.contains(i))
//                continue;
//            if(grey.contains(v)){
//                return true;
//            } if(dfs(i, adj, white, grey, black)){
//                return true;
//            }
//        }
//        grey.remove(v);
//        black.add(v);
//        return false;
//    }

    static boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recStack, int v){

        if(recStack[v])
            return true;
        if(visited[v])
            return false;
        visited[v] = true;
        recStack[v] = true;

        for(int i: adj.get(v)){
            if (dfs(adj, visited, recStack, i))
                return true;
        }
        recStack[v] = false;
        return false;
    }


    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V){
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for(int i=0 ;i<V; i++){
            if(dfs(adj, visited, recStack, i))
                return true;
        }
        return false;
    }

}
