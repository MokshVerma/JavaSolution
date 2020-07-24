package AmazonGFG.Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeCharacters {

    /*
    Given a string S with repeated characters (only lowercase). The task is to rearrange characters in a string such
    that no two adjacent characters are same.

    */
    static class Count{
        char c;
        int freq = 0;

        public Count(char c){
            this.c = c;
            this.freq = 1;
        }
    }
    static boolean rearrangeCharacters(String str) {
        // Your code here
        Map<Character, Count> map = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                map.get(c).freq++;
            } else
                map.put(c, new Count(c));
        }
        PriorityQueue<Count> heap = new PriorityQueue<>(new Comparator<Count>() {
            @Override
            public int compare(Count o1, Count o2) {
                return o2.freq-o1.freq;
            }
        });

        for(char c: map.keySet()){
            heap.add(map.get(c));
        }
        Count c1, c2;
        while(heap.size()>1){
           c1 = heap.remove();
           c1.freq--;
           c2 = heap.remove();
           c2.freq--;
           if(c1.freq>0){
               heap.add(c1);
           }
           if(c2.freq>0)
               heap.add(c2);
        }

        if(!heap.isEmpty()){
            return heap.remove().freq <= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(rearrangeCharacters("bbbbbbb"));
    }

}
