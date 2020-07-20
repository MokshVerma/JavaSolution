package AmazonGFG.Queues;

import java.util.*;

public class GenerateBinaryNumbers {

    static ArrayList<String> generate(long n){
        ArrayList<String> list = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        while(n-->0){
            String s =queue.remove();
            list.add(s);
            queue.add(s+"0");
            queue.add(s+"1");
        }
        return list;
    }

}
