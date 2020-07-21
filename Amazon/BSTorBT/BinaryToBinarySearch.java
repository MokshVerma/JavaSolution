package Amazon.BSTorBT;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryToBinarySearch {

    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node sortedListToBST(ArrayList<Integer> list, int i, int j){    //Sorted array to BST
            if(i==j){
                return new Node(list.get(i));
            } else if(i>j){
                return null;
            } else{
                int mid = (i+j)/2;
                Node temp = new Node(list.get(mid));
                temp.left = sortedListToBST(list, i, mid-1);
                temp.right = sortedListToBST(list, mid+1, j);
                return temp;
            }
    }

    Node binaryTreeToBST(Node root){    //Binary tree to BST
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Node curr = root;
        queue.add(curr);
        while(!queue.isEmpty()){
            curr = queue.remove();
            list.add(curr.data);
            if(curr.left!=null)
                queue.add(curr.left);
            if(curr.right!=null)
                queue.add(curr.right);
        }
        Collections.sort(list);
        return sortedListToBST(list, 0, list.size()-1);
    }


}
