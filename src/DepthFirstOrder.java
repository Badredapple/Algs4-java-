
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

 

//这部分包括一部分深度优先遍历定点算法
//还有一部分基于深度优先算法的拓扑排序
/*
 * 先会说明拓扑的API和深度优先遍历顶点算法的
 * 		public class  Topological
 * 					  Topological(Graph G)
 * 			 boolean  isDAG()
 * 	Iterable<Integer> order()
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class DepthFirstOrder {
		private boolean[] marked;
		private Queue<Integer> pre;
		private Queue<Integer> post;
		private Stack<Integer> reversePost;
		
		
		public DepthFirstOrder(Digraph G)
		{
			pre    		= new Queue<Integer>();
			post    	= new Queue<Integer>();
			reversePost = new Stack<Integer>();
			marked  = new boolean[G.V()];
			
			for(int v=0;v < G.V();v++)
				if(!marked[v] )  dfs(G,v);
		}
		
		private void dfs(Digraph G, int v)
		{
			pre.enqueue(v);
			
			marked[v] =true;
			for(int w : G.adj(v))
				if(!marked[w])
					dfs(G,w);
			
			post.enqueue(v);
			reversePost.push(v);
			
		}
		
		public Iterable<Integer> pre()
		{	return pre;	}
		public Iterable<Integer> post()
		{	return post;	}
		public Iterable<Integer> reversePost()
		{	return reversePost;	}
		
		
}






