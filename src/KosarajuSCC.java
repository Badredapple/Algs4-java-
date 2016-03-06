//使用Kosara算法的计算强联通分量的方法
public class KosarajuSCC {
		private boolean[] marked;
		private int[]  id;
		private int count;
		
		public KosarajuSCC(Digraph G)
		{
			marked = new boolean[G.V()];
			id = new int[G.V()];
			DepthFirstOrder order = new DepthFirstOrder(G.reverse());
			for(int s:order.reversePost())
				if(!marked[s])
				{	dfs(G,s); count++;	}
		}
		private void dfs(Digraph g, int v)
		{
			marked[v] = true;
			id[v] = count;
			for(int w:g.adj(v))
				if(!marked[w])
					dfs(g,w);
		}
		
		
		public boolean stronglyConnected(int v,int w)
		{
			return id[v] == id[w];
		}
		
		public int id(int v)
		{
			return id[v];
		}
		
		public int count()
		{	return count;	}
}
