import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

/*
 * 边的松弛算法（relax）
 * private void relax(DirectedEdge e)
 * {
 * 		int v =e.from(), w=e.to();
 * 		if(distTo[w] =disTo[v]  +e.weight())
 * 		{
 * 			distTo[w] =distTo[v] +e.weight();
 * 			edgeTo[w]=e;
 * 		}
 * }
 * 
 * 边的松弛算法
 * private  void relax(EdgeWeightedDigraph G, int x)
 * {
 * 			for(DirectedEdge e: G.adj(v))
 * 			{   
 * 				int w =e.to();
 * 				if(distTo[w] > distTo[v] +e.weight())
 * 			{		
 * 				distTo[w] =distTo[v] +e.weight();
 * 			}
 * 		}
 * }
 * 		
 * 
 * 
 *下面这个问题就是基于这样的思想做出的求解最短路径的算法
 * 
 * 
 */
public class DijkstraSP {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;
	
	public DijkstraSP(EdgeWeightedDigraph G, int s)
	{
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		
		for(int v = 0;v<G.V();v++)
			distTo[v] = Double.POSITIVE_INFINITY ;
		distTo[s] = 0.0;
		
		pq.insert(s, 0.0);
		while(!pq.isEmpty())
			relax(G, pq.delMin());
			
	}

	private void relax(EdgeWeightedDigraph G, int v) {
		// TODO Auto-generated method stub
		for(DirectedEdge e: G.adj(v))
		{
			int w =e.to();
			if(distTo[w] > distTo[v]+e.weight())
			{
				distTo[w] = distTo[v] +e.weight();
				edgeTo[w] = e;
				if(pq.contains(w)) pq.changeKey(w, distTo[w]);
				else			   pq.insert(w, distTo[w]);
			}
		}
	}
	
	public double distTo(int v)
	{
		return distTo[v];
	}
	public boolean hasPathTo(int v)
	{
		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	public Iterable<DirectedEdge> pathTo(int v)
	{
		if(!hasPathTo(v))  return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for(DirectedEdge e = edgeTo[v]; e!=null; e= edgeTo[e.from()])
			path.push(e);
		return path;
		
	}
}
