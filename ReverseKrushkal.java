
/*--- reverse cycle elimination of kruskal's algorithm---*/

import java.io.*;
import java.util.*;

class Graph
{
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; //Adjacency Lists

	void addEdge(int v,int w)
	{
		adj[v].add(w);
		adj[w].add(v);
	}
	void removeEdge(int v,int w){
		
		for(int i=0;i<adj[v].size();i++){
		int t=adj[v].get(i);
		if(t==w){
			adj[v].remove(i);
		}
		}
		
		for(int i=0;i<adj[w].size();i++){
			int t=adj[w].get(i);
			if(t==v){
				adj[w].remove(i);
			}
			}
		
	}

	boolean BFS(int s,int d)
	{
		boolean visited[] = new boolean[V];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s]=true;
		queue.add(s);

		while (queue.size() != 0)
		{
			
			s = queue.poll();
			if(s==d) return true;//cycle exist
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext())
			{
				int n = i.next();
				if (!visited[n])
				{
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		return false; //cycle doesnt exist
	}
	class Edge implements Comparable<Edge>{

		int src,dest,weight;
		@Override
		public int compareTo(Edge compareEdge) {
			return this.weight-compareEdge.weight;
		}
	}
	int E;
	Edge edge[];
	Graph(int v,int e){
		V=v;
		E=e;
		edge=new Edge[E];
		for(int i=0;i<e;i++){
			edge[i]=new Edge();
		}
		adj = new LinkedList[v];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList<Integer>();
	}
	
	void ReverseKruskal(){
		
		Edge result[]=new Edge[V];
		for(int i=0;i<V;i++){
			result[i]=new Edge();
		}
		
		Arrays.sort(edge);
		
		int i=0;
		int e=0;
		while(e<V-1){
			Edge next_edge=new Edge();
			next_edge=edge[E-i-1];
			i++;
			removeEdge(next_edge.src,next_edge.dest);
			
			if(!BFS(next_edge.src,next_edge.dest)){
				result[e++]=next_edge;
			}//else eliminate
		}
		
		System.out.println("Edge\t\tCorresponding edge weight");
		for(i=0;i<e;i++){
			System.out.println(result[i].src+"---"+result[i].dest+"\t\t"+result[i].weight);
		}
		
	}
}

public class ReverseKrushkal {
		public static void main(String[] args) {
			int V=6;
			int E=8;
			
			
			
			Graph graph=new Graph(V,E);
			
			graph.edge[0].src=0;
			graph.edge[0].dest=1;
			graph.edge[0].weight=4;
			graph.addEdge(0, 1);
			
			graph.edge[1].src = 1;
			graph.edge[1].dest = 2;
			graph.edge[1].weight = 8;
			graph.addEdge(1, 2);
			
			graph.edge[2].src = 1;
			graph.edge[2].dest = 4;
			graph.edge[2].weight = 11;
			graph.addEdge(1, 4);
			
			graph.edge[3].src = 0;
			graph.edge[3].dest = 4;
			graph.edge[3].weight = 8;
			graph.addEdge(0, 4);
			
			graph.edge[4].src = 5;
			graph.edge[4].dest = 2;
			graph.edge[4].weight = 2;
			graph.addEdge(5, 2);
			
			graph.edge[5].src = 5;
			graph.edge[5].dest = 3;
			graph.edge[5].weight = 6;
			graph.addEdge(5, 3);
						
			graph.edge[6].src = 4;
			graph.edge[6].dest = 5;
			graph.edge[6].weight = 7;
			graph.addEdge(4, 5);
						
			graph.edge[7].src = 4;
			graph.edge[7].dest = 3;
			graph.edge[7].weight = 1;
			graph.addEdge(4, 3);
			
			graph.ReverseKruskal();
		}
}
