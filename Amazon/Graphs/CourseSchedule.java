package AmazonGFG.Graphs;

import java.util.*;

public class CourseSchedule {

//    There are a total of N tasks, labeled from 0 to N-1. Some tasks may have prerequisites, for example
//    to do task 0 you have to first complete task 1, which is expressed as a pair: [0, 1]

    public boolean canFinish(int numTasks, int[][] prerequisites){
        Set<Integer> white = new HashSet<>();
        Set<Integer> grey = new HashSet<>();
        Set<Integer> black = new HashSet<>();

        for(int i=0; i<numTasks; i++){
            white.add(i);
        }

        while(!white.isEmpty()){
            for(int i: white){
                if(dfs(i, prerequisites, white, grey, black))
                    return false;
            }
        }
        return true;
    }

    public boolean dfs(int i, int[][] mat, Set<Integer> white, Set<Integer> grey, Set<Integer> black){
        //move white to grey
        white.remove(i);
        grey.add(i);

        for(int j=0; j<mat[i].length; j++){
            if(mat[i][j]==1){

                if(black.contains(mat[i][j]))
                    continue;
                if(grey.contains(mat[i][j]))
                    return true;
                if(dfs(j, mat, white, grey, black))
                    return true;

            }
        }

        grey.remove(i);
        black.add(i);
        return false;
    }

}
