package Amazon.BSTorBT;

public class LargestBST {

     static class Node{
         int data;
         Node left, right;

         public Node(int d)
         {
             data = d;
             left = right = null;
         }

     }

     static class Info{
         boolean isBST;
         int maxSize;
         int min, max;

         public Info(boolean isBST, int maxSize, int min, int max){
             this.isBST = isBST;
             this.maxSize = maxSize;
             this.max = max;
             this.min = min;
         }
     }
     static Info helper(Node root){
         Info a1=null, a2 = null;
         if(root.left!=null)
            a1 = helper(root.left);
         if(root.right!=null)
            a2 = helper(root.right);

         if(root.left==null && root.right==null){
             return new Info(true, 1, root.data,root.data);
         } else if(root.left==null && root.data<a2.min){
             return new Info(a2.isBST, a2.isBST?a2.maxSize+1:a2.maxSize, root.data, a2.min);
         } else if(root.right==null && root.data>a1.max){
             return new Info(a1.isBST, a1.isBST?a1.maxSize+1:a1.maxSize, a1.max, root.data);

         } else{

             if(a1!=null && a2!=null && a1.isBST && a2.isBST && (a1.max<root.data && a2.min>root.data)){
                 return new Info(true, a1.maxSize+a2.maxSize+1, a1.min, a2.max);
             } else if(a1==null)
                 return new Info(false, a2.maxSize, 0, 0);
             else if(a2==null)
                 return new Info(false, a1.maxSize, 0, 0);
             else
                 return new Info(false, Math.max(a1.maxSize, a2.maxSize), 0, 0);
//             return new Info(a1.isBST&&a2.isBST&&(a1.max<root.data && a2.min>root.data), a1.isBST&&a2.isBST&&(a1.max<root.data && a2.min>root.data)?(a1.maxSize+a2.maxSize+1):Math.max(a1.maxSize, a2.maxSize), a1.max, a2.min);
         }


//         if(a1.isBST && a2.isBST && (a1.max<root.data && a2.min>root.data)){
//             return new Info(true, a1.maxSize+a2.maxSize+1, a1.min, a2.max);
//         } else if(root.left==null && root.right==null){
//             return new Info(true, 1, root.data, root.data);
//         } else{
//             return new Info(false, Math.max(a1.maxSize, a2.maxSize), 0, 0);
//         }
     }

     static int largestBst(Node root){

         return helper(root).maxSize;

     }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.right.left = new Node(2);
        root.right.right = new Node(2);
        root.left.left.left = new Node(3);

        System.out.println(largestBst(root));
    }

}
