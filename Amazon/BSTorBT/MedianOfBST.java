package AmazonGFG.BSTorBT;

import java.util.ArrayList;
import java.util.List;

public class MedianOfBST {

    class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }

        public static void inOrder(List<Integer> list, Node root){
            if(root==null)
                return;
            inOrder(list, root.left);
            list.add(root.data);
            inOrder(list, root.right);
        }

        public static void findMedian(Node root){
            List<Integer> list = new ArrayList<>();
            inOrder(list, root);
            int n = list.size()/2;
            if(list.size()%2==0){
                System.out.println((list.get(n)+list.get(n+1))/2);
            } else
                System.out.println(list.get(n));
        }

}
