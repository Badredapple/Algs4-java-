import edu.princeton.cs.algs4.DirectedEdge;

/*
 * �ߵ��ɳ��㷨��relax��
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
 * �ߵ��ɳ��㷨
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
 *�������������ǻ���������˼��������������·�����㷨222222
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
