package Ai_main;
import java.util.*;

public class depth {
    private int V;
    private LinkedList<Integer>adj[];
    
    depth(int v){
        V=v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList();
        }
    }

    void addEdge(int v,int w){
        adj[v].add(w);
    }

    void DFSUtil(int v,boolean visited[]){
        visited[v]=true;
        System.out.println(v + " ");

        Iterator<Integer>i=adj[v].listIterator();
        while(i.hasNext()){
            int n =i.next();
            if(!visited[n]){
                DFSUtil(n, visited);
            }
        }
    }

    void dfs(int v){
        boolean visited[]=new boolean[V];
        DFSUtil(v, visited);
    }


    /*************/

    void bfs(int s){
        boolean visited[]=new boolean[V];
        LinkedList<Integer>queue= new LinkedList<Integer>();

        visited[s]=true;
        queue.add(s);

        while(queue.size()!=0){
              s= queue.poll();
             System.out.print(s +" ");

             Iterator<Integer>i = adj[s].listIterator();
             while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
             }


        }

    }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enterno of vertex");
    int n = sc.nextInt();

    System.out.println("enter no of edges");
    int e= sc.nextInt();
    
    depth g = new depth(n);
    System.out.println("enter the edges (S & D)");
    for(int i=0;i<e;i++){
        int a= sc.nextInt();
        int b = sc.nextInt();
        g.addEdge(a,b);
    }

    System.out.println("enter start vertex");
    int s= sc.nextInt();

    System.out.println("dfs traversal");
    g.dfs(s);
    System.out.println("bfs traversal");
    g.bfs(s);
  }    
}
