import edu.princeton.cs.algs4.DirectedEdge;

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
 *下面这个问题就是基于这样的思想做出的求解最短路径的算法222222
 * 
 * 
 */
public class DijkstaSP {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;
	
	public DijkstraSP(EdgeWeightedDigraph G, int s)
	{
		
	}

}
