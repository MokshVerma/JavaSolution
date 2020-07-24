package AmazonGFG.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindMedianInStream {

    static class FindMedian{
        static PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        static PriorityQueue<Integer> min = new PriorityQueue<>();
        static double median = 0;
        // Function to insert heap
        public static void insertHeap(int x){
            if(x>median){
                min.add(x);
            } else{
                max.add(x);
            }
            balanceHeaps();
        }

        // Function to balance Heaps
        public static void WRONGbalanceHeaps(){
            if(min.size()==max.size())
                return;
            else if(!min.isEmpty() && min.peek()<=median) {
                while (!min.isEmpty() && min.peek() <= median) {
                    max.add(min.remove());
                }
            } else{
                while(!max.isEmpty() && max.peek()>=median){
                    min.add(max.remove());
                }
            }
        }

        public static void balanceHeaps(){
            if(max.size()>min.size()){
                if(max.peek()>median){
                    min.add(max.remove());
                }
            } else if(max.size()<min.size()){
                if(min.peek()<median){
                    max.add(min.remove());
                }
            }
        }

        // function to getMedian
        public static double getMedian(){

            if(max.size()>min.size()){
                median = max.peek();
            } else if(max.size()<min.size())
                median = min.peek();
            else {
                median = (min.peek()+max.peek())/2.0;
            }
            return median;
        }

    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        FindMedian Ans = new FindMedian();
        for(int i = 1; i <= n; i++)
        {
            int x =sc.nextInt();
            Ans.insertHeap(x);
            System.out.println((int)Math.floor(Ans.getMedian()));
        }

    }

}
