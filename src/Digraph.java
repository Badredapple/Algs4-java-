import edu.princeton.cs.algs4.Bag;

//ÓĞÏòÍ¼µÄAPI
/*
 * public class Digrah
 * 				     Digrah(int V)
 * 				     Digrah(In in)
 * 				 int V()
 * 				 int E()
 * 				void addEdge(int v, int w)
 * Iterable<Integer> adj(int v)
 * 			Digraph	 resverse()
 * 			String   toString()
 * 
 * 
 * 
 * 
 */
public class Digraph {
	
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public Digraph(int V)
	{
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0; v < V; v++)
			adj[v] = new Bag<Integer>();	
	}
	
	public int V()	{	return V;	}
	public int E()	{	return E;	}
	
	public void addEdge(int v,int w)
	{
		adj[v].add(w);
		E++;
	}
	
	public Iterable<Integer> adj(int v)
	{		return adj[v];	}
	
	public Digraph	reverse()
	{
		Digraph R = new Digraph(V);
		for(int v =0;v < V;v++)
			for(int w:adj(v))
				R.addEdge(w, v);
		return R;
	}

}
