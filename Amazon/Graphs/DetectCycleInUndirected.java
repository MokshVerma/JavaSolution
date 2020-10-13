package AmazonGFG.Graphs;

import java.util.ArrayList;

public class DetectCycleInUndirected {

        static boolean dfs(ArrayList<ArrayList<Integer>> g, boolean[] visited, int v, int parent){
            visited[v] = true;

            for(int i:g.get(v)){
                if(!visited[i])
                    if(dfs(g, visited, i, v))
                        return true;
                    else if(i != parent)
                        return true;
            }
            return false;
        }

    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V){
        boolean[] visited = new boolean[V];

        for(int i=0; i<V; i++){
            if(!visited[i] && dfs(g, visited, i, -1)){
                return true;
            }
        }
        return false;
    }

}
