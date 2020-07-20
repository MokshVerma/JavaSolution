package Amazon.Sorting;
import java.util.*;
public class K_Closest_Point_to_Origin {

    static class Point{
        int x;
        int y;
        int dist;

        public Point(ArrayList<Integer> list, int dist){
            this.x = list.get(0);
            this.y = list.get(1);
            this.dist = dist;
        }
    }

    public static int distance(ArrayList<Integer> list){
        int x = list.get(0);
        int y = list.get(1);

        return (int)Math.sqrt((x*x) + (y*y));
    }

    public static ArrayList<ArrayList<Integer>> kClosest(ArrayList<ArrayList<Integer>> points, int K){
        PriorityQueue<Point> minHeap = new PriorityQueue(new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){
                if(p1.dist>p2.dist)
                    return +1;
                else if(p1.dist==p2.dist)
                    return 0;
                else
                    return -1;
            }
        });

        for(int i=0; i<points.size(); i++){
            minHeap.add(new Point(points.get(i), distance(points.get(i))));
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while(K-->0){
            list.add(new ArrayList());
            Point p = minHeap.remove();
            list.get(list.size()).add(p.x);
            list.get(list.size()).add(p.y);
        }

        return list;
    }
}
