import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.IndexMinPQ;

public class PrimMST {
	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	private IndexMinPQ<Double> pq;
	
	
	public PrimMST(EdgeWeightedGraph G)
	{
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		for(int v =0; v<G.V(); v++)
			distTo[v] =Double.POSITIVE_INFINITY;
		pq = new IndexMinPQ<Double>(G.V());
		
		distTo[0]=0.0;
		pq.insert(0,0.0);
		while(!pq.isEmpty())
			visit(G,pq.delMin());
	}


	private void visit(EdgeWeightedGraph G, int v) {
		// TODO Auto-generated method stub
		
		marked[v]=true;
		for(Edge e:G.adj(v))
		{
			int w = e.other(v);
			
			if(marked[w])  continue;
			if(e.weight() < distTo[w])
			{
				edgeTo[w] = e;
				
				distTo[w] = e.weight();
				if(pq.contains(w)) pq.changeKey(w, distTo[w]);//ԭ��change�������޸ĳ���changekey
				else 			   pq.insert(w, distTo[w]);
				
			}
			
		}
		
	}
	public Iterable<Edge> edges()
	{
		Bag<Edge> mst = new Bag<Edge>();
		for(int v =1;v < edgeTo.length;v++)
			mst.add(edgeTo[v]);
		return mst;
	}
	
	
}
