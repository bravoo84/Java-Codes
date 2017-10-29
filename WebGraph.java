package javacodes;
/**
 * This class is to represent a Graph and to perform some operation in Graph
 */
import java.util.*;
 

class WebGraph
{
    private int V;   
    
    private LinkedList<Integer> adj[];
   private int dist[]; 
   private int par[]; 
    
   /**
    * Constructor to create a WebGraph
    * @param v
    */
    WebGraph(int v)
    {
        V = v;
        
        adj = new LinkedList[v];
        
        dist=new int[v];
        
        par=new int[v];
        
        for (int i=0; i<v; ++i)
            
        {adj[i] = new LinkedList();
        }
    }
 
   /**
    * This is to add an edge in the WebGraph with Vertices v and Weight w
    * @param v
    * @param w
    */
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
 
   
    /**
     * This api performs Breadth First Search in (this)WebGraph
     * @param s
     */
    void BFS(int s)
    {
        
        boolean visited[] = new boolean[V];
        
        for(int i=0;i<V;i++)
            
        {dist[i]=Integer.MAX_VALUE;
        
        par[i]=-1;
        }
       
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
       
        visited[s]=true;
        
        dist[s]=0;
        
        queue.add(s);
 
        while (queue.size() != 0)
        {
           
            s = queue.poll();
          
            Iterator<Integer> i = adj[s].listIterator();
            
            while (i.hasNext())
            {
                int n = i.next();
                
                if (!visited[n])
                {
                    visited[n] = true;
                    
                    dist[n]=dist[s]+1;
                    
                    par[n]=s;
                    
                    queue.add(n);
                }
            }
        }
    }
    
    /**
	 * Thus api prints a path(showing all the vertices in between s and d
	 * vertices) from Source vertices s to Destination vertices d
	 * 
	 * @param s
	 * @param d
	 */
    void path(int s,int d)
    {
        BFS(s);
        
        System.out.print(d);
        
        int tmp=d;
        
        while(tmp!=-1&&tmp!=s){
            
        System.out.print("<-"+par[tmp]);
        
        tmp=par[tmp];
    }
        System.out.println("\nDistance form "+s+" to "+d+" is : "+dist[d]);
        
    }
    /**
     * This api prints the diameter of this WebGraph
     */
    void diameter()
    {
        int max=Integer.MIN_VALUE;
        
        for(int j=0;j<V;j++){
            
        BFS(j);
        
        for(int i=0;i<V;i++)
        {
            if(max<dist[i])
                
                max=dist[i];
        }}
        System.out.println("Diameter of Graph is : "+max);
    }
    
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        
        System.out.println("Enter number of vertices:");
        
        int v=in.nextInt();int u,e;
        
        WebGraph g = new WebGraph(v);
        
        System.out.println("Enter number of edges:");
        
        e=in.nextInt();
        
        System.out.println("Enter Edges (u,v)");
        
        for(int i=0;i<e;i++)
        {
            u=in.nextInt();
            
            v=in.nextInt();
            
            g.addEdge(u, v);
        }
       g.diameter();
       
        System.out.println("\nEnter source and destination to find min distance :");
        
        int s=in.nextInt();
        
        int d=in.nextInt();
        
        g.path(s,d);
    }
}
