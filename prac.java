/*::::::::::::::::::::::::::::Selection Sort::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/

import java.util.*;
import java.lang.*;

public class Main{
    public static void selectionSort(int[] arr, int n ){  
         for(int i = 0; i< n ; i++){
             int mini = arr[i],ind = i;
             for(int j = i+1 ; j< n ; j++){
                 if(arr[j]<mini){
                     mini = arr[j];
                     ind = j ;
                 }
             }
             int t = arr[ind];
             arr[ind] = arr[i];
             arr[i] = t;
         }
    }  
    public static void  main(String args[]){
        System.out.println("Enter number of element in the array ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array ");        
        for(int i = 0 ;i < n; i++){
            arr[i] = sc.nextInt() ;
        }
        System.out.println("array ");        
        for(int i = 0 ;i < n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");   
        long t1 = System.currentTimeMillis();
        selectionSort(arr,n); 
        long t2 = System.currentTimeMillis();
        System.out.println("After sorting array ");        
        for(int i = 0 ;i < n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(t2-t1); 
    }
}
/*::::::::::::::::::::::::::::::QuickSort:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/

import java.util.*;
import java.lang.*;

public class Main{
    public static int partition(int[] arr, int lo , int hi   ){  
        int pivot = arr[lo];
        int i = lo , j = hi;
        while(i<j){
            while(arr[i]<=pivot && i<hi) i++;
            while(arr[j]>pivot && j>lo) j--;
            if(j>i){
                int t = arr[i];
                arr[i]= arr[j];
                arr[j]= t;
            }
        }
        int t = arr[lo];
        arr[lo]= arr[j];
        arr[j]= t;
        return j ;    
        
    }
    public static void QuickSort(int[] arr, int lo , int hi   ){  
         if(lo<hi){
             int part = partition(arr,lo,hi);
             QuickSort(arr,lo,part-1);
             QuickSort(arr,part+1,hi);
         }
    }  
    public static void  main(String args[]){
        System.out.println("Enter number of element in the array ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array ");        
        for(int i = 0 ;i < n; i++){
            arr[i] = sc.nextInt() ;
        }
        System.out.println("array ");        
        for(int i = 0 ;i < n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");   
        long t1 = System.currentTimeMillis();
        QuickSort(arr,0,n-1); 
        long t2 = System.currentTimeMillis();
        System.out.println("After sorting array ");        
        for(int i = 0 ;i < n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(t2-t1); 
    }
}

/*::::::::::::::::::::::::::::Merge Sort :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
import java.util.*;
import java.lang.*;

public class Main{
    public static void sort(int[] arr, int lo , int hi, int mid   ){  
        int i = lo , j = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        while(i<=mid && j<=hi){
            if(arr[i]<arr[j]){
                temp.add(arr[i++]);
            }else{
                temp.add(arr[j++]);
            }
        }
        while(i<=mid)temp.add(arr[i++]);
        while(j<=hi)temp.add(arr[j++]);
        int m = 0 ;
        for(int k = lo ; k <=hi; k++){
            arr[k] = temp.get(m++);
        }
    }
    public static void merge(int[] arr, int lo , int hi   ){  
         if(lo<hi){
             int mid = (lo+hi)/2;
             merge(arr,lo,mid);
             merge(arr,mid+1,hi);
             sort(arr,lo,hi,mid);
         }
    }  
    public static void  main(String args[]){
        System.out.println("Enter number of element in the array ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array ");        
        for(int i = 0 ;i < n; i++){
            arr[i] = sc.nextInt() ;
        }
        System.out.println("array ");        
        for(int i = 0 ;i < n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");   
        long t1 = System.currentTimeMillis();
        merge(arr,0,n-1); 
        long t2 = System.currentTimeMillis();
        System.out.println("After sorting array ");        
        for(int i = 0 ;i < n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(t2-t1); 
    }
}
/*::::::::::::::::::::DFS::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
import java.util.*;

public class Main {
    public static void dfs(int mat[][], int src, int n, int vis[]) {
        vis[src] = 1;
        for (int node = 1; node <= n; node++) {
            if (mat[src][node] == 1 && vis[node] != 1) {
                dfs(mat, node, n, vis);
            }
        }
    }
      public static void bfs(int mat[][], int src, int n, int vis[]) {
        Queue<Integer> q = new LinkedList<>();
        vis[src] = 1;
        q.add(src); 
        while (!q.isEmpty()) {
            int ele = q.poll();
            for (int node = 1; node <= n; node++) {
                if (mat[ele][node] == 1 && vis[node] != 1) {
                    vis[node] = 1; 
                    q.add(node);
                }
            }
        }
    }
    public static void main(String args[]) {
        System.out.println("Enter adj mat ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int src = 1;
        int vis[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            vis[i] = 0;
        }
        // dfs(arr, src, n, vis);
        bfs(arr, src, n, vis);
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.print(vis[i] + " ");
        }
    }
    /*
6 
0 1 0 0 0 0 
0 0 1 0 0 0 
0 0 0 0 1 1 
0 0 0 0 1 0 
0 0 0 0 0 1 
0 0 0 0 0 0
    */
}

/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
import java.util.*;

class pair{
    int prof, weight ; 
    public pair(int p , int w){
        prof = p ;
        weight = w ;
    }
    int getprof(){
        return prof;
    }
    int getweight(){
        return weight ;
    }
}

class cmp implements Comparator<pair>{
    public int compare(pair a,pair b) {
        double x = ((double)(a.getprof()))/((double)(a.getweight()));
        double y = ((double)(b.getprof()))/((double)(b.getweight()));
        if(x<y){
            return 1 ;
        }else {
            return -1 ;
        }
    }
}
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array ");
        int n = sc.nextInt();
        System.out.println("Enter Max Capacity ");
        int cap = sc.nextInt();
        pair arr[] = new pair[n];
        for(int i = 0 ;i < n ; i++){
            System.out.println("Enter Profit and weight");
            int p , w ;
            p = sc.nextInt();
            w = sc.nextInt();
            arr[i]=new pair(p,w);
        }
        for(int i = 0 ;i < n ; i++){
            System.out.println(arr[i].getprof()+" "+arr[i].getweight());
        }
        Arrays.sort(arr,new cmp());
        System.out.println(" ");
        for(int i = 0 ;i < n ; i++){
            System.out.println(arr[i].getprof()+" "+arr[i].getweight());
        }
                System.out.println(" ");

        double tot_prof= 0d ;
        for(int i = 0 ;i < n ; i++){
            int wei = arr[i].getweight();
            int pro = arr[i].getprof();
           if(cap-wei>=0){
               cap-=wei;
               tot_prof+=pro;
           }else{
               double f =((double)(pro))/((double)(wei)); 
               tot_prof +=(cap*f);
               break;   
           }
        }
                System.out.println(" ");

        System.out.println("Total Profit is :-" + tot_prof);

    }
}

/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
