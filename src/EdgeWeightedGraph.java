import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

//���ۼ�Ȩ����ͼ����������
/*
 * ��Ȩ�صıߵ���������
 * edge.class ���Ѿ�ʵ�֣����Բο�Edge.class 
 * 
 * 
 * 
 * 
 * 
 */
public class EdgeWeightedGraph {
		private final int V;
		private int E;
		private Bag<Edge>[] adj;
		
		@SuppressWarnings("unchecked")
		public EdgeWeightedGraph(int V)
		{
			if(V<0) throw new IllegalArgumentException("please input a nonnegation");
			this.V = V;
			this.E = 0;
			adj = (Bag<Edge>[]) new Bag[V];
			for(int v =0; v < V; v++)
				adj[v] = new Bag<Edge>();
			
		}	
		
		public EdgeWeightedGraph(int V, int E) {
		      this(V);
		      if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
		      for (int i = 0; i < E; i++) {
		          int v = StdRandom.uniform(V);
		          int w = StdRandom.uniform(V);
		          double weight = Math.round(100 * StdRandom.uniform()) / 100.0;
		          Edge e = new Edge(v, w, weight);
		          addEdge(e);
		       }
		  }
		 
		 public EdgeWeightedGraph(In in) {
		        this(in.readInt());
		        int E = in.readInt();
		        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
		        for (int i = 0; i < E; i++) {
		            int v = in.readInt();
		            int w = in.readInt();
		            double weight = in.readDouble();
		            Edge e = new Edge(v, w, weight);
		            addEdge(e);
		        }
		 }
		public int V()	{	return V;	}
		public int E()	{	return E;	}
		
		public void addEdge(Edge e)
		{
			int v =e.either(),w = e.other(v);
			adj[v].add(e);
			adj[w].add(e);
			E++;
		}
		
		public Iterable<Edge> adj(int v)
		{
			return adj[v];
		}
		
		public Iterable<Edge> edges()
		{
			Bag<Edge> b = new Bag<Edge>();
			for(int v=0; v< V;v++)
				for(Edge e:adj[v])
					if(e.other(v)>v) b.add(e);
			return b;
		}
		
		
}
