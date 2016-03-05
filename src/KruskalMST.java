import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

//最小生成树的Kruskal算法
public class KruskalMST {
		private Queue<Edge> mst;
		
		public KruskalMST(EdgeWeightedGraph G)
		{
			mst = new Queue<Edge>();
			MinPQ<Edge> pq = new MinPQ<Edge>();
			for(Edge e:G.edges()) pq.insert(e);
			UF uf = new UF(G.V());
			
			while (!pq.isEmpty()&&mst.size()<G.V()-1)
			{
				Edge e= pq.delMin();
				int v =e.either(), w = e.other(v);
				if(uf.connected(v, w)) continue;
				uf.union(v,w);
			}
		}
		
		public Iterable<Edge> edges()
		{	return mst;	}
		  
		                      
}
