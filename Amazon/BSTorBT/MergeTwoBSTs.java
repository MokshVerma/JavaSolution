package Amazon.BSTorBT;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBSTs {

    class Node
    {
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    public void inOrder(List<Integer> list, Node root){
        if(root.left!=null)
            inOrder(list, root.left);
        list.add(root.data);
        if(root.right!=null)
            inOrder(list, root.right);
    }

    public List<Integer> merge(Node root1, Node root2){
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        inOrder(l1, root1);
        inOrder(l2, root2);
        List<Integer> list = new ArrayList<>();
        int i=0, j=0;
        while(i<l1.size() && j<l2.size()){
            if(l1.get(i)<l2.get(j)){
                list.add(l1.get(i));
                i++;
            } else if(l2.get(j)<l1.get(i)){
                list.add(l2.get(j));
                j++;
            } else{
                list.add(l1.get(i));
                list.add(l2.get(j));
                i++; j++;
            }
        }

        while(i<l1.size()){
            list.add(l1.get(i));
            i++;
        }
        while(j<l2.size()){
            list.add(l2.get(j));
            j++;
        }

        return list;
    }

}
