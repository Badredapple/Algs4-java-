import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class LazyPrimeMST {
	private boolean[] marked;
	private Queue<Edge> mst;
	private MinPQ<Edge> pq;
	
	
	public LazyPrimeMST(EdgeWeightedGraph G)
	{
		pq = new MinPQ<Edge>();
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		
		visit(G,0);//假设G是量通的
		while(!pq.isEmpty())
		{
			Edge e = pq.delMin();
			
			int v= e.either(), w =e.other(v);
			if(marked[v]&& marked[w])  continue;
			mst.enqueue(e);
			if(!marked[v]) visit(G,v);
			if(!marked[w]) visit(G,w);	
		}
		
	}


	private void visit(EdgeWeightedGraph G, int v) {
		// TODO Auto-generated method stub
		marked[v] = true;
		for(Edge e:G.adj(v))
			if(!marked[e.other(v)]) pq.insert(e);
	}
	
	public Iterable<Edge> edges()
	{	return mst;		}

}//这个是书上的方法，另外一个LazyPrimMST是教材材料里面带有main函数的实现方法。
