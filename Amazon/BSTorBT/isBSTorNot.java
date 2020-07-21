package Amazon.BSTorBT;

public class isBSTorNot {

    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    public boolean helper(Node root, int low, int high){
        if(root!=null){
            if(root.data>=low && root.data<high){
                return helper(root.left, low, root.data) && helper(root.right, root.data, high);
            } else
                return false;
        }
        return true;
    }

    // return true if the given tree is a BST, else return false
    boolean isBST(Node root){
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

}
