//package Amazon.Searching;
//
//// { Driver Code Starts
////Initial Template for Java
//
//import java.util.*;
//import java.lang.*;
//import java.io.*;
//
//class MedianTwoSortedLists{
//    public static void main(String args[])
//    {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            int n = sc.nextInt();
//            int []a = new int[n];
//            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
//
//            int  m= sc.nextInt();
//            int []b = new int[m];
//            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
//
//            double res = new GFG().medianOfArrays(n, m, a, b);
//
//            if (res == (int)res) System.out.println ((int)res);
//            else System.out.println (res);
//        }
//
//    }
//}// } Driver Code Ends
//
//
////User function Template for Java
//
//class GFG {
//    static double medianOfArrays(int n, int m, int a[], int b[]){
//        if(n>m){
//            int[] temp = a;
//            int t = n;
//            n = m;
//            m = t;
//            a = b;
//            b = temp;
//        }
//        int i = n/2;
//        int j = (n+m+1)/2 - i;
//
//        while(true){
//            if(a[i-1]<=b[j] && b[j-1]<=a[i]){
//                if((n+m)%2==0){
//                    return (double)(Math.max(a[i-1], b[j-1])+Math.min(a[i], b[j])) /2;
//                } else {
//                    return (double)Math.max(a[i-1], b[j-1]);
//                }
//            } else if(a[i-1]>b[j]){
//                i =
//            }
//        }
//
//
//
//
//    }
//}